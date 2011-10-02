/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 23/09/2011
 */

/**class responsible to crate ASTs from different sources*/

package ufmg.crcs.properties.refactoringprojection;

import java.util.ArrayList;
import org.eclipse.jdt.core.*;
import org.eclipse.jdt.core.search.*;
import org.eclipse.jdt.core.dom.*;


public abstract class ASTCreator 
{
	/**Generates the ASTs for a list of search matches
	 * @param The matches from which the ASTs should be created
	 * @return The related ASTs
	 */
	public ArrayList<CompilationUnit> getASTs(ArrayList<SearchMatch> matches)
	{
		ArrayList<CompilationUnit> asts=new ArrayList<CompilationUnit>(); //The ASTs of the given matches
		
		//Creates the AST for each search match
		for(SearchMatch match:matches)
		{
			IJavaElement source=getSource((IJavaElement)match.getElement()); //The source of the search match
			
			ASTParser parser = ASTParser.newParser(AST.JLS3); //AST parser
		
			//Sets the source of the AST
			if(source instanceof ICompilationUnit)
			{
				parser.setSource((ICompilationUnit)source);
			}
			else if(source instanceof IClassFile)
			{
				parser.setSource((IClassFile)source);
			}
			
			parser.setSourceRange(match.getOffset(), match.getLength()); //Sets the range of the AST
			
			asts.add((CompilationUnit)parser.createAST(null)); //Stores the AST
		}
	}
	
	/**Get the source of a given Java element
	 * @param The element from which the source should be extracted
	 * @return The source of the given element
	 */
	private IJavaElement getSource(IJavaElement element)
	{
		IJavaElement source; //The source of the given element
		
		source=element;
		
		//Get the ICompilationUnit or the IClassFile related to the source of the given element
		while((!(source instanceof ICompilationUnit))&&(!(source instanceof IClassFile))&&(source!=null))
		{
			source=element.getParent();
		}
		
		return source;
	}
}
