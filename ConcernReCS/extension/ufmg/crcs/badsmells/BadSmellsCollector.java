/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/01/2011
 */

/**Class responsible to store and gather all the kinds of Code Smells*/

package ufmg.crcs.badsmells;

import java.util.*;

import ufmg.crcs.concernmapper.*;

public class BadSmellsCollector 
{
	//Strings representing all the kinds of Code Smells
	private final String DIVERGENT_CHANGE = "Divergent Change";
	private final String GOD_CLASS = "God Class";
	private final String SHOTGUN_SURGERY = "Shotgun Surgery";
	
	private Hashtable<String, Boolean> badSmells = new Hashtable<String, Boolean>(); //Stores if each Code Smell should or not to be sought
	private ArrayList<String> concerns; //Stores the names of the concerns in which Bad Smells should be sought
	
	/**
	 * All kinds of Code Smells should be sought in all the concerns by default 
	 */
	public BadSmellsCollector()
	{
		concerns = ConcernMapperInterface.getConcernNames();
		
		badSmells.put(DIVERGENT_CHANGE, true);
		badSmells.put(GOD_CLASS, true);
		badSmells.put(SHOTGUN_SURGERY, true);
	}
	
	/**
	 * @return an ArrayList with the names of all kinds of CodeSmells
	 */
	public ArrayList<String> getBadSmellsNames()
	{
		ArrayList<String> bad_smells_names = new ArrayList<String>();
				
		//Adds the names of all kinds of Code Smells
		bad_smells_names.add(DIVERGENT_CHANGE);
		bad_smells_names.add(GOD_CLASS);
		bad_smells_names.add(SHOTGUN_SURGERY);
		
		return bad_smells_names;
	}
	
	/**
	 * Defines the kinds of Bad Smells which the ConcernReCS plug-in should not look for
	 * @param Code Smells to be disabled
	 */
	public void disableBadSmells(ArrayList<String> disabled_bad_smells)
	{
		for(String badSmell : disabled_bad_smells)
		{
			badSmells.put(badSmell, false);
		}
	}
	
	/**
	 * Defines the names of the concerns in which Code Smells should not be sought
	 * @param concerns to be disabled
	 */
	public void disableConcerns(ArrayList<String> disabled_concerns)
	{
		int flag; //Flag indicating that a concern has been already disabled. It avoids unnecessary iterations
		
		//Removes all the disabled concerns of the concerns in which Code Smells will be sought
		for(String disabled_concern : disabled_concerns)
		{
			flag=0;
			
			for (String concern : concerns)
			{
				if (concern == disabled_concern) 
				{
					concerns.remove(concerns.indexOf(concern));
					
					flag = 1;
				}
				
				if (flag == 1) {
					break;
				}
			}
		}
	}
	
	public ArrayList<BadSmell> collectBadSmells()
	{	
		ArrayList<BadSmell> found_bad_smells = new ArrayList<BadSmell>(); // Bad Smells found in the source code
		
		// Collect each kind of Bad Smell if it should be collected
		if (badSmells.get(DIVERGENT_CHANGE) == true)
		{
			DivergentChangeFinder finder = new DivergentChangeFinder();
			
			found_bad_smells.addAll(finder.findBadSmells(concerns));
		}
		
		if (badSmells.get(GOD_CLASS) == true)
		{
			System.out.printf("\n\nOK!\n\n");
			GodClassFinder finder = new GodClassFinder();
			
			found_bad_smells.addAll(finder.findBadSmells(concerns));
		}
		
		if(badSmells.get(SHOTGUN_SURGERY) == true)
		{
			ShotgunSurgeryFinder finder = new ShotgunSurgeryFinder();
			
			found_bad_smells.addAll(finder.findBadSmells(concerns));
		}
				
		return found_bad_smells;
	}
}