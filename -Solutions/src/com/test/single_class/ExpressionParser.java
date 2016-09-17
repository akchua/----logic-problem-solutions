package com.test.single_class;

public class ExpressionParser
{
	private String input;
	
	public ExpressionParser(String input)
	{
		this.input = input;
	}
	
	public String getOutput()
	{
		String output = "";
		String[] temp = input.split("\n");
		
		double total;
		int count;
		int opCount;
		int[] digits;
		char[] operations;
		
		for(String i : temp)
		{
			outerLoop:
			if(i.length() % 2 == 1)
			{
				digits = new int[i.length() / 2 + 1];
				operations = new char[i.length() / 2];
				count = 0;
				opCount = 0;
				
				try
				{
					for(int j = 0; j < i.length(); j++)
					{
						if(i.charAt(j) == '+' || i.charAt(j) == '-' || i.charAt(j) == '*' || i.charAt(j) == '/')
						{
							operations[opCount++] = i.charAt(j);
						}
						
						else if(Character.isDigit(i.charAt(j)))
						{
							digits[count++] = i.charAt(j) - '0';
						}
						
						else
						{
							output += ("Invalid Input -> " + i + "\n");
							break outerLoop;
						}
					}
					
				}catch(IndexOutOfBoundsException e)
				{
					output += ("Invalid Input -> " + i + "\n");
					break outerLoop;
				}
				
				count = 0;
				total = digits[count];
				
				while(count < operations.length)
				{
					if(operations[count] == '+') total += (double) digits[++count];
					else if(operations[count] == '-') total -= (double) digits[++count];
					else if(operations[count] == '*') total *= (double) digits[++count];
					else if(operations[count] == '/') total /= (double) digits[++count];
				}
				
				output += ("Total: " + total + "\n");
			}
			
			else
			{
				output += ("Invalid Input -> " + i + "\n");
			}
		}
		
		return output;
	}
}
