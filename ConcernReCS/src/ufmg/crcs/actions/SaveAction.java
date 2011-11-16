/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/01/2011
 */

/**An action to save the found code smells*/

package ufmg.crcs.actions;

import org.eclipse.jface.action.Action;
//import org.eclipse.ui.ISharedImages;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;

//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.OperationCanceledException;
//import org.eclipse.jface.action.Action;
//import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.ui.PlatformUI;
//
//import ca.mcgill.cs.serg.cm.ConcernMapper;
//import ca.mcgill.cs.serg.cm.model.io.ModelIOException;
//import ca.mcgill.cs.serg.cm.model.io.ModelWriter;
//import ca.mcgill.cs.serg.cm.ui.ProblemManager;
//import ca.mcgill.cs.serg.cm.views.ConcernMapperView;

public class SaveAction extends Action
{
	private TableViewer viewer;
	
//    private ConcernMapperView aView;
    
//	/**
//	 * @param pView The view containing the action.
//	 */
	public SaveAction( TableViewer viewer )
	{
//	    aView = pView;
//		setText( ConcernMapper.getResourceString( "actions.SaveAction.Label") );
//		setImageDescriptor( ConcernMapper.imageDescriptorFromPlugin( ConcernMapper.ID_PLUGIN, "icons/save.gif")); 
//		setDisabledImageDescriptor( ConcernMapper.imageDescriptorFromPlugin( ConcernMapper.ID_PLUGIN, "icons/saved.gif")); 
//		setToolTipText( ConcernMapper.getResourceString( "actions.SaveAction.ToolTip" ) ); 
	
		this.viewer=viewer;
	}
	
//	/**
//	 * @see org.eclipse.jface.action.IAction#run()
//	 */
//	public void run()
//	{
//		IFile lFile = ConcernMapper.getDefault().getDefaultResource();
//		if( lFile == null)
//		{
//			new SaveAsAction( aView ).run();
//			return;
//		}
//		try
//		{
//			lFile.getParent().refreshLocal( IResource.DEPTH_ONE, null);
//		}
//		catch(CoreException lException)
//		{
//			ProblemManager.reportException( lException );
//		}
//		catch(OperationCanceledException lException)
//		{
//			ProblemManager.reportException( lException );
//		}
//		if( !lFile.exists() )
//		{
//			new SaveAsAction( aView ).run();
//			return;
//		}
//		try
//		{
//			ModelWriter lWriter = new ModelWriter( ConcernMapper.getDefault().getConcernModel() );
//			lWriter.write( lFile );
//		}
//		catch( ModelIOException lException )
//		{
//		    MessageDialog.openError( PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
//					ConcernMapper.getResourceString( "actions.SaveAction.ErrorLabel"),
//					ConcernMapper.getResourceString( "actions.SaveAction.ErrorMessage") + " " + lException.getMessage());
//			return;
//		}
//		
//		// TODO: Clean this up.  The save actions should not know about the view.
//		ConcernMapper.getDefault().resetDirty();
//		if(aView != null)
//		{
//			aView.updateActionState();
//		}
//	}
}
