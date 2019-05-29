package org.shaqueim.trust.frame.listeners;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;

import org.shaqueim.trust.console.Command;
import org.shaqueim.trust.console.Console;

public class CommandListener extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		String commandString = e.getActionCommand();
		
		if(commandString == "") {
			return;
		}
		
		String[] cmds = commandString.split(" ");
		String response = "("+cmds[0]+")"+": ";
		if(cmds[0] != "command") {
			Command cmd = Command.getCommand(cmds[0]);
			if(cmd != null) {
				response += cmd.executeCommand(Arrays.copyOfRange(cmds, 1, cmds.length));
			}
		}

		if(response.endsWith("): ")) {
			Console.log(response + " undefined command");
		} else {
			Console.log(response);
		}
		
		Console.refreshFrame();
		Console.clearInputArea();
	}

}
