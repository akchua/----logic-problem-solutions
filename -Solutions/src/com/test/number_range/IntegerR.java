package com.test.number_range;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class IntegerR
{
	/**
	 * Reverses the decimal value of the specified integer
	 * @param toReverse the integer to be reversed
	 * @return the reversed integer
	 */
	public static int reverse(int toReverse)
	{
		int lastDigit = 0;
		int reverse = 0;
		
		while(toReverse != 0)
		{
			lastDigit = toReverse % 10;
			reverse = reverse * 10 + lastDigit;
			toReverse /= 10;
		}
		
		return reverse;
	}
}
