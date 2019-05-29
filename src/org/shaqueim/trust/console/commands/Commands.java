package org.shaqueim.trust.console.commands;

import org.shaqueim.trust.console.Command;

public class Commands extends Command {

	public String executeCommand(String[] cmds) {
		return "\n/add"
				+ "\n/save\n"
				+ "/commands\n"
				+ "/view\n";
		
	}

	@Override
	public String getUsageString() {
		return "Usage: \\commands";
	}

}
