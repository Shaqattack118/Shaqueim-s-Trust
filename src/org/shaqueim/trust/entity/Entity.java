package org.shaqueim.trust.entity;

import java.util.ArrayList;
import org.shaqueim.trust.loan.Loan;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class Entity {
	
	private String FIRST_NAME, LAST_NAME, PHONE_NUMBER;
	
	public Entity(String fname, String lname, String phone) {
		FIRST_NAME = fname;
		LAST_NAME = lname;
		PHONE_NUMBER = phone;
	}
	
	public Entity(String fname, String lname) {
		this(fname, lname, null);
	}
	
    public String getFirstName() {
        return this.FIRST_NAME;
    }

    public String getLastName() {
        return this.LAST_NAME;
    }

    public String getName() {
        return this.FIRST_NAME + " " + this.LAST_NAME;
    }
    
    public String getPhoneNumber() {
        return this.PHONE_NUMBER;
    }
    
}
