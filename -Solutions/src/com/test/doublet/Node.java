package com.test.doublet;

import java.util.ArrayList;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class Node
{
	private boolean visited;
	private String name;
	private String pathTo;
	private ArrayList<Node> child;
	
	public Node(String name)
	{
		this.name = name;
		this.reset();
		this.child = new ArrayList<Node>();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setPathTo(String pathTo)
	{
		this.pathTo = pathTo;
	}
	
	public String getPathTo()
	{
		return this.pathTo;
	}
	
	public void addChild(Node newChild)
	{
		this.child.add(newChild);
		newChild.child.add(this);
	}
	
	public void reset()
	{
		this.visited = false;
		this.setPathTo(this.name + "\n");
	}
	
	public void visit()
	{
		this.visited = true;
	}
	
	public boolean visited()
	{
		return this.visited;
	}
	
	public ArrayList<Node> getChild()
	{
		return this.child;
	}
}
