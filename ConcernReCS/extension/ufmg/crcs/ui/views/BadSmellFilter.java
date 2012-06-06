package ufmg.crcs.ui.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import ufmg.crcs.badsmells.BadSmell;

public class BadSmellFilter extends ViewerFilter
{
	private String search_string; //String representing the search

	public void setSearchText(String search_string) 
	{
		this.search_string = ".*" + search_string + ".*"; // Search text must be a substring of the text in the view
	}

	/**
	 * Verifies if the text being sought matches at least one property of the Code Smells being shown in the view
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) 
	{
		//If the string being sought is empty
		if (search_string == null || search_string.length() == 0) 
		{
			return true;
		}
		
		BadSmell bad_smell = (BadSmell) element;
		
		//Verifies the name
		if (bad_smell.getName().matches(search_string)) 
		{
			return true;
		}
		
		//Verifies the source
		if (bad_smell.getSource().matches(search_string)) 
		{
			return true;
		}
	
		//Verifies the where
		if (bad_smell.getWhere().matches(search_string)) 
		{
			return true;
		}

		return false;
	}
}
