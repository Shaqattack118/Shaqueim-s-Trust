package org.shaqueim.trust.loan;

import java.util.Date;

import org.shaqueim.trust.entity.Borrower;
import org.shaqueim.trust.entity.Lender;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class RegularLoan implements Loan {

	
    private Date 
    	START, END;
    private LoanAccounting
    	ACCOUNTING;
    private Borrower 
    	BORROWER;
    private Lender 
    	LENDER;
    
    /**
     * Initialize a loan
     * @param intr Interest Rate
     * @param loanam Loan Amount
     * @param loanpe  Loan Type
     */
    public RegularLoan(Borrower b, Lender l, double loanam, int loanpe, double intr) {
    	setLoanAccounting(new LoanAccounting(loanam, loanpe, intr));
    	setBorrower(b);
    	setLender(l);
    }

    /**
     * Gets the next monthly repayment
     * @return double Next Monthly Repayment
     */
    public double getNextMonthlyRepayment() {
        return getAccounting().getMonthlyInterestRepayment() + getAccounting().getNextPrincipalRepayment();
    }

    @Override
    public Date getStartDate() {
        return START;
    }

    @Override
    public Date getEndDate() {
        return END;
    }
    
    public Lender getLender() {
        return LENDER;
    }

    public Borrower getBorrower() {
        return BORROWER;
    }

    public boolean isActiveLoan() {
        return getAccounting().getPrincipalRemaining() == 0;
    }

	public LoanAccounting getAccounting() {
		return ACCOUNTING;
	}
	
	public void setBorrower(Borrower b) {
		BORROWER = b;
	}

	public void setLender(Lender l) {
		LENDER = l;
	}

	private void setLoanAccounting(LoanAccounting accounting) {
		ACCOUNTING = accounting;
	}


    
}
