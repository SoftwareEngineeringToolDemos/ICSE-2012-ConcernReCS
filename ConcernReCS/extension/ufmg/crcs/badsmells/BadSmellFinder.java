package ufmg.crcs.badsmells;

import java.util.ArrayList;

import ufmg.crcs.smells.CodeSmell;

public abstract class BadSmellFinder 
{
	/**
	 * This method should be overwritten by the children of the BadSmellFinder class
	 * @param concerns
	 * @return an ArrayList of Bad Smells if them have been found in the selected concerns
	 */
	protected abstract ArrayList<BadSmell> findBadSmells(ArrayList<String> concerns);
}
