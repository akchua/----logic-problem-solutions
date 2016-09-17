package com.test.path_finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Received: December 14, 2015
 * Started: December 15, 2015
 * Finished: January 2, 2016
 * @author Adrian Jasper K. Chua
 * 
 * This program takes a series of characters in a 2d matrix and parses it to a map
 * The program then determines the smallest number of moves to get all of the treasures in the map
 * 
 * Character Representations:
 * 		. - moving to it is allowed
 * 		~ - water, moving to it is NOT allowed
 * 		! - treasure
 * 		# - blocked, moving to it is NOT allowed
 * 		* - barbarians, all 8 adjacent tiles are blocked (refer to #)
 * 		@ - starting point
 * 
 * The program outputs -1 if at least one treasure is unreachable
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		int height;
		int width;
		char[][] input;
		Graph gb;
		PathFinder pf;
		
		try {
			@SuppressWarnings("resource")
			Scanner scan= new Scanner(new File("pathFinderInput.txt"));
			
			while(true)
			{
				gb = new Graph();
				
				height = scan.nextInt();
				if(height == 0) break;
				width = scan.nextInt();
				scan.nextLine();
				
				input = new char[height][width];
				
				for(int i = 0; i < height; i++)
				{
					input[i] = scan.nextLine().toCharArray();
				}
				
				if(gb.buildGraph(input))
				{
					pf = new PathFinder(gb);
					
					if(pf.routeTreasures())
					{
						System.out.println(pf.getMinSteps());
					}
					
					else
					{
						System.out.println("-1");
					}
				}
				
				else
				{
					System.out.println("-1");
				}
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		System.out.println("Took: " + ((System.nanoTime() - startTime) / 1000000000.0) + " s");
	}
}
