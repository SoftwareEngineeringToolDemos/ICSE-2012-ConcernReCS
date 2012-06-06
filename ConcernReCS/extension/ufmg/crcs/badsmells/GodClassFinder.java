package ufmg.crcs.badsmells;

import java.util.ArrayList;

import ufmg.crcs.concernmorph.ConcernMorphInterface;


public class GodClassFinder extends BadSmellFinder
{
	private ConcernMorphInterface concernMorph = new ConcernMorphInterface();
	
	/**
	 * Implements the algorithm to find the God Class bad smell
	 */
	protected ArrayList <BadSmell> findBadSmells(ArrayList<String> concerns)
	{
		ArrayList <BadSmell> bad_smells = new ArrayList <BadSmell>();
		
		for (String concern : concerns) 
		{	
			setMetrics(concern);
			
			if (isGodClass())
			{
				String source = "TEST";  // TODO;
				String where = "TEST";   // TODO;
				GodClass godClass = new GodClass(source, where); 
				
				bad_smells.add(godClass);
			}
		}
		
		return bad_smells;
	}
	
	private void setMetrics(String concern)
	{
		concernMorph.setCDOvalue(concern);
	}
	
	private boolean isGodClass() 
	{
		if (concernMorph.getCDOvalue() >= 0)
		{
			return true;
		}
		
		else {
			return false;
		}
	}
}
