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
		String response = "("+commandString+")"+": ";
		if(commandString.startsWith("/") && cmds[0] != "/command") {
			Command cmd = Command.getCommand(cmds[0].substring(1));
			if(cmd != null) {
				response += cmd.executeCommand(Arrays.copyOfRange(cmds, 1, cmds.length));
			} else {
				Console.log("null cmd"+cmds[0]);
			}
		}

		if(response.endsWith("): ")) {
			Console.log(response + "invalid command");
		} else {
			Console.log(response);
		}
		
		Console.refreshFrame();
		Console.clearInputArea();
	}

}
