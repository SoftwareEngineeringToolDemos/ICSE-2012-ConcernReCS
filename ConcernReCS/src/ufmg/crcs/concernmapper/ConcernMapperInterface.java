/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 31/10/2011
 */

/**This class works as interface between ConcernReCS and the ConcernMapper plug-in*/

package ufmg.crcs.concernmapper;

import ca.mcgill.cs.serg.cm.*;
import org.eclipse.jdt.core.*;

public abstract class ConcernMapperInterface 
{
	/**
	 * @return the names of all the concerns
	 */
	public static String[] getConcernNames()
	{
		String[] concerns; //Concerns added to the ConcernMapper plug-in
		
		concerns=ConcernMapper.getDefault().getConcernModel().getConcernNames();
	
		return concerns;
	}
	
	/**
	 * Returns all the elements of a given concern
	 * @param concern
	 * @return an array with the elements
	 */
	public static IJavaElement[] getConcernElements(String concern)
	{
		int i; //Iterator
		
		Object[] obj_elements; //Elements of the given concern as simple objects
		
		obj_elements=ConcernMapper.getDefault().getConcernModel().getElements(concern).toArray();

		IJavaElement[] elements=new IJavaElement[obj_elements.length]; //Elements of the given concern as Java elements
		
		//Converts each element in the concern from type Object to IJavaElement
		for(i=0;i<obj_elements.length;i++)
		{
			elements[i]=(IJavaElement)obj_elements[i];
		}
		
		return elements;
	}
}