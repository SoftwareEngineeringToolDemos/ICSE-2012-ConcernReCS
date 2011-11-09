/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 10/14/2011
 */

/**The class responsible to find the Dedicated implementation constant code smell in the source code*/

package ufmg.crcs.smells;

import java.util.ArrayList;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

import ufmg.crcs.concernmapper.*;

public class DedicatedImplementationConstantFinder extends CodeSmellFinder
{
	private static final String CODE_SMELL_NAME="Dedicated Implementation Constant";
	
	public DedicatedImplementationConstantFinder()
	{
		super(CODE_SMELL_NAME);
	}
	
	/**
	 * Implements the algorithm to find the Dedicated implementation constant code smell
	 */
	protected ArrayList <CodeSmell> findCodeSmells(ArrayList<String> concerns)
	{
		ArrayList <CodeSmell> code_smells=new ArrayList <CodeSmell>();
		
		//Looks for the Dedicated implementation constant code smell in each of the selected concerns
		for(String concern:concerns)
		{
			ArrayList<IJavaElement> concern_elements=ConcernMapperInterface.getConcernElements(concern); //Elements added to the ConcernMapper plug-in
			
			//Looks for the code smells in all the elements of the concern
			for(IJavaElement element:concern_elements)
			{	
				try
				{
					//If the element is a constant class field
					if(element.getElementType()==field)
					{
						if(((IField)element).getConstant()!=null)
						{
							String source=element.getResource().getName(); //File in which this element is declared
							String where="Field "+element.getElementName(); //Which of the file elements this element is
						
							DedicatedImplementationConstant smell=new DedicatedImplementationConstant(concern,source,where);
						
							code_smells.add(smell); //Stores the code smell
						}
					}
				}
				catch(JavaModelException ecception)
				{
					return null;
				}
			}
		}
	
		return code_smells;
	}
}