package org.shaqueim.trust.loan;

import java.util.Date;

import org.shaqueim.trust.entity.Entity;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class RegularLoan implements Loan {

	
    private Date 
    	START, END;
    private LoanAccounting
    	ACCOUNTING;
    private Entity 
    	BORROWER;
    private Entity 
    	LENDER;
    
    /**
     * Initialize a loan
     * @param intr Interest Rate
     * @param loanam Loan Amount
     * @param loanpe  Loan Type
     */
    public RegularLoan(Entity b, Entity l, double loanam, int loanpe, double intr) {
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
    
    public Entity getLender() {
        return LENDER;
    }

    public Entity getBorrower() {
        return BORROWER;
    }

    public boolean isActiveLoan() {
        return getAccounting().getPrincipalRemaining() == 0;
    }

	public LoanAccounting getAccounting() {
		return ACCOUNTING;
	}
	
	public void setBorrower(Entity b) {
		BORROWER = b;
	}

	public void setLender(Entity l) {
		LENDER = l;
	}

	private void setLoanAccounting(LoanAccounting accounting) {
		ACCOUNTING = accounting;
	}


    
}
