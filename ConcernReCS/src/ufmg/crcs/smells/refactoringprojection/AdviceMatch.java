/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

/**Class to represent a set of concern parts which can be refactored to the same advice*/

package ufmg.crcs.smells.refactoringprojection;

import org.eclipse.jdt.core.search.SearchMatch;
import java.util.*;

class AdviceMatch
{
	ArrayList<SearchMatch> advice; //Concern parts which can be refactored to the same advice
	
	AdviceMatch(ArrayList<SearchMatch> advice)
	{
		setAdvice(advice);
	}
	
	private void setAdvice(ArrayList<SearchMatch> advice)
	{
		this.advice=advice;
	}
}
