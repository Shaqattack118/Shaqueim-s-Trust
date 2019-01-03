package org.shaqueim.trust.loan;

import org.shaqueim.trust.entity.Entity;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public interface Loan {
    
    public double getInterestRate();
    public double getLoanAmount();
    public int getLoanPeriod();
    public double getMonthlyRepayment();
    public double getMonthlyInterestRepayment();
    public double getMonthlyPrincipalRepayment();
    public double getPrincipalRepaid();
    public double getTotalInterestPaid();
    public int getPrincipalOffsetPeriod();
    public Date getStartDate();
    public Date getEndDate();
    public Entity getLoaner();
    public Entity getBorrower();
    
    public boolean isActiveLoan();
    
}
