/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 19/09/2011
 */

/**Class responsible for finding references to fields and methods*/

package ufmg.crcs.properties.refactoringprojection;

import org.eclipse.jdt.core.*;
import org.eclipse.jdt.core.search.*;

abstract class SearchMatchesCollector 
{
	/**Collect references to a method using the Java search engine
	 * @param the method whose the references should be collected
	 * @return the search matches corresponding to the references to the given method
	 */
	public FieldReferenceMatch[] getMatches(IMethod method)
	{
		SearchPattern pattern=SearchPattern.createPattern(method,IJavaSearchConstants.REFERENCES); //A pattern to the search
		IJavaSearchScope scope=SearchEngine.createJavaSearchScope(new IJavaElement[] {method.getJavaProject()});
	}
	
	/**Collect references to a field using the Java search engine
	 * @param the field whose the references should be collected
	 * @return the search matches corresponding to the references to the given field
	 */
	public MethodReferenceMatch[] getMatches(IField field)
	{
		
	}
}
