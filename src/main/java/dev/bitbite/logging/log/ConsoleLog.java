package dev.bitbite.logging.log;

import dev.bitbite.logging.Category;
import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevel;

/**
 * This class is a full implementation of {@link Log} and will print log messages to the Console using System.out.println();
 */
public class ConsoleLog extends Log {

	@Override
	public void log(LogLevel logLevel, Category category, String message) {
		System.out.println(this.format(logLevel, category, message));
	}

	@Override
	public void log(LogLevel logLevel, Category category, Exception exception) {
		System.out.println(this.format(logLevel, category, exception.getMessage()));
	}
}
