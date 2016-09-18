package com.test.number_range;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class NumberRange
{
	// 0, one, two, three .... nine
	private static final int[] MAP1 = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
	// ten, eleven, twelve .... nineteen
	private static final int[] MAP2 = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
	// 0, ten (filler), twenty, thirty, forty .... ninety
	private static final int[] MAP3 = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};
	// 0, thousand, million, billion, trillion
	private static final int[] MAP4 = {0, 8, 7, 7, 8};
	// hundred
	private static final int HUNDRED = 7;
	
	private int start;
	private int end;
	
	/**
	 * Constructs a new number range with the specified start and end value
	 * @param start the first integer of the number range
	 * @param end the last integer of the number range
	 */
	public NumberRange(int start, int end)
	{
		if(end >= start)
		{
			this.setStart(start);
			this.setEnd(end);
		}
		else
		{
			this.setStart(end);
			this.setEnd(start);
		}
	}
	
	/**
	 * Sets the value of the first integer to the specified integer
	 * @param start the value to be set
	 */
	public void setStart(int start)
	{
		this.start = start;
	}
	
	/**
	 * Sets the value of the last integer to the specified integer
	 * @param end the value to be set
	 */
	public void setEnd(int end)
	{
		this.end = end;
	}
	
	/**
	 * Gets the value of the first integer
	 * @return the value of the first integer
	 */
	public int getStart()
	{
		return this.start;
	}
	
	/**
	 * Gets the value of the last integer
	 * @return the value of the last integer
	 */
	public int getEnd()
	{
		return this.end;
	}
	
	/**
	 * Counts the number of unique pairs of
	 * integer and their reverse whose sum is a palindrome
	 * in this number range.
	 * Also prints out all of the unique pairs and their sum
	 * @return the number of palindromic sum
	 */
	public int getPalindromicSumCount()
	{
		PalindromeChecker checker = new PalindromeChecker();
		int rev = 0;
		int sum = 0;
		int count = 0;
		
		for(int i = this.start; i <= this.end; i++)
		{
			rev = IntegerR.reverse(i);
			if(i <= rev || i % 10 == 0)
			{
				sum = i + rev;
				if(checker.check(Integer.toString(sum)) == true) 
				{
					//System.out.println(i + " + " + rev + " = " + sum);
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Counts the number of letters in the character form of this number range.
	 * i.e. (one, two, three, four)
	 * @return the number of letters
	 */
	public long getLetterCount()
	{
		long total = 0;
		int counter = 0;
		int current = 0;
		int temp = 0;
		
		for(int i = this.start; i <= this.end; i++)
		{
			current = i;
			counter = 0;
			
			do
			{
				if(current % 1000 != 0)
				{
					total += MAP4[counter];
				
					temp = current % 1000 / 100;
					if(temp != 0)
					{
						total += HUNDRED;
						total += MAP1[temp];
					}
					
					temp = current % 100 / 10;
					if(temp == 1)
					{
						total += MAP2[current % 10];
					}
					
					else
					{
						total += MAP3[temp];
						total += MAP1[current % 10];
					}
				}
				
				counter++;
				current /= 1000;
				
			}while(current != 0);
		}
		
		return total;
	}
}

