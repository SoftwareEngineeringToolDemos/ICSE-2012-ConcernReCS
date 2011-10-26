/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 14/10/2011
 */

/**Class for the Dedicated implementation constant code smell*/

package ufmg.crcs.smells;



class DedicatedImplementationConstant extends CodeSmell
{	
	private static final double ERROR_PRONENESS=0.75;
	
	/**Initializes the code smell with a constant value for the name and error_proneness*/
	DedicatedImplementationConstant(String concern,String source,String where)
	{
		super("Dedicated implementation constant","Duplicated crosscutting code",concern,ERROR_PRONENESS,source,where);
	}
}
