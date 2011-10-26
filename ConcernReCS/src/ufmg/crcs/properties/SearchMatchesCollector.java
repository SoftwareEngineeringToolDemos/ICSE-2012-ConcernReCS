/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 19/09/2011
 */

/**Class responsible for finding references to fields and methods*/

package ufmg.crcs.properties;

import java.util.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.*;
import org.eclipse.jdt.core.search.*;

public abstract class SearchMatchesCollector 
{
	/**Collect references to a method or a field using the Java search engine
	 * @param the method or field whose the references should be collected
	 * @return the search matches corresponding to the references to the given method or field
	 */
	public static ArrayList<SearchMatch> getMatches(IJavaElement element)
	{
		if(!((element instanceof IMethod)||(element instanceof IField))) return null; //In case the given element is not a method or a field
		
		SearchPattern pattern=SearchPattern.createPattern(element,IJavaSearchConstants.REFERENCES); //A pattern to the search, represented by references to the given method or field

		IJavaSearchScope scope=SearchEngine.createJavaSearchScope(new IJavaElement[] {element.getJavaProject()}); //The search scope, represented by the project which the method or field belongs
	
		MySearchRequestor requestor=new MySearchRequestor(); //Search requestor
		
		//Begins the search
		try
		{
			SearchEngine searchEngine = new SearchEngine(); //Creates a new search engine 
			
			searchEngine.search(pattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, scope, requestor, null); //Perform the search
		}
		catch(CoreException exception)
		{
			return null; //If an error occur during the search
		}
			
		return requestor.getSearchMatches(); //Return the collected search matches
	}
}
