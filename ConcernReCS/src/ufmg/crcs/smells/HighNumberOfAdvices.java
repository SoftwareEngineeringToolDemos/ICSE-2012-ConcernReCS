//Class for the High number of advices code smell

package ufmg.crcs.smells;

import java.util.*;

class HighNumberOfAdvices extends CodeSmell
{	
	ArrayList<AdviceMatch> advices; //Advices which compose the High number of advices code smell
	
	//Initializes the code smell with a constant value for the name and error_proneness_scale
	HighNumberOfAdvices(String concerns_names[],ArrayList<AdviceMatch> advices)
	{
		super("High Number of Advices",concerns_names,"Insert the scale description here"+": "+0);
		
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
