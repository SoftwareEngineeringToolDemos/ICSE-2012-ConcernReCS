/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/01/2011
 */

/**Main ConcernReCS view, to show the found code smells*/

package ufmg.crcs.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import ufmg.crcs.actions.*;

public class ConcernReCSView extends ViewPart 
{
	/**The ID of the view*/
	public static final String ID = "ufmg.crcs.views.ConcernReCSView";

	private TableViewer viewer;
	private SniffAction sniffaction;
	private SaveAction saveaction;
	private Action doubleClickAction;
	 
	class ViewContentProvider implements IStructuredContentProvider 
	{
		public void inputChanged(Viewer v, Object oldInput, Object newInput) 
		{
		}
		
		public void dispose() 
		{
		}
		
		public Object[] getElements(Object parent) 
		{
			return new String[] { "Code Smell A", "Code Smell B", "Code Smell C" };
		}
	}
	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider 
	{
		public String getColumnText(Object obj, int index) 
		{
			return getText(obj);
		}
		
		public Image getColumnImage(Object obj, int index) 
		{
			return getImage(obj);
		}
		
		public Image getImage(Object obj) 
		{
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	
	class NameSorter extends ViewerSorter 
	{
	}

	public ConcernReCSView() 
	{
	}

	public void createPartControl(Composite parent) 
	{
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() 
	{
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() 
		{
			public void menuAboutToShow(IMenuManager manager) 
			{
				ConcernReCSView.this.fillContextMenu(manager);
			}
		});
		
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() 
	{
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) 
	{
		manager.add(sniffaction);
		manager.add(new Separator());
		manager.add(saveaction);
	}

	private void fillContextMenu(IMenuManager manager) 
	{
		manager.add(sniffaction);
		manager.add(saveaction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) 
	{
		manager.add(sniffaction);
		manager.add(saveaction);
	}

	private void makeActions() 
	{
		sniffaction = new SniffAction(viewer) ;
		
		saveaction = new SaveAction(viewer); 
		
		doubleClickAction = new Action() 
		{
			public void run() 
			{
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() 
	{
		viewer.addDoubleClickListener(new IDoubleClickListener() 
		{
			public void doubleClick(DoubleClickEvent event) 
			{
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) 
	{
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"ConcernReCS",message);
	}

	public void setFocus() 
	{
		viewer.getControl().setFocus();
	}
}