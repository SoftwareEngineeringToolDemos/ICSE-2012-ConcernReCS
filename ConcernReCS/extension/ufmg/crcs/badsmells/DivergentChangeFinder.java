package ufmg.crcs.badsmells;

import java.util.ArrayList;

import org.eclipse.jdt.core.IJavaElement;

import ufmg.crcs.concernmapper.ConcernMapperInterface;


public class DivergentChangeFinder extends BadSmellFinder
{
	/**
	 * Implements the algorithm to find the Shotgun Surgery bad smell
	 */
	protected ArrayList <BadSmell> findBadSmells(ArrayList<String> concerns)
	{
		ArrayList <BadSmell> bad_smells = new ArrayList <BadSmell>();
		
		for (String concern : concerns) 
		{	
			// setMetrics(concern);
			
			if (isDivergentChange())
			{
				String source = "TODO";  // TODO;
				String where = "TODO";   // TODO;
				DivergentChange divergentChange = new DivergentChange(source, where); 
				
				bad_smells.add(divergentChange);
			}
		}
		
		return bad_smells;
	}
	
	private void setMetrics(String concern)
	{
		// TODO.
	}
	
	private boolean isDivergentChange()
	{
		// TODO.
		return false;
	}
}
