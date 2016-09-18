package com.test.optimal_intelligence;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class BoardUtil
{
	public static int[] reverseBoard(int[] toRev)
	{
		int[] rev = new int[toRev.length];
		int count = toRev.length - 1;
		
		for(int i : toRev)
		{
			rev[count--] = -i;
		}
		
		return rev;
	}
}
