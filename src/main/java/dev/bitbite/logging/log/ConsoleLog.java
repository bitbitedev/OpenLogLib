package dev.bitbite.logging.log;

import java.util.ArrayList;
import java.util.Arrays;

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
	public void log(LogMessage logMessage) {
		String logContent = "";
		if(logMessage.message != null) {
			logContent += logMessage.message;
		}
		if(logMessage.message != null && logMessage.exception != null) {
			logContent += " ";
		}
		if(logMessage.exception != null) {
			logContent += logMessage.exception.getMessage()+" in "+logMessage.exception.getStackTrace()[0].getClassName()+":"+logMessage.exception.getStackTrace()[0].getLineNumber();
		}
		System.out.println(this.format(logMessage.logLevel, logMessage.category, logContent));
		if(logMessage.exception != null) Arrays.stream(logMessage.exception.getStackTrace()).skip(1).forEach(e -> { System.out.println(this.format(LogLevels.STACKTRACE, logMessage.category, e.getClassName()+" in line "+e.getLineNumber())); });
	}
}
