package org.shaqueim.trust.console.commands;

import java.util.Arrays;

import org.shaqueim.trust.console.Command;
import org.shaqueim.trust.entity.Entity;
import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.RegularLoan;

import com.shaqueim.trust.SystemsController;

public class View extends Command {

	@Override
	public String executeCommand(String[] cmds) {
		if(cmds.length != 1) {
			return this.getUsageString();
		}
		String param = cmds[0];
		switch(param) {
		case "entity": case "Entity":

		case "entities": case"Entities":
			
			return SystemsController.getEntities();
			
		case "loan": case "Loan":
			
		default:
			return this.getUsageString();
		}
	}

	@Override
	public String getUsageString() {
		return System.lineSeparator()+"Usage: /view\t[loan,loans,l|entities,entity,e|payment,payments,pmts,p]";
	}

}
