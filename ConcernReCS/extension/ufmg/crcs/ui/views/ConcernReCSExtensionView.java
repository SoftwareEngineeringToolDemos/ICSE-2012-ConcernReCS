package ufmg.crcs.ui.views;

import ufmg.crcs.ConcernReCS;
import ufmg.crcs.badsmells.*;
import ufmg.crcs.ui.actions.ExtensionRefreshAction;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class ConcernReCSExtensionView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "ufmg.crcs.views.ConcernReCSExtensionView";
	
	private ConcernReCSViewerComparator comparator; //The table sorter

	private TableViewer viewer;
	private CodeSmellFilter filter; //Filter for the search field
	private ExtensionRefreshAction refreshaction;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return new String[] { "One", "Two", "Three" };
		}
	}
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ConcernReCSExtensionView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		//Sets the layout
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		
		//Creates the search field
		Label search_label = new Label(parent, SWT.NONE);
		search_label.setText("Search: ");
		final Text search_text = new Text(parent, SWT.BORDER | SWT.SEARCH);
		search_text.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		createViewer(parent);

		//Sets the viewer sorter
		comparator= new ConcernReCSViewerComparator();
		viewer.setComparator(comparator);
		
		//Supports the case-sensitive search
		search_text.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent event) 
			{
				filter.setSearchText(search_text.getText());
				viewer.refresh();
			}
		});

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "ufmg.crcs.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}
	
	/**
	 * Creates the TableViewer 
	 * @param parent
	 */
	private void createViewer(Composite parent) 
	{
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		
		createColumns(parent, viewer);
		
		final Table table = viewer.getTable();
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		//Sets the viewer data source
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(ConcernReCSExtensionModelProvider.INSTANCE.initializeModelProvider(this));
		
		getSite().setSelectionProvider(viewer); // Make the selection available to other views

		// Layout the viewer
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
	}
	
	/**
	 * This will creates all the columns for the TableViewer
	 */
	private void createColumns(final Composite parent, final TableViewer viewer) 
	{
		String[] titles = { "Name", "Source" , "Where" }; //Columns tiltes
		int[] bounds = { 250, 180, 160 }; //Columns sizes

		// First column is for the name
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		
		col.setLabelProvider(new ColumnLabelProvider() 
			{
				public String getText(Object element) 
				{
					BadSmell smell = (BadSmell) element;
			
					return smell.getName();
				}
			}
		);
				
		// Second column is for the source
		col = createTableViewerColumn(titles[1], bounds[1], 1);
				
		col.setLabelProvider(new ColumnLabelProvider() 
			{
				public String getText(Object element) 
				{
					BadSmell smell = (BadSmell) element;
					
					return smell.getSource();
				}
			}
		);
				
		// Third column is for the where
		col = createTableViewerColumn(titles[2], bounds[2], 2);
				
		col.setLabelProvider(new ColumnLabelProvider() 
			{
				public String getText(Object element) 
				{
					BadSmell smell = (BadSmell) element;
							
					return smell.getWhere();
				}
			}
		);
	}

	/**
	 * Creates one column of the table
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound, final int column_number) 
	{
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		
		//Sets the column layout
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		column.addSelectionListener(getSelectionAdapter(column, column_number));
		
		return viewerColumn;
	}
	
	//Provides the widget to support the table sorter
	private SelectionAdapter getSelectionAdapter(final TableColumn column,final int index) 
	{
		SelectionAdapter selectionAdapter = new SelectionAdapter() 
		{
			public void widgetSelected(SelectionEvent event) 
			{
				comparator.setColumn(index);
		
				int direction = comparator.getDirection();
				
				viewer.getTable().setSortDirection(direction);
				viewer.getTable().setSortColumn(column);
				viewer.refresh();
			}
		};
		return selectionAdapter;
	}

	/**
	 * Updates the action buttons
	 */
	public void updateActionState()
	{
		boolean enabled = ConcernReCS.getDefault().isDirty(); //Indicates if the view content has changed
		
//		saveaction.setEnabled(enabled);

		getViewSite().getActionBars().updateActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ConcernReCSExtensionView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(refreshaction);
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(refreshaction);
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refreshaction);
		manager.add(action1);
		manager.add(action2);
	}

	private void makeActions() {
		refreshaction = new ExtensionRefreshAction(viewer) ;
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Extension View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public TableViewer getViewer()
	{
		return viewer;
	}
}