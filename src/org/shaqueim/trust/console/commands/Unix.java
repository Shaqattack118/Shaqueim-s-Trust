package org.shaqueim.trust.console.commands;

import java.time.LocalDateTime;

import org.shaqueim.trust.TrustUtils;
import org.shaqueim.trust.console.Command;

public class Unix extends Command {

	@Override
	public String executeCommand(String[] cmds) {
		if(cmds.length != 1) {
			return this.getUsageString();
		}
		String param = cmds[0];
		
		String[] parts = param.split("/");
		if(parts.length != 3) {
			return getUsageString();
		}
		
		try {
			int dd = Integer.parseInt(parts[0]);
			int mm = Integer.parseInt(parts[1]);
			int yy = Integer.parseInt(parts[2]);
			
			if(yy < 32) {
				yy += 2000;
			}
			
			return "UNIX: ["+TrustUtils.toUnixTimeStamp(LocalDateTime.of(yy, mm, dd, 12, 0))+"]";
		} catch(NumberFormatException e) {
			return getUsageString();
		}
	}

	@Override
	public String getUsageString() {
		return System.lineSeparator()+"Usage: /unix dd/mm/yy";
	}

}
