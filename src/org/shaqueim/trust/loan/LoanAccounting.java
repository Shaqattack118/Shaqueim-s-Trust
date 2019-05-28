package org.shaqueim.trust.loan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.shaqueim.trust.loan.payment.Payment;

public class LoanAccounting {
	
	private double  
		INTEREST_RATE,
		LOAN_AMOUNT;
    private int 	
		LOAN_PERIOD,
		PRINCIPAL_OFFSET_PERIOD;
    
	private List<Payment> paymentsList = new ArrayList<Payment>();
	
	/**
	 * Creates a new instance of the loan accounting subsystem
	 * @param double LoanAmount
	 * @param int LoanPeriod
	 * @param double Interest Rate
	 */
	public LoanAccounting(double loanam, int loanpe, double intr) {
		this(loanam, loanpe, intr, 0);
	}
	
	/**
	 * Creates a new instance of the loan accounting subsystem
	 * @param double LoanAmount
	 * @param int LoanPeriod
	 * @param double Interest Rate
	 * @param int Principal Offset Period
	 */
	public LoanAccounting(double loanam, int loanpe, double intr, int pop) {
		PRINCIPAL_OFFSET_PERIOD = pop;
		INTEREST_RATE = intr;
		LOAN_AMOUNT = loanam;
		LOAN_PERIOD = loanpe;
	}

	/**
	 * Calculates the total principal repaid based on payments made.
	 * @return
	 */
	public double getTotalPrincipalRepaid() {
		
		double totalPrincipalPaid = 0;
		
		for (Payment payment : paymentsList) {
			totalPrincipalPaid += payment.getPrincipalPaid();
		}
		
		return totalPrincipalPaid;
		
	}
	
	/**
	 * Calculates the total interest paid based on payments made.
	 * @return
	 */
	public double getTotalInterestPaid() {
		
		double totalInterestPaid = 0;
		
		for (Payment payment : paymentsList) {
			totalInterestPaid += payment.getInterestPaid();
		}
		
		return totalInterestPaid;
		
	}
	
	/**
	 * Adds a payment to the loan accounting subsystem
	 * @param Payment pmt
	 * @return boolean
	 */
	public boolean addPayment(Payment pmt) {
		return getPaymentsList().add(pmt);
	}
	
	/**
	 * Calculates the monthly interest payment while the loan is active
	 * @return
	 */
    public double getMonthlyInterestRepayment() {
        
        double initialValue = ( this.getLoanAmount() * this.getInterestRate() );
        double principalValue = this.getMonthlyPrincipalRepayment();
        double totalRepayment = (initialValue+principalValue); 
        if(totalRepayment % 500 != 0) {
            return Precision.round(totalRepayment, -3, BigDecimal.ROUND_UP)-principalValue;
        }
        return initialValue;
    }
    
    /**
     * Returns the next monthly principal repayment to prevent loan overpayment by comparing
     * the principal remaining and the monthly principal repayment.
     * @return
     */
    public double getNextPrincipalRepayment() {
    	return Math.min(getPrincipalRemaining(), getMonthlyPrincipalRepayment());
    }
    
    /**
     * Summation of interest payment and monthly principal payment without considering
     * principal balance remaining.
     * @return double Monthly repayment
     */
    public double getMonthlyPayment() {
    	return getMonthlyInterestRepayment() + getMonthlyPrincipalRepayment();
    }
    
    /**
     * Monthly repayment towards principal without considering balance
     * @return
     */
    public double getMonthlyPrincipalRepayment() {
        double initialValue = ( this.getLoanAmount() / this.getLoanPeriod() );
        if(initialValue%1000 != 0) {
            return Precision.round(initialValue, -3, BigDecimal.ROUND_UP);
        }
        return initialValue;
    }

    /**
     * Number of months only interest is paid on the loan from the start date
     * @return double principal offset period
     */
	public int getPrincipalOffsetPeriod() {
		return PRINCIPAL_OFFSET_PERIOD;
	}
	
	/* Predicates */

	/* Mutators */
	
	public void setPrincipalOffsetPeriod(int pop) {
		PRINCIPAL_OFFSET_PERIOD = pop;
	}
	
	/* Accessors */
	
	/**
	 * Gets the interest rate for the loan
	 * @return double Interest Rate
	 */
	public double getInterestRate() {
        return INTEREST_RATE;
    }

	/**
	 * Returns the initial loan amount for the loan
	 * @return double Loan Amount
	 */
    public double getLoanAmount() {
        return LOAN_AMOUNT;
    }

    /**
     * Returns the loan period for the loan in months
     * @return int Loan Period
     */
    public int getLoanPeriod() {
        return LOAN_PERIOD;
    }
    
    /**
     * Calculates the amount of principal that is outstanding by the borrower.
     * @return double Principal Remaining
     */
    public double getPrincipalRemaining() {
		return getLoanAmount() - getTotalPrincipalRepaid();
	}
	
    /**
     * returns the list of payments made
     * @return List paymentList
     */
	public List<Payment> getPaymentsList() {
		return paymentsList;
	}
	
}
