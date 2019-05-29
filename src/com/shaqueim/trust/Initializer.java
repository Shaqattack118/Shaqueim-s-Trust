package com.shaqueim.trust;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.math3.util.Precision;
import org.shaqueim.trust.TrustUtils;
import org.shaqueim.trust.console.Console;
import org.shaqueim.trust.console.commands.Commands;
import org.shaqueim.trust.entity.Entity;
import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.LoanAccounting;
import org.shaqueim.trust.loan.RegularLoan;
import org.shaqueim.trust.loan.payment.Payment;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class Initializer {
	
    public static void main(String[] args) {
    	//SystemsController.loadPayments();
        
        Console.init();
        Commands.init();
        /*
        System.out.println(x.getAccounting().getMonthlyInterestRepayment() + " and " +x.getAccounting().getMonthlyPrincipalRepayment() + " = " + x.getNextMonthlyRepayment());
        
        Payment g = new Payment(x.getAccounting(), 50000);
        System.out.println(g.getPrincipalPaid());
        System.out.println(g.getInterestPaid());
        

        
        Configurations.properties.put("database-host", "localhost");
        Configurations.properties.put("database-name", "trust-database");
        Configurations.properties.put("database-username", "root");
        Configurations.properties.put("database-password", "");
        Configurations.properties.put("database-port", "3306");
        
        Configurations.saveProperties();*/
        
    }
    
}
