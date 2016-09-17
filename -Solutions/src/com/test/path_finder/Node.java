package com.test.path_finder;

import java.util.*;

public class Node
{
	private boolean treasure;
	private boolean visited;
	private ArrayList<Node> child;
	private int stepsTo;
	private int treasureKey;
	
	public Node(char value)
	{
		if(value == '!') this.treasure = true;
		this.child = new ArrayList<Node>();
	}
	
	public void addChild(Node newChild)
	{
		if(newChild != null)
		{
			this.child.add(newChild);
			newChild.child.add(this);
		}
	}
	
	public ArrayList<Node> getChild()
	{
		return this.child;
	}
	
	public int getStepsTo()
	{
		return this.stepsTo;
	}
	
	public void setStepsTo(int steps)
	{
		this.stepsTo = steps;
	}
	
	public void removeTreasure()
	{
		this.treasure = false;
	}
	
	public boolean isTreasure()
	{
		return this.treasure;
	}
	
	public void setTreasureKey(int key)
	{
		this.treasureKey = key;
	}
	
	public int getTreasureKey()
	{
		return this.treasureKey;
	}
	
	public boolean visited()
	{
		return this.visited;
	}
	
	public void visit()
	{
		this.visited = true;
	}
	
	public void reset()
	{
		this.visited = false;
		this.stepsTo = 0;
	}
}
