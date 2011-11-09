/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/01/2011
 */

/**Class responsible to store and gather all the kinds of Code Smells*/

package ufmg.crcs.smells;

import java.util.*;
import ufmg.crcs.concernmapper.*;

public class CodeSmellsCollector 
{
	//Strings representing all the kinds of Code Smells
	private String DEDICATED_IMPLEMENTATION_CONSTANT="Dedicated Implementation Constant";
	
	private Hashtable<String, Boolean> smells = new Hashtable<String, Boolean>(); //Stores if each Code Smell should or not to be sought
	private ArrayList<String> concerns; //Stores the names of the concerns in which Code Smells should be sought
	
	/**
	 * All kinds of Code Smells should be sought in all the concerns by default 
	 */
	public CodeSmellsCollector ()
	{
		concerns=ConcernMapperInterface.getConcernNames();
		
		smells.put(DEDICATED_IMPLEMENTATION_CONSTANT,true);
	}
	
	/**
	 * @return an ArrayList with the names of all kinds of CodeSmells
	 */
	public ArrayList<String> getSmellsNames()
	{
		ArrayList<String> smells_names=new ArrayList<String>();
				
		//Adds the names of all kinds of Code Smells
		smells_names.add(DEDICATED_IMPLEMENTATION_CONSTANT);
		
		return smells_names;
	}
	
	/**
	 * Defines the kinds of Code Smells which the ConcernReCS plug-in should not look for
	 * @param Code Smells to be disabled
	 */
	public void disableSmells(ArrayList<String> disabled_smells)
	{
		for(String smell:disabled_smells)
		{
			smells.put(smell,false);
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
		for(String disabled_concern:disabled_concerns)
		{
			flag=0;
			
			for(String concern:concerns)
			{
				if(concern==disabled_concern) 
				{
					concerns.remove(concerns.indexOf(concern));
					
					flag=1;
				}
				
				if(flag==1)break;
			}
		}
	}
	
	public ArrayList<CodeSmell> collectCodeSmells()
	{	
		ArrayList<CodeSmell> found_smells=new ArrayList<CodeSmell>(); //Code Smells found in the source code
		
		//Collect each kind of Code Smell if it should bo collected
		if(smells.get(DEDICATED_IMPLEMENTATION_CONSTANT)==true)
		{
			DedicatedImplementationConstantFinder finder=new DedicatedImplementationConstantFinder();
			
			found_smells.addAll(finder.findCodeSmells(concerns));
		}
		
		return found_smells;
	}
}