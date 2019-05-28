package org.shaqueim.trust.console.commands;

import java.util.Arrays;

import org.shaqueim.trust.console.Command;
import org.shaqueim.trust.entity.Entity;
import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.RegularLoan;

import com.shaqueim.trust.SystemsController;

public class Add extends Command {

	@Override
	public String executeCommand(String[] cmds) {
		if(cmds.length < 2) {
			return this.getUsageString();
		}
		String param = cmds[0];
		String[] params = Arrays.copyOfRange(cmds, 1, cmds.length);
		switch(param) {
		case "entity": case "Entity":
			if(params.length > 3 || params.length < 2) {
				return this.getUsageString();
			}
			
			String fname = params[0].replaceAll("_", " ");
			String lname = params[1].replaceAll("_", " ");
			String phoneNumber = null;
			if(params.length == 3) {
				phoneNumber = params[2];
			}
			
			Entity e = new Entity(fname, lname, phoneNumber);
			if(SystemsController.entityExists(e)) {
				return "The exact entity exists.";
			}
			
			int entityId = SystemsController.addEntity(e);
			
			return "Success. EntityId: "+entityId;
			
		case "loan": case "Loan":
			if(params.length > 5 || cmds.length < 4) {
				return this.getUsageString();
			}
			int borrowerId = Integer.parseInt(params[0]);
			int	loanerId = Integer.parseInt(params[1]);
			int loanam = Integer.parseInt(params[2]);
			int loanpe = Integer.parseInt(params[3]);
			double loanintr = 0.1;
			if(params.length == 5) {
				loanintr = Double.parseDouble(params[4]);
			}
			int firstEntityToNotExist = SystemsController.entitiesExist(borrowerId, loanerId);
			if(firstEntityToNotExist > 0) {
				return firstEntityToNotExist + " does not exist";
			}
			Entity borrower = SystemsController.getEntity(borrowerId);
			Entity lender = SystemsController.getEntity(loanerId);
			
			Loan newLoan = new RegularLoan(borrower, lender, loanam, loanpe, loanintr);
			int loanId = SystemsController.addLoan(newLoan);
			
			return "Success. LoanId: "+loanId;
			
		default:
			return this.getUsageString();
		}
	}

	@Override
	public String getUsageString() {
		return "\nUsage: /add\t[Loan|Payment|Entity]\n"+System.lineSeparator()
		+ "\tentity [First_name] [Last_name] [PhoneNumber:null]"+System.lineSeparator()
		+ "\tloan [BorrowerId] [LoanerId] [Loan_Amount] [LoanPeriod] [Intr:10% (INT)]"+System.lineSeparator()
		+ "\tpayment [loanId] [payment] [unix]";
	}
	

}
