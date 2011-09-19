/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

/**The  abstract class responsible for collect code smells in source code*/

package ufmg.crcs.smells;

public class CodeSmellCollector 
{
	protected final int field=8; //Constant value used by the Java Model to identify a field
	protected final int method=9; //Constant value used by the Java Model to identify a method
	protected CodeSmell acodesmell; //Code smell found in the source code
	
	/**@return the code smell if it has been found in the selected concerns
	 * @param concerns in which the code smell should be sought*/
	public CodeSmell getCodeSmell(String concerns[])
	{
		return acodesmell;
	}
}
