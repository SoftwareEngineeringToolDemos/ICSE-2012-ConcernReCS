//The class responsible for collect code smells in source code

package ufmg.crcs.smells;

import java.util.*;

class CodeSmellsCollector 
{
	ArrayList<CodeSmell> codesmells=new ArrayList<CodeSmell>(); //Code smells found in the source code
	
	//Retur the code smells found in the source code
	public CodeSmell[] getCodeSmells()
	{
		CodeSmell acodesmell;  //Stores a code smell before it be added to the code smells list
		
		//Adds a code smell to the list only if it has been found in the source code
		if((acodesmell=findHighNumberOfAdvices())!=null)codesmells.add(acodesmell);
		
		return (CodeSmell[])codesmells.toArray();
	}
	
	/*To be completed*/
	private CodeSmell findHighNumberOfAdvices()
	{
		/*Algorithms to find high number of advices*/return null;/*Delete this expression*/
	}
}
