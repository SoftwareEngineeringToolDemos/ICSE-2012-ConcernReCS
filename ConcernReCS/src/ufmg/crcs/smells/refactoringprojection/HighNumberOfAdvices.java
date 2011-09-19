/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

/**Class for the High number of advices code smell*/

package ufmg.crcs.smells.refactoringprojection;

import java.util.*;

import ufmg.crcs.smells.CodeSmell;


class HighNumberOfAdvices extends CodeSmell
{	
	ArrayList<AdviceMatch> advices; //Advices which compose the High number of advices code smell
	
	/**Initializes the code smell with a constant value for the name and error_proneness_scale*/
	HighNumberOfAdvices(String concerns_names[],ArrayList<AdviceMatch> advices)
	{
		super("High Number of Advices",concerns_names,0);
		
		setAdvices(advices);
	}
	
	private void setAdvices(ArrayList<AdviceMatch> advices)
	{
		this.advices=advices;
	}
	
	public AdviceMatch[] getAdvices()
	{
		return (AdviceMatch[])advices.toArray();
	}
}
