package com.test.doublet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class PathFinder
{
	private Graph graph;
	
	public PathFinder(Graph graph)
	{
		this.graph = graph;
	}
	
	public boolean tryBfs(String from, String to)
	{
		if(from.length() != to.length() || !(this.graph.contains(from) && this.graph.contains(to)))
		{
			return false;
		}
		
		return true;
	}
	
	public String bfs(String from, String to)
	{
		Queue<Node> q = new LinkedList<Node>();
		Node root;
		Node temp;
		
		this.graph.recycle();
		temp = this.graph.get(from);
		
		q.add(temp);
		temp.visit();
		this.graph.dump(temp);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			
			for(Node child : root.getChild())
			{
				if(!child.visited())
				{
					child.visit();
					this.graph.dump(child);
					child.setPathTo(root.getPathTo() + child.getName() + "\n");
					
					if(child.getName().equals(to))
					{
						return child.getPathTo();
					}
					
					q.add(child);
				}
			}
		}
		
		return "No Solution.\n";
	}
}
