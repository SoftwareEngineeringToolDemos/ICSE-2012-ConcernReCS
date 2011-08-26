//An action to find code smells in source code

package ufmg.crcs.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.dialogs.MessageDialog;
/**/import ca.mcgill.cs.serg.cm.ConcernMapper;
/**/import java.util.*;
/**/import org.eclipse.jdt.core.*;

public class SniffAction extends Action
{
	private TableViewer viewer;
	
	public SniffAction(TableViewer viewer)
	{
		this.viewer=viewer;
		setText("Sniff");
		setToolTipText("Sniff tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}
	
	public void run() 
	{
		/**/String concernnames[]=ConcernMapper.getDefault().getConcernModel().getConcernNames();
		
		int j;
		for(j=0;j<concernnames.length;j++)
		{
			/**/Set<Object> setelements=ConcernMapper.getDefault().getConcernModel().getElements(concernnames[j]);
			/**/Object[] elements=setelements.toArray();		
			int i;
			for(i=0;i<elements.length;i++)showMessage(" "+((IJavaElement)elements[i]).getElementName());
		}
		
		showMessage("Sniff action executed");
	}

	private void showMessage(String message) 
	{
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"ConcernReCS",message);
	}
}
