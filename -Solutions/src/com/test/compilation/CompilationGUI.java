package com.test.compilation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.test.number_range.NumberRange;
import com.test.single_class.AsteriskPrinter;
import com.test.single_class.ExpressionParser;

/**
 * 
 * @author Adrian Jasper K. Chua
 *
 */
public class CompilationGUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JPanel screen;
	private JPanel inputArea;
	private JPanel prog1;
	private JPanel prog2;
	private JPanel prog3;
	private JPanel prog4;
	
	private JTextArea display;
	private JLabel status;
	
	private JTextArea inputArea1;
	private JTextArea inputArea2;
	private JTextArea inputArea3;
	private JTextArea inputArea4;
	private JTextArea inputArea5;
	private JTextArea inputArea6;
	private JTextArea inputArea7;
	
	private long startTime;
	
	private NumberRange range;
	private AsteriskPrinter printer;
	private ExpressionParser parser;
	
	public CompilationGUI(String title)
	{
		super(title);
		
		Container content = this.getContentPane();
		
		content.setFocusable(true);
		
		setScreen();
		content.add(BorderLayout.CENTER, screen);
		
		setInputArea();
		content.add(BorderLayout.SOUTH, inputArea);
	}
	
	private void setInputArea()
	{
		inputArea = new JPanel();
		
		inputArea.setLayout(new GridLayout(4, 1));
		
		setProg1();
		setProg2();
		setProg3();
		setProg4();
		
		inputArea.add(prog1);
		inputArea.add(prog2);
		inputArea.add(prog3);
		inputArea.add(prog4);
	}
	
	private void setProg1()
	{
		prog1 = new JPanel();
		
		prog1.setLayout(new BorderLayout());
		
		JPanel prog1South = new JPanel();
		
		prog1South.setLayout(new FlowLayout());
		
		JButton run = new JButton("run");
		run.addActionListener(this);
		run.setPreferredSize(new Dimension(100, 20));
		
		inputArea1 = new JTextArea(1, 7);
		inputArea2 = new JTextArea(1, 7);
		JLabel title = new JLabel("Palindromic Sum Counter");
		JLabel input1 = new JLabel("From: ");
		input1.setLabelFor(inputArea1);
		JLabel input2 = new JLabel("To: ");
		input2.setLabelFor(inputArea2);
		
		prog1South.add(input1);
		prog1South.add(inputArea1);
		prog1South.add(input2);
		prog1South.add(inputArea2);
		
		prog1.add(BorderLayout.NORTH, title);
		prog1.add(BorderLayout.CENTER, prog1South);
		prog1.add(BorderLayout.EAST, run);
	}
	
	private void setProg2()
	{
		prog2 = new JPanel();
		
		prog2.setLayout(new BorderLayout());
		
		JPanel prog2South = new JPanel();
		
		prog2South.setLayout(new FlowLayout());
		
		JButton run = new JButton(" run ");
		run.addActionListener(this);
		run.setPreferredSize(new Dimension(100, 20));
		
		inputArea3 = new JTextArea(1, 7);
		inputArea4 = new JTextArea(1, 7);
		JLabel title = new JLabel("Letter Counter");
		JLabel input3 = new JLabel("From: ");
		input3.setLabelFor(inputArea3);
		JLabel input4 = new JLabel("To: ");
		input4.setLabelFor(inputArea4);
		
		prog2South.add(input3);
		prog2South.add(inputArea3);
		prog2South.add(input4);
		prog2South.add(inputArea4);
		
		prog2.add(BorderLayout.NORTH, title);
		prog2.add(BorderLayout.CENTER, prog2South);
		prog2.add(BorderLayout.EAST, run);
	}
	
	private void setProg3()
	{
		prog3 = new JPanel();
		
		prog3.setLayout(new BorderLayout());
		
		JPanel prog3South = new JPanel();
		
		prog3South.setLayout(new FlowLayout());
		
		JButton run = new JButton("  run  ");
		run.addActionListener(this);
		run.setPreferredSize(new Dimension(100, 20));
		
		inputArea5 = new JTextArea(1, 7);
		inputArea6 = new JTextArea(1, 7);
		JLabel title = new JLabel("Asterisk Printer");
		JLabel input5 = new JLabel("Width: ");
		input5.setLabelFor(inputArea5);
		JLabel input6 = new JLabel("Coat: ");
		input6.setLabelFor(inputArea6);
		
		prog3South.add(input5);
		prog3South.add(inputArea5);
		prog3South.add(input6);
		prog3South.add(inputArea6);
		
		prog3.add(BorderLayout.NORTH, title);
		prog3.add(BorderLayout.CENTER, prog3South);
		prog3.add(BorderLayout.EAST, run);
	}
	
	private void setProg4()
	{
		prog4 = new JPanel();
		
		prog4.setLayout(new BorderLayout());
		
		JPanel prog4South = new JPanel();
		
		prog4South.setLayout(new FlowLayout());
		
		JButton run = new JButton("   run   ");
		run.addActionListener(this);
		run.setPreferredSize(new Dimension(100, 20));
		
		inputArea7 = new JTextArea(1, 14);
		JLabel title = new JLabel("Expression Parser");
		JLabel input7 = new JLabel("Expression: ");
		input7.setLabelFor(inputArea7);
		
		prog4South.add(input7);
		prog4South.add(inputArea7);
		
		prog4.add(BorderLayout.NORTH, title);
		prog4.add(BorderLayout.CENTER, prog4South);
		prog4.add(BorderLayout.EAST, run);
	}
	
	private void setScreen()
	{
		screen = new JPanel();
		
		screen.setLayout(new BorderLayout());
		
		display = new JTextArea();
		status = new JLabel();
		
		display.setEnabled(false);
		display.setDisabledTextColor(Color.BLACK);
		
		screen.add(BorderLayout.CENTER, display);
		screen.add(BorderLayout.SOUTH, status);
	}
	
	public void toPerform(String command)
	{
		if(command == "run")
		{
			String in1 = inputArea1.getText();
			String in2 = inputArea2.getText();
			
			try
			{
				startTime = System.nanoTime();
				range = new NumberRange(Integer.parseInt(in1), Integer.parseInt(in2));
				display.setText("Output: " + range.getPalindromicSumCount());
				status.setText("Run Time: " + Double.toString((System.nanoTime() - startTime) / 1000000000.0) + " s");
			}catch(NumberFormatException e)
			{
				writeStatus("Invalid Parameters");
			}
		}
		
		else if(command == " run ")
		{
			String in3 = inputArea3.getText();
			String in4 = inputArea4.getText();
			
			try
			{
				startTime = System.nanoTime();
				range = new NumberRange(Integer.parseInt(in3), Integer.parseInt(in4));
				display.setText("Output: " + range.getLetterCount());
				status.setText("Run Time: " + Double.toString((System.nanoTime() - startTime) / 1000000000.0) + " s");
			}catch(NumberFormatException e)
			{
				writeStatus("Invalid Parameters");
			}
		}
		
		else if(command == "  run  ")
		{
			String in5 = inputArea5.getText();
			String in6 = inputArea6.getText();
			
			try
			{
				startTime = System.nanoTime();
				printer = new AsteriskPrinter(Integer.parseInt(in5), Integer.parseInt(in6));
				display.setText("Output:\n" + printer.getOutput());
				status.setText("Run Time: " + Double.toString((System.nanoTime() - startTime) / 1000000000.0) + " s");
			}catch(NumberFormatException e)
			{
				writeStatus("Invalid Parameters");
			}
		}
		
		else
		{
			String in7 = inputArea7.getText();

			startTime = System.nanoTime();
			parser = new ExpressionParser(in7);
			display.setText("Output:\n" + parser.getOutput());
			status.setText("Run Time: " + Double.toString((System.nanoTime() - startTime) / 1000000000.0) + " s");
		}
	}
	
	public void clearStatus()
	{
		this.status.setText("");
	}
	
	public void writeStatus(String status)
	{
		this.status.setText(status);
	}

	@Override
	public void actionPerformed(ActionEvent a)
	{
		clearStatus();
		toPerform(a.getActionCommand());
	}
}
