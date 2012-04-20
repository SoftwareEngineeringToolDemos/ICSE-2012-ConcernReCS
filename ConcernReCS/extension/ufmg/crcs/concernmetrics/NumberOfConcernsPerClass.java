package ufmg.crcs.concernmetrics;

import java.util.ArrayList;

import org.eclipse.jdt.core.IJavaElement;

import ufmg.crcs.concernmapper.*;

public class NumberOfConcernsPerClass 
{
	private int NCCvalue;
	
	
	public void setNCCvalue(String concern)
	{
		
		ArrayList<IJavaElement> concern_elements = ConcernMapperInterface.getConcernElements(concern);
		
		for (IJavaElement element : concern_elements)
		{
			if (isAType(element))
			{
				
			}
		}
	}
	
	public int getNCCvalue()
	{
		return NCCvalue;
	}
	
	private boolean isAType(IJavaElement element)
	{
		int type = 7;
		
		if (element.getElementType() == type)
		{
			return true;
		}
		
		else return false;
	}
}
