package org.shaqueim.trust.entity;

import java.util.ArrayList;
import java.util.List;

import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.RegularLoan;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class Borrower extends Entity {

	private ArrayList<Loan> LOANS;
	
    public ArrayList<Loan> getLoans() {
    	return LOANS;
    }
    
    public void addLoan(Loan ln) {
    	this.LOANS.add(ln);
    }
    
    public Loan getLoan(int id) {
    	return this.LOANS.get(id);
    }
    
}
