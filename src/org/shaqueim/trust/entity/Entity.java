package org.shaqueim.trust.entity;

import org.shaqueim.trust.loan.Loan;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public interface Entity {
    
    public String getFirstName();
    public String getLastName();
    public String getName();
    public String getPhoneNumber();
    public Loan[] getLoans();
    
}
