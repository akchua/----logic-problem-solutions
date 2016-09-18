package com.test.doublet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class Graph
{
	private Map<String, Node> library;
	private Stack<Node> dump;
	
	public Graph()
	{
		library = new HashMap<String, Node>();
		dump = new Stack<Node>();
	}
	
	public void buildGraph(ArrayList<String> input)
	{
		String base;
		String toCompare;
		
		for(int i = 0; i < input.size(); i++)
		{
			for(int j = i + 1; j < input.size(); j++)
			{
				base = input.get(i);
				toCompare = input.get(j);
				
				if(this.compare(base, toCompare, 1))
				{
					this.library.get(base).addChild(library.get(toCompare));
				}
			}
		}
	}
	
	public boolean contains(String key)
	{
		if(this.library.containsKey(key)) return true;
		else return false;
	}
	
	public Node get(String key)
	{
		return this.library.get(key);
	}
	
	public void addNode(String nodeName)
	{
		this.library.put(nodeName, new Node(nodeName));
	}
	
	public boolean compare(String base, String toCompare, int maxError)
	{
		if(maxError == -1) return false;
		
		else if(base.isEmpty())
		{
			if(maxError == 0) return true;
			else return false;
		}
		
		if(base.charAt(0) != toCompare.charAt(0))
		{
			return compare(base.substring(1, base.length()), toCompare.substring(1, toCompare.length()), --maxError);
		}
		
		return compare(base.substring(1, base.length()), toCompare.substring(1, toCompare.length()), maxError);
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
}
