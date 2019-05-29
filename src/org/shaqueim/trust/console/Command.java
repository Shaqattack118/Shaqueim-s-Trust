package org.shaqueim.trust.console;

import java.util.HashMap;
import java.util.Map;

import org.shaqueim.trust.console.commands.Add;
import org.shaqueim.trust.console.commands.Commands;
import org.shaqueim.trust.console.commands.View;

public abstract class Command {

	public abstract String executeCommand(String[] cmds);
	public abstract String getUsageString();

	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	public static void init() {
		commands.put("commands", new Commands());
		commands.put("viewloans", new View());
		commands.put("add", new Add());
	}
	
	
	public static Command getCommand(String commandName) {
		return commands.get(commandName);
	}


	private static boolean commandExists(String commandName) {
		return commands.containsKey(commandName);
	}
}
