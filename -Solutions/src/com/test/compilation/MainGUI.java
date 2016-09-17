package com.test.compilation;

import java.awt.Dimension;

import javax.swing.*;

public class MainGUI
{
	public static void main(String ... args)
	{
		JFrame frame = new CompilationGUI("Program Compilation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(370, 370));
		frame.setResizable(true);
		frame.setVisible(true);
	} 
}