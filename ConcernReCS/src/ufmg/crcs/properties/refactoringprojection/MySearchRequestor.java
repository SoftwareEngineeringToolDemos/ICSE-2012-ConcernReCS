/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 20/09/2011
 */

/**class responsible to request references searches and collect references search matches*/

package ufmg.crcs.properties.refactoringprojection;

import java.util.*;
import org.eclipse.jdt.core.search.*;

class MySearchRequestor extends SearchRequestor
{
	ArrayList<ReferenceMatch> searchmatches; //Search matches
	
	/**Initializes the search matches ArrayList when the search begins*/
	public void beginReporting()
	{
		searchmatches=new ArrayList<ReferenceMatch>();
	}
	
	/**@return the search matches*/
	public ArrayList<ReferenceMatch> getSearchMatches()
	{
		return searchmatches;
	}
	
	/**Collect evry search match*/
	public void acceptSearchMatch(SearchMatch match)
	{
		searchmatches.add((ReferenceMatch)match);
	}
}
