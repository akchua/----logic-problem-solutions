package com.test.path_finder;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class DistanceMatrix
{
	private int[][] matrix;
	private int root;
	
	public DistanceMatrix(int size)
	{
		this.matrix = new int[size + 1][size + 1];
	}
	
	public void setRoot(int root)
	{
		this.root = root;
	}
	
	public void add(int to, int value)
	{
		this.matrix[this.root][to] = value;
		this.matrix[to][this.root] = value;
	}
	
	public int get(int from, int to)
	{
		return this.matrix[from][to];
	}
	
	public int getSize()
	{
		return this.matrix[0].length;
	}
}
