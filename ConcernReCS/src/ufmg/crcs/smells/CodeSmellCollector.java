/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

/**The class responsible for collect code smells in source code*/

package ufmg.crcs.smells;

import java.util.ArrayList;

public class CodeSmellCollector 
{
	protected final int field=8; //Constant value used by the Java Model to identify a field
	protected final int method=9; //Constant value used by the Java Model to identify a method
	protected ArrayList <CodeSmell> codesmells; //Code smells found in the source code
	
	/**@return the code smells if them have been found in the selected concerns
	 * @param concerns in which the code smell should be sought
	 */
	public ArrayList <CodeSmell> getCodeSmells(String concerns[])
	{
		return codesmells;
	}
}
