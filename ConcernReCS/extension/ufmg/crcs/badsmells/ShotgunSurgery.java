package ufmg.crcs.badsmells;

public class ShotgunSurgery extends BadSmell
{
	private static final String NAME="Shotgun Surgery"; //The name of the bad smell
	
	/**
	 * Initializes the bad smell with a constant value for the name
	 */
	public ShotgunSurgery(String source, String where)
	{
		super(NAME, source, where);
	}
}
