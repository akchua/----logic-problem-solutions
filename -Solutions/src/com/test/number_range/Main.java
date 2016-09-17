package com.test.number_range;

/**
 * @author Adrian Jasper K. Chua
 * 
 * This program calculates the number of integers within a given range that when added to its reverse results to a palindromic number
 * (i.e. 102 + 201 = 303)
 * 102 and 201 is only counted as one if the range contains them both
 * 
 * Also included is the counting of 
 * 		letters in the word form of all the numbers in the range
 *
 */
public class Main
{
	public static void main(String... args)
	{	
		long startTime = System.nanoTime();
		
		int start = 10000;
		int end = 10000;
		
		NumberRange test = new NumberRange(start, end);
		
		System.out.println("Number of Palindromic Sum: " + test.getPalindromicSumCount());
		System.out.println("Number of letters: " + test.getLetterCount());
		
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000000.0 + " s"); 
	}
}
