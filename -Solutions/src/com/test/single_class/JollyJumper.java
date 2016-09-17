package com.test.single_class;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Received: December 17, 2015
 * Started: January 3, 2016
 * Finished: January 3, 2016
 * @author Adrian Jasper K. Chua
 *
 */
public class JollyJumper
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		int count;
		int temp;
		int[] input;
		boolean[] check;
		
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File("jollyJumperInput.txt"));
			
			outerloop:
			while(scan.hasNextLine())
			{
				count = scan.nextInt();
				check = new boolean[count];
				input = new int[count];
				
				for(int i = 0; i < count; i++)
				{
					input[i] = scan.nextInt();
				}
				
				for(int i = 0; i < count - 1; i++)
				{
					temp = Math.abs(input[i] - input[i + 1]);
					
					if(temp == 0 || temp >= count || check[temp])
					{
						System.out.println("Not jolly");
						continue outerloop;
					}
					
					check[temp] = true;
				}
				
				System.out.println("Jolly");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		System.out.println("Took: " + ((System.nanoTime() - startTime) / 1000000000.0) + " s");
	}
}
