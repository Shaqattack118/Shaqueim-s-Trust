package Loans;

import java.io.*;
import java.util.Scanner;

public class LoansFile extends Loan 
{
	Scanner in = new Scanner(System.in);
	 
	FileWriter file = new FileWriter("Loans.txt", true);
	PrintWriter loanfile = new PrintWriter(file);
	
	public LoansFile()
	{
		Header();
		if(fileExists("Loans.txt") == true) 
		{
			/**
			 * Pass results from other methods to the excel doc in ze future 
			 */
		}
	}
	
	/** 
	 * Uses exception handling to return whether or not the file exists 
	 */
	
	public boolean fileExists(String fileName)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
		}
		catch(FileNotFoundException e)
		{
			return false;
		}
		catch(IOException e)
		{
			
		}
		return true;
	}
	
	
	/**
	 * Prints information to the text file
	 */
	
	public void Header()
	{
		loanfile.print("End report \t Monthly Interest Repayment \t Monthly Interest Payment \t Total Monthly Repayment \t Next Payment Due \t Amount Due \t Arrears \t Principal Repaid \t Interest Collected \t Loan Balance \t Active ");
	}
	
	 
	
	
}
