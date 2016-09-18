package com.test.path_finder;

import java.util.HashSet;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class BranchAndBound
{
	private DistanceMatrix distance;
	private int startPoint;
	private int minSteps;
	
	public BranchAndBound(DistanceMatrix distance, int startPoint)
	{
		this.distance = distance;
		this.startPoint = startPoint;
		this.minSteps = Integer.MAX_VALUE;
	}
	
	public int run()
	{
		HashSet<Integer> start = new HashSet<Integer>();
		start.add(this.startPoint);
		
		branch(this.startPoint, 0, start);
		
		return this.minSteps;
	}
	
	public void branch(int from, int currentSteps, HashSet<Integer> path)
	{
		if(path.size() == this.distance.getSize())
		{	
			if(currentSteps + distance.get(from, startPoint) < this.minSteps) this.minSteps = currentSteps + distance.get(from, startPoint);
		}
		else
		{
			for(int i = 0; i < distance.getSize(); i++)
			{
				if(!path.contains(i))
				{
					path.add(i);
					branch(i, currentSteps + distance.get(from, i), path);
					path.remove(i);
				}
			}
		}
	}
}
