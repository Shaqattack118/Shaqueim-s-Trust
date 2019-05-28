package org.shaqueim.trust.loan.payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.shaqueim.trust.TrustUtils;
import org.shaqueim.trust.loan.LoanAccounting;

import com.shaqueim.trust.Configurations;
import com.shaqueim.trust.SystemsController;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class Payment implements Comparable<Payment>{
    
	private int
		identifier;
    private LocalDateTime    
    	date;
    private double  
    	interestPaid,
        principalPaid,
        principalOverpayment = 0;
    
    public Payment(int loanIdentifier, double totalPaid) {
        this(loanIdentifier, LocalDateTime.now(), totalPaid);
    }

    public Payment(int loanIdentifier, LocalDateTime date, double totalPaid) {

    	identifier = loanIdentifier;
    	this.date = date;
		interestPaid = Math.min(totalPaid, getAccounting().getMonthlyInterestRepayment());
		principalPaid = totalPaid-interestPaid;
		if(totalPaid > getAccounting().getMonthlyPayment()) {
			principalOverpayment = totalPaid - interestPaid - getAccounting().getNextPrincipalRepayment();
		}
    }

    public double getInterestPaid() {
        return interestPaid;
    }
    public double getPrincipalPaid() {
        return principalPaid;
    }
    public int getLoanIdentifier() {
    	return identifier;
    }
    public double getPrincipalOverpayment() {
    	return principalOverpayment;
    }
    public LocalDateTime getDate() {
    	return date;
    }
    
    public LoanAccounting getAccounting() {
    	return SystemsController.getLoanForIdentifier(identifier).getAccounting();
    }
    
	@Override
	public int compareTo(Payment pmt) {
		return getDate().compareTo(pmt.getDate());
	}
	
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append("[Payment] Loan Identifier: "+identifier);
		data.append("; Principal Paid: "+getPrincipalPaid());
		data.append("; Interest Paid: "+getInterestPaid());
		data.append("; Principal Overpayment: "+getPrincipalOverpayment());
		data.append("; Date Paid: "+TrustUtils.formatDate(getDate()));
		
		return data.toString();
		
	}
    
}
