package ufmg.crcs.badsmells;

public class DivergentChange extends BadSmell
{
	private static final String NAME="Divergent Change"; //The name of the bad smell
	
	/**
	 * Initializes the bad smell with a constant value for the name
	 */
	public DivergentChange(String source, String where)
	{
		super(NAME, source, where);
	}
}
