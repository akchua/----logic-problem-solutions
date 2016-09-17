package com.test.number_range;

public class PalindromeChecker
{
	/**
	 * Checks if the specified string is a palindrome
	 * @param toCheck the string to be checked
	 * @return true if the string is a palindrome
	 */
	public boolean check(String toCheck)
	{
		if(toCheck.length() == 0) return true;
		else if(toCheck.length() == 1) return true;
		else if(toCheck.charAt(0) == toCheck.charAt(toCheck.length() - 1))
		{
			if(toCheck.length() == 2) return true;
			else return check(toCheck.substring(1, toCheck.length() - 1));
		}
		else return false;
	}
}
