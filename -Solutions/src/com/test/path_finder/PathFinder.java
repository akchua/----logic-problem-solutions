package com.test.path_finder;

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
	private DistanceMatrix distance;
	
	public PathFinder(Graph graph)
	{
		this.graph = graph;
		distance = new DistanceMatrix(this.graph.getTreasureCount());
	}
	
	public int getMinSteps()
	{
		BranchAndBound bb = new BranchAndBound(this.distance, 0);
		
		return bb.run();
	}
	
	public boolean routeTreasures()
	{
		for(int i = 0; i < this.graph.getTreasureCount(); i++)
		{
			this.distance.setRoot(i);
			if(this.bfs(this.graph.getTreasure(i), this.graph.getTreasureCount() - i)) 
			{
				continue;
			}
			else return false;
		}
		
		return true;
	}
	
	public boolean bfs(Node from, int treasureCount)
	{
		Queue<Node> q = new LinkedList<Node>();
		Node root;
		int treasureFound = 0;
		
		this.graph.recycle();
		
		q.add(from);
		from.visit();
		this.graph.dump(from);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			
			for(Node child : root.getChild())
			{
				if(!child.visited())
				{
					child.visit();
					this.graph.dump(child);
					child.setStepsTo(root.getStepsTo() + 1);
					
					if(child.isTreasure())
					{
						treasureFound++;
						this.distance.add(child.getTreasureKey(), child.getStepsTo());
						if(treasureFound >= treasureCount)
						{
							from.removeTreasure();
							return true;
						}
					}
					
					q.add(child);
				}
			}
		}
		
		return false;
	}
}
