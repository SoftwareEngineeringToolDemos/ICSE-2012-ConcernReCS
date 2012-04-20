package ufmg.crcs.badsmells;

import java.util.ArrayList;

import org.eclipse.jdt.core.IJavaElement;

import ufmg.crcs.concernmapper.ConcernMapperInterface;

import ufmg.crcs.concernmorph.ConcernMorphInterface;


public class GodClassFinder extends BadSmellFinder
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
			
			if (isGodClass())
			{
//				ArrayList<IJavaElement> concern_elements = ConcernMapperInterface.getConcernElements(concern); //Elements added to the ConcernMapper plug-in
				
//				String source = element.getResource().getName(); //File in which this element is declared
				String source = "";  // TODO;
				String where = "";   // TODO;
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
		if (concernMorph.getCDOvalue() == 3)
		{
			return true;
		}
		
		else return false;
	}
}
