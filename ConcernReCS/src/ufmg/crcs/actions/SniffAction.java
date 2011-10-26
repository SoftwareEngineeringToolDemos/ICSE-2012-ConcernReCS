/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

/**An action to find code smells in source code*/

package ufmg.crcs.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.dialogs.MessageDialog;
/**/import ca.mcgill.cs.serg.cm.ConcernMapper;
/**/import java.util.*;
/**/import org.eclipse.jdt.core.*;
/**/import org.eclipse.core.resources.*;
/**/import org.eclipse.jdt.core.search.*;
/**/import ufmg.crcs.actions.test.GenericVisitor;
/**/import ufmg.crcs.properties.*;
/**/import ufmg.crcs.smells.*;

import org.eclipse.jdt.core.dom.*;

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
		/**@test*/
		{		
			String concern_names[]=ConcernMapper.getDefault().getConcernModel().getConcernNames();

			DedicatedImplementationConstantCollector collector= new DedicatedImplementationConstantCollector();
			
			ArrayList <CodeSmell> code_smells=collector.getCodeSmells(concern_names);
			
			for(CodeSmell smell:code_smells)
			{
				showMessage("Concern: "+smell.getConcern()+"\n"+"Mistake: "+smell.getMistake()+"\n"+"Smell: "+smell.getName()+"\n"+"Source: "+smell.getSource()+"\n"+
						"Element: "+smell.getWhere()+"\n"+"Error proneness: "+smell.getErrorProneness());
			}
			
			
//			int j;
//			
//			for(j=0;j<concernnames.length;j++)
//			{
//				Set<Object> setelements=ConcernMapper.getDefault().getConcernModel().getElements(concernnames[j]);
//				
//				Object[] elements=setelements.toArray();		
//				
//				int i;
//				
//				for(i=0;i<elements.length;i++)
//				{	
//					showMessage(" "+((IJavaElement)elements[i]).getElementName()+
//							" "+((IJavaElement)elements[i]).getElementType());
//							
//					ArrayList<SearchMatch> matches=SearchMatchesCollector.getMatches((IJavaElement)elements[i]);
//					
//					ArrayList<Expression> asts=ASTCreator.getASTs(matches);
//					
//					for(Expression ast:asts)
//					{
//						//showMessage(""+ast.toString());
//						
//						GenericVisitor visitor=new GenericVisitor();
//						
//						visitor.setViewer(viewer);
//						
//						ast.accept(visitor);
//					}
//				}
//			}
		}
		
		showMessage("Sniff action executed");
	}

	private void showMessage(String message) 
	{
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"ConcernReCS",message);
	}
}
