package dev.bitbite.logging.log;

import java.util.ArrayList;

import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevels;
import dev.bitbite.logging.LogMessage;

/**
 * This class is a full implementation of {@link Log} and will print log messages to the Console using System.out.println();
 */
public class ConsoleLog extends Log {
	
	/**
	 * Creates a new instance of ConsoleLog and registers itself to a given {@link ArrayList}
	 * @param logs to be registered to
	 */
	public ConsoleLog(ArrayList<Log> logs) {
		logs.add(this);
	}
	
	public ConsoleLog() {
		
	}
	
	@Override
	public String log(LogMessage logMessage) {
		String finalMessage = "";
		String logContent = "";
		if(logMessage.message != null) {
			logContent += logMessage.message;
		}
		if(logMessage != null && logMessage.exception != null) {
			logContent += " ";
		}
		if(logMessage.exception != null) {
			StackTraceElement elem = logMessage.exception.getStackTrace()[0];
			logContent += logMessage.exception.getMessage()+" in "+elem.getClassName()+":"+elem.getLineNumber();
		}
		finalMessage += this.format(logMessage.logLevel, logMessage.category, logContent);
		if(logMessage.exception != null) {
			boolean first = true;
			finalMessage += "\n";
			for(int i = 0; i < logMessage.exception.getStackTrace().length; i++) {
				if(first) {
					first = false;
					continue;
				}
				StackTraceElement elem = logMessage.exception.getStackTrace()[i];
				finalMessage += this.format(LogLevels.STACKTRACE, logMessage.category, elem.getClassName()+" in line "+elem.getLineNumber())+"\n";
			}
		}
		System.out.println(finalMessage);
		return finalMessage;
	}
}
