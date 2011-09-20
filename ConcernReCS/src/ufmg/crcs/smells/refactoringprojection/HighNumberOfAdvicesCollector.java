/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/09/2011
 */

/**The class responsible to find the High Number of Advices code smell in the source code*/

package ufmg.crcs.smells.refactoringprojection;

import ufmg.crcs.smells.CodeSmell;
import ufmg.crcs.smells.CodeSmellCollector;
import ca.mcgill.cs.serg.cm.ConcernMapper;
import org.eclipse.jdt.core.IJavaElement;

class HighNumberOfAdvicesCollector extends CodeSmellCollector
{
	/**@return the code smell High Number of Advices if it has been found in the selected concerns or null otherwise*/
	public CodeSmell getCodeSmell(String[] concerns)
	{
		acodesmell=findHighNumberOfAdvices(concerns);
		
		return acodesmell;
	}

	/**Implements the algorithm to find the High Number of Advices code smell*/
	private HighNumberOfAdvices findHighNumberOfAdvices(String[] concerns)
	{
		//Looks for the High Number of Advices code smell in each of the selected concerns
		for(String concern:concerns)
		{
			IJavaElement[] elements=(IJavaElement [])ConcernMapper.getDefault().getConcernModel().getElements(concern).toArray(); //Elements in the concern
	
			//Determines the advices needed to refactor the accesses to an concern element
			for(IJavaElement element:elements)
			{/**@to_be_completed
				//If the element is a method
				if(element.getElementType()==method)
				{
			
				}
		
				//If the element is a class field
				else if(element.getElementType()==field)
				{
			
				}
			*/}
		}
	}
}