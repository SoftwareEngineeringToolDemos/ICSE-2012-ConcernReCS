package ufmg.crcs.badsmells;

public abstract class BadSmell 
{
	private String name; //The name of the bad smell
	private String source; //File in which the code smell was found
	private String where; //Name of the class related to the code smell
	
	protected BadSmell(String name, String source, String where)
	{
		setName(name);
		setSource(source);
		setWhere(where);
	}
	
	private void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	private void setSource(String source)
	{
		this.source=source;
	}
	
	public String getSource()
	{
		return source;
	}
	
	private void setWhere(String where)
	{
		this.where=where;
	}
	
	public String getWhere()
	{
		return where;
	}
}
