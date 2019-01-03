package org.shaqueim.trust.loan;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class RegularLoan implements Loan {

    double  INTEREST_RATE = 0.1,
            LOAN_AMOUNT = -1,
            PRINCIPAL_REPAID = 0,
            INTEREST_PAID = 0
            ;
    int     LOAN_PERIOD = -1;
    
    public RegularLoan(double intr, double loanam, int loanpe) {
        INTEREST_RATE = intr; //Need to round to 2dp
        LOAN_AMOUNT = loanam;
        LOAN_PERIOD = loanpe; // round to nearest integer
    }
    
    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }

    @Override
    public double getLoanAmount() {
        return LOAN_AMOUNT;
    }

    @Override
    public int getLoanPeriod() {
        return LOAN_PERIOD;
    }

    @Override
    public double getMonthlyRepayment() {
        return this.getMonthlyInterestRepayment() + this.getMonthlyPrincipalRepayment();
    }

    @Override
    public double getMonthlyInterestRepayment() {
        return ( this.getLoanAmount() * this.getInterestRate() );
    }

    @Override
    public double getMonthlyPrincipalRepayment() {
        return ( this.getLoanAmount() / this.getLoanPeriod() );
    }

    @Override
    public double getPrincipalRepaid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalInterestPaid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPrincipalOffsetPeriod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getStartDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getEndDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity getLoaner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity getBorrower() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActiveLoan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
