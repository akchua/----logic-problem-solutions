package com.test.path_finder;

import java.util.*;

public class Graph
{
	private Map<Integer, Map<Integer, Node>> library;
	private Map<Integer, Node> treasureList;
	private Stack<Node> dump;
	private int treasureCount;
	
	public Graph()
	{
		this.library = new HashMap<Integer, Map<Integer, Node>>();
		this.treasureList = new HashMap<Integer, Node>();
		this.dump = new Stack<Node>();
		this.treasureCount = 0;
	}
	
	public int getTreasureCount()
	{
		return this.treasureCount;
	}
	
	public Node get(int x, int y)
	{
		return this.library.get(x).get(y);
	}
	
	public Node getTreasure(int key)
	{
		return this.treasureList.get(key);
	}
	
	public void dump(Node usedNode)
	{
		this.dump.push(usedNode);
	}
	
	public void recycle()
	{
		while(!this.dump.empty())
		{
			this.dump.pop().reset();
		}
	}
	
	public boolean buildGraph(char[][] input)
	{
		Node temp;
		char[][] map = input;
		
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				if(map[i][j] == '#' || map[i][j] == '~') continue;
				
				else if(map[i][j] == '*')
				{
					try {
						if(map[i][j + 1] == '!' || map[i][j + 1] == '@') return false;
						if(map[i][j + 1] == '.') map[i][j + 1] = '#';
					} catch(IndexOutOfBoundsException e) {}
					
					try {
						if(map[i + 1][j] == '!' || map[i + 1][j] == '@') return false;
						if(map[i + 1][j] == '.') map[i + 1][j] = '#';
					} catch(IndexOutOfBoundsException e) {}

					try {
						if(map[i + 1][j + 1] == '!' || map[i + 1][j + 1] == '@') return false;
						if(map[i + 1][j + 1] == '.') map[i + 1][j + 1] = '#';
					} catch(IndexOutOfBoundsException e) {}
					
					try {
						if(map[i + 1][j - 1] == '!' || map[i + 1][j - 1] == '@') return false;
						if(map[i + 1][j - 1] == '.') map[i + 1][j - 1] = '#';
					} catch(IndexOutOfBoundsException e) {}
					
					continue;
				}
				
				else if(map[i][j] == '.' || map[i][j] == '!' || map[i][j] == '@')
				{
					try {
						if(map[i][j + 1] == '*')
						{
							if(map[i][j] == '!' || map[i][j] == '@') return false;
							else continue;
						}
					} catch(IndexOutOfBoundsException e) {}
					
					try {
						if(map[i + 1][j] == '*')
						{
							if(map[i][j] == '!' || map[i][j] == '@') return false;
							else continue;
						}
					} catch(IndexOutOfBoundsException e) {}
					
					try {
						if(map[i + 1][j + 1] == '*')
						{
							if(map[i][j] == '!' || map[i][j] == '@') return false;
							else continue;
						}
					} catch(IndexOutOfBoundsException e) {}
					
					try {
						if(map[i + 1][j - 1] == '*')
						{
							if(map[i][j] == '!' || map[i][j] == '@') return false;
							else continue;
						}
					} catch(IndexOutOfBoundsException e) {}
					
					if(!library.containsKey(i)) library.put(i, new HashMap<Integer, Node>());
					
					temp = new Node(map[i][j]);
					
					library.get(i).put(j, temp);
					try {
						temp.addChild(library.get(i - 1).get(j));
					} catch(NullPointerException e) {}
					
					try {
						temp.addChild(library.get(i).get(j - 1));
					} catch(NullPointerException e) {}
					
					if(map[i][j] == '!')
					{
						temp.setTreasureKey(++treasureCount);
						this.treasureList.put(treasureCount, temp);
					}
					else if(map[i][j] == '@')
					{
						if(this.treasureList.get(0) == null)
						{
							temp.setTreasureKey(0);
							this.treasureList.put(0, temp);
						}
						else return false;
					}
				}
				
				else
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
