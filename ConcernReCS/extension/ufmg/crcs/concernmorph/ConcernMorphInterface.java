package ufmg.crcs.concernmorph;

import lancs.concerns.metrics.*;

public class ConcernMorphInterface 
{
	private int CDCvalue;
	private int CDOvalue;
	
	public void setCDCvalue(String concernName) 
	{
		CDCvalue = MetricsCollector.getCollector().getConcernMeasure(concernName, MetricsCollector.CDC).getValue();
	}
	
	public int getCDCvalue() 
	{
		return CDCvalue;
	}
	
	public void setCDOvalue(String concernName)
	{
		CDOvalue = MetricsCollector.getCollector().getConcernMeasure(concernName, MetricsCollector.CO).getValue();
	}
	
	public int getCDOvalue()
	{
		return CDOvalue;
	}
}
