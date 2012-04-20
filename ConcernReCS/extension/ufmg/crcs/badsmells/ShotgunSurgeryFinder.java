package ufmg.crcs.badsmells;

import java.util.ArrayList;

import org.eclipse.jdt.core.IJavaElement;

import ufmg.crcs.concernmapper.ConcernMapperInterface;

import ufmg.crcs.concernmorph.ConcernMorphInterface;


public class ShotgunSurgeryFinder extends BadSmellFinder
{
	private ConcernMorphInterface concernMorph = new ConcernMorphInterface();
	
	/**
	 * Implements the algorithm to find the Shotgun Surgery bad smell
	 */
	protected ArrayList <BadSmell> findBadSmells(ArrayList<String> concerns)
	{
		ArrayList <BadSmell> bad_smells = new ArrayList <BadSmell>();
		
		for (String concern : concerns) 
		{	
			setMetrics(concern);
			
			if (isShotgunSurgery())
			{
				String source = "";  // TODO.
				String where = "";	 // TODO.	
				ShotgunSurgery shotgunSurgery = new ShotgunSurgery(source, where);
				
				bad_smells.add(shotgunSurgery);
			}
		}
		
		return bad_smells;
	}
	
	private void setMetrics(String concern)
	{
		concernMorph.setCDCvalue(concern);
	}
	
	private boolean isShotgunSurgery()
	{
		if (concernMorph.getCDCvalue() == 3)
		{
			return true;
		}
		
		else return false;
	}
}
