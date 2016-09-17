package com.test.optimal_intelligence;

import java.util.*;

public class GameConsole
{
	public static int NOPLAYER = 0;
	
	private Player player1;
	private Player player2;
	
	private int[] orgBoard;
	private int[] tempBoard;
	private int gameType;
	
	public GameConsole()
	{
		this.orgBoard = new int[] {0};
		this.gameType = 0;
	}
	
	public void setP1Bot()
	{
		player1 = new Player("Bot 1");
	}
	
	public void setP2Bot()
	{
		player2 = new Player("Bot 2");
	}
	
	public void startGame()
	{
		if(this.gameType == 0)
		{
			this.simulate();
		}
	}
	
	public void setGameType(int gameType)
	{
		this.gameType = gameType;
	}
	
	public void setBoard(int[] board)
	{
		this.orgBoard = board;
	}
	
	public void simulate()
	{
		this.setP1Bot();
		this.setP2Bot();
		
		player1.analyze(orgBoard);
		orgBoard = player1.getBoard();
		tempBoard = orgBoard;
		
		int p1MoveCount = 0;
		int p2MoveCount = 0;
		int moveCount = 0;
		boolean p1Last = false;
		
		//System.out.println(Arrays.toString(orgBoard) + "\n");
		
		while(p1MoveCount + p2MoveCount != orgBoard.length)
		{
			player1.updateBoard(tempBoard);
			
			moveCount = player1.move();
			p1MoveCount += moveCount;
			
			tempBoard = BoardUtil.reverseBoard(Arrays.copyOfRange(tempBoard, moveCount - 1, tempBoard.length - 1));
			
			if(p1MoveCount + p2MoveCount == orgBoard.length)
			{
				p1Last = true;
				break;
			}
			
			player2.updateBoard(tempBoard);
			
			moveCount = player2.move();
			p2MoveCount += moveCount;
			
			tempBoard = BoardUtil.reverseBoard(Arrays.copyOfRange(tempBoard, moveCount - 1, tempBoard.length - 1));
		}
		
		System.out.println("\nHighest score possible for player 1: " + Player.checkAlternateMoves(orgBoard[p1MoveCount - 1], p1Last) + "\n");
		
	}
}
