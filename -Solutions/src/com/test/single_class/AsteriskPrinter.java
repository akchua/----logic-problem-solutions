package com.test.single_class;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class AsteriskPrinter
{
	private int width;
	private int coat;
	
	public AsteriskPrinter(int width, int coat)
	{
		if(width > 0 && coat > 0)
		{
			this.setWidth(width);
			this.setCoat(coat);
		}
		
		else
		{
			this.setWidth(1);
			this.setCoat(1);
		}
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setCoat(int coat)
	{
		this.coat = coat;
	}
	
	public String getOutput()
	{
		String output = "";
		
		for(int i = 0; i < (this.coat * 2 + 1); i++)
		{
			for(int j = 0; j < (this.coat * 2 + this.width); j++)
			{
				output += "*";
			}
			output += "\n";
		}
		
		return output;
	}
}