package com.test.optimal_intelligence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Received: December 10, 2015
 * Started: December 10, 2015
 * Finished: December 13, 2015
 * @author Adrian Jasper K. Chua
 * 
 * This program simulates two bots playing against each other
 * 
 * Game Mechanics:
 * - given an array of integers
 * - on the first turn player 1 must take at least 1 integer from the left side (index 0) of the array
 * - on the next turn player 2 must take at least 1 integer from the right side (last index) of the array
 * - the game goes on until no integer is left on the array
 * - game can end in one turn
 * - the sum of the integers taken by a player is summed up and becomes the player's score
 * 
 * The program displays the moves taken by each side given that they are moving optimally
 * The program also displays the highest possible score for player 1
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		GameConsole console = new GameConsole();
		
		/*Scanner scanner = new Scanner(System.in);
		
		int choice;
		
		System.out.print("Choose a game type: \n"
				+ "[1] 0 Player (Simulation)\n"
				+ "[2] 1 Player (AI First)\n"
				+ "[3] 1 Player (Player First)\n"
				+ "[4] 2 Players\n\n"
				+ "*note boards used are from the input.txt file located in the project directory\n\n"
				+ "Enter choice here ---> ");
		
		choice = scanner.nextInt();
		
		System.out.println("");*/
		
		try
		{
			int size;
			int[] input;
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File("input.txt"));
			while(true)
			{
				size = scan.nextInt();
				if(size == 0) break;
				
				input = new int[size];
				
				for(int i = 0; i < size; i++)
				{
					input[i] = scan.nextInt();
				}
				
				System.out.println(Arrays.toString(input));
				
				console.setBoard(input);
				
				/*switch(choice)
				{
				case 1:
					console.setGameType(GameConsole.NOPLAYER);
					break;
				}*/
				
				console.setGameType(GameConsole.NOPLAYER);
				console.startGame();
			}
		}catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
	
		System.out.println("\nTook : " + ((System.nanoTime() - startTime) / 1000000000.0)+ " s");
	}
}
