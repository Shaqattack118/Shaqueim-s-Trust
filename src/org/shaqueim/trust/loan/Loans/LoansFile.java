package Loans;

import java.io.*;
import java.util.Scanner;

public class LoansFile extends Loan 
{
	Scanner in = new Scanner(System.in);
	 
	FileWriter file = new FileWriter("Loans.xlsxl", true);
	PrintWriter loanfile = new PrintWriter(file);
	
	
	/*
	 * Used to create new excel file 
	 */
	public LoansFile()
	{
		Header();
		if(fileExists("Loans.xlsxl") == true) 
		{
			/**
			 * Pass results from other methods to the excel doc 
			 */
		}
	}
	
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
	
	public void Header()
	{
		loanfile.print("End report \t Monthly Interest Repayment \t Monthly Interest Payment \t Total Monthly Repayment \t Next Payment Due \t Amount Due \t Arrears \t Principal Repaid \t Interest Collected \t Loan Balance \t Active ");
	}
	
	 
	
	
}
