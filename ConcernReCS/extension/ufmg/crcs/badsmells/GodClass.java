package ufmg.crcs.badsmells;

public class GodClass extends BadSmell
{
	private static final String NAME="God Class"; //The name of the bad smell
	
	/**
	 * Initializes the bad smell with a constant value for the name
	 */
	public GodClass(String source, String where)
	{
		super(NAME, source, where);
	}
}
