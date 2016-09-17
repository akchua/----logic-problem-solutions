package com.test.optimal_intelligence;

import java.util.Stack;

public class Player
{
	private static Stack<Integer> memory3 = new Stack<Integer>();
	private static boolean firstMove;
	
	private String name;
	private int[] board;
	private int[] memory;
	
	public Player(String name)
	{
		this.name = name;
		Player.firstMove = true;
	}
	
	public void analyze(int[] board)
	{
		this.board = new int[board.length];
		
		int total = 0;
		int temp = 0;
		
		for(int i : board)
		{
			total += i;
		}
		
		for(int i = 0; i < board.length; i++)
		{
			temp += board[i];
			this.board[i] = temp * 2 - total;
		}
	}
	
	public void updateBoard(int[] newBoard)
	{
		this.board = newBoard;
	}
	
	public int move()
	{
		if(this.board.length == 1)
		{
			memory3.push(0);
			memory3.push(this.board[0]);
			this.showMove(0);
			return 1;
		}
		
		int temp = 0;
		
		if(firstMove)
		{
			temp = this.checkFar();
			
			if(temp != -1)
			{
				this.showMove(temp);
				return temp + 1;
			}
			
			firstMove = false;
		}
		
		else this.peekFar();
		
		temp = this.makeMove();
		
		this.showMove(temp);
		return temp + 1;
	}
	
	/*public int move(int move)
	{
		this.showMove(move - 1);
		return move;
	}*/
	
	private int checkFar()
	{
		int index = 0;
		this.peekFar();
		
		if(this.board[this.board.length - 1] > this.board[this.board.length - 2])
		{
			index = this.board.length - 1;
		}
		
		else
		{
			index = this.board.length - 2;
		}
		
		for(int j = 0; j < this.board.length - 2; j++)
		{
			if(this.board[j] > this.board[index]) return -1;
		}
		
		return index;
	}
	
	private void peekFar()
	{
		if(this.board[this.board.length - 1] > this.board[this.board.length - 2])
		{
			memory3.push(this.board.length - 1);
			memory3.push(this.board[this.board.length - 1]);
		}
		
		else
		{
			memory3.push(this.board.length - 2);
			memory3.push(this.board[this.board.length - 2]);
		}
	}
	
	private void checkNear()
	{
		int temp = 0;
		
		memory = new int[this.board.length - 2];
		
		for(int i = 0; i < this.board.length - 2; i++)
		{
			temp = (this.board.length - (i + 1)) / 2;
            memory[i] = this.board[i];
			
			for(int j = 0; j <= temp; j++)
			{
				if(this.board[i + j] < memory[i]) memory[i] = this.board[i + j];
			}
		}
	}
	
	private int makeMove()
	{
		int index = 0;
		
		this.checkNear();
		
		for(int i = 0; i < memory.length; i++)
		{
			if(memory[i] > memory[index]) index = i;
		}
		
		return index;
	}
	
	public static int checkAlternateMoves(int bestMove, boolean p1Last)
	{
		int temp = 0;
		String moves = "";
		
		if(p1Last)
		{
			memory3.pop();
			memory3.pop();
			moves += "Bot 1 forced undo\n";
		}
		
		while(!memory3.empty())
		{
			temp = memory3.pop();
			
			if(-temp < bestMove)
			{
				bestMove = -temp;
				moves += "Bot 2 undo\n";
				moves += "Bot 2 takes " + (memory3.pop() + 1) + "\n";
				System.out.print(moves);
				moves = "Bot 2 forced undo\n";
			}
			
			else
			{
				memory3.pop();
				moves += "Bot 2 forced undo\n";
			}
			
			temp = memory3.pop();
			
			if(temp > bestMove)
			{
				bestMove = temp;
				moves += "Bot 1 undo\n";
				moves += "Bot 1 takes " + (memory3.pop() + 1) + "\n";
				System.out.print(moves);
				moves = "Bot 1 forced undo\n";
			}
			
			else
			{
				memory3.pop();
				moves += "Bot 1 forced undo\n";
			}
		}
		
		return bestMove;
	}
	
	private void showMove(int move)
	{
		System.out.println(this.name + " takes " + (move + 1));
	}
	
	public int[] getBoard()
	{
		return this.board;
	}
}
