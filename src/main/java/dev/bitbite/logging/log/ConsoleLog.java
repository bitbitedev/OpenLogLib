package dev.bitbite.logging.log;

import java.util.ArrayList;

import dev.bitbite.logging.Category;
import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevel;

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
	public void log(LogLevel logLevel, Category category, String message) {
		System.out.println(this.format(logLevel, category, message));
	}
	
	@Override
	public void log(LogLevel logLevel, String message) {
		System.out.println(this.format(logLevel, message));
	}

	@Override
	public void log(LogLevel logLevel, Category category, Exception exception) {
		System.out.println(this.format(logLevel, category, exception.getMessage()));
	}
	
	@Override
	public void log(LogLevel logLevel, Exception exception) {
		System.out.println(this.format(logLevel, exception.getMessage()));
	}
}
