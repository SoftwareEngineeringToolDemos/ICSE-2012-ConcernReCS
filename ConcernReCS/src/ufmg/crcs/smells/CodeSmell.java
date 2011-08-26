//Abstract class for code smells

package ufmg.crcs.smells;

abstract class CodeSmell 
{
	private String name; //The name of the code smell
	private String concerns_names[]; //Names of the concerns related to the code smell
	private String error_proneness_scale; //Error-proneness of the code smell
	
	CodeSmell(String name,String concerns_names[],String error_proneness_scale)
	{
		setName(name);
		setConcernsNames(concerns_names);
		setErrorPronenessScale(error_proneness_scale);
	}
	
	private void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	private void setConcernsNames(String concerns_names[])
	{
		this.concerns_names=concerns_names;
	}
	
	public String[] getConcernsNames()
	{
		return concerns_names;
	}
	
	private void setErrorPronenessScale(String error_proneness_scale)
	{
		this.error_proneness_scale=error_proneness_scale;
	}
	
	public String getErrorPronenessScale()
	{
		return error_proneness_scale;
	}
}