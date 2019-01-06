package org.shaqueim.trust.loan.payment;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.math3.util.Precision;
import org.shaqueim.trust.entity.Borrower;
import org.shaqueim.trust.entity.Entity;
import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.LoanAccounting;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class Payment implements Comparable<Payment>{
    
    private Date    date;
    private LoanAccounting 	loan;
    private double  interestPaid,
                    principalPaid;
    
    public Payment(LoanAccounting loan, Date date, double principalPaid, double interestPaid) {
        this.date = date;
        this.loan = loan;
        this.principalPaid = principalPaid;
        this.interestPaid = interestPaid;
    }
    public Payment(LoanAccounting ln, double totalPaid) {
        this(new Date(), totalPaid, ln);
    }

    public Payment(Date date, double totalPaid, LoanAccounting ln) {
        this(ln, date, Math.max(0, totalPaid-ln.getMonthlyInterestRepayment()), totalPaid-Math.max(0, totalPaid-ln.getMonthlyInterestRepayment()));
    }

    public double getInterestPaid() {
        return interestPaid;
    }
    public double getPrincipalPaid() {
        return principalPaid;
    }
    public Date getDate() {
    	return date;
    }
    
	@Override
	public int compareTo(Payment pmt) {
		return getDate().compareTo(pmt.getDate());
	}
	
    
}
