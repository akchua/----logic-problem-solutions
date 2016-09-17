package com.test.doublet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Received: December 17, 2015
 * Started: December 20, 2015
 * Finished: December 21, 2015
 * @author Adrian Jasper K. Chua
 * 
 * This program accepts the inputs:
 * 		dictionary of words
 * 		source word
 * 		destination word
 * 
 * The program determines the shortest path from the source word to the destination word
 * A path is said to be valid when the source word changes only one letter at every step
 * 		and that the new word is existing in the given dictionary of words
 * 		until the source word becomes the destination word
 * 
 */
public class Main
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		Map<Integer, ArrayList<String>> inputMap = new HashMap<Integer, ArrayList<String>>();
		Graph gb = new Graph();
		String temp = " ";
		String[] input = new String[2];
		
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File("doubletInput.txt"));
			
			while(true)
			{
				temp = scan.nextLine();
				if(temp.isEmpty()) break;
				
				if(!inputMap.containsKey(temp.length()))
				{
					inputMap.put(temp.length(), new ArrayList<String>());
				}
				
				if(!gb.contains(temp))
				{
					inputMap.get(temp.length()).add(temp);
					gb.addNode(temp);
				}
			}
			
			PathFinder pf = new PathFinder(gb);
			
			while(scan.hasNextLine())
			{
				temp = scan.nextLine();
				input = temp.split(" ");
				
				if(pf.tryBfs(input[0], input[1]))
				{
					if(input[0].length() == 1 || input[0].equals(input[1]))
					{
						System.out.println(input[0] + "\n" + input[1] + "\n");
						continue;
					}
					
					if(inputMap.containsKey(input[0].length()))
					{
						gb.buildGraph(inputMap.get(input[0].length()));
						inputMap.remove(input[0].length());
					}
					
					System.out.println(pf.bfs(input[0], input[1]));
				}
				
				else
				{
					System.out.println("No Solution.\n");
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		System.out.println("Took: " + ((System.nanoTime() - startTime) / 1000000000.0) + " s");
	}
}
