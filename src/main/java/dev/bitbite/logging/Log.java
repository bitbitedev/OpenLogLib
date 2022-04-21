package dev.bitbite.logging;

import java.util.HashMap;

/**
 * This abstraction provides functionality to format message strings by appending additional information like date and time when the message was logged,
 * or the importance of the message. This class is meant to be extended in order to determine where messages should be logged to (e.g. files or console).
 */
public abstract class Log {
	protected LogProperties properties;
	
	
	protected Log() {
		this.properties = new LogProperties();
	}
	
	/**
	 * Formats the template String defined in {@link LogProperties} accordingly with actual information.
	 * @param replacements - A HashMap with user defined templates with their replacement information.
	 * @return String - The formatted String for output purposes
	 */
	protected String format(HashMap<String, String> replacements) {
		String modify = this.properties.logFormat();
		for(var entry : replacements.entrySet()) {
			modify = modify.replace(entry.getKey(), entry.getValue());
		}
		for(var entry : this.properties.templates().entrySet()) {
			modify = modify.replace(entry.getKey(), entry.getValue());
		}
		for(var entry : this.properties.colors().entrySet()) {
			modify = modify.replace("${"+entry.getKey()+"}", entry.getValue());
		}
		return modify;
	}
	
	/**
	 * Returns the current properties of the Log
	 * @return - The {@link LogProperties}
	 */
	public LogProperties properties() {
		return this.properties;
	}
	
	/**
	 * Sets a new {@link LogProperties} object to be used for this Log.
	 * @param properties - The LogProperties to be set
	 */
	public void properties(LogProperties properties) {
		this.properties = properties;
	}
	
	/**
	 * Logs messages using an implementation class to an implemented output, using the provided {@link LogLevel}, {@link Category} and message.
	 * @param level - The {@link LogLevel} of this log message
	 * @param category - The {@link Category} of this message
	 * @param message - The message to be logged
	 */
	public abstract void log(LogLevel level, Category category, String message);
	
	/**
	 * Logs exceptions using an implementation class to an implemented output, using the provided {@link LogLevel}, {@link Category} and {@link Exception}.
	 * @param level - The {@link LogLevel} of the exception
	 * @param category - The {@link Category} of the exception
	 * @param exception - The {@link Exception} to be logged
	 */
	public abstract void log(LogLevel level, Category category, Exception exception);
}
