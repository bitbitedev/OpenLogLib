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
	 * @param replacements HashMap with user defined templates with their replacement information.
	 * @return the formatted String
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
	 * @return this logs {@link #properties}
	 */
	public LogProperties properties() {
		return this.properties;
	}
	
	/**
	 * Sets a new {@link LogProperties} object to be used for this Log.
	 * @param properties to be set
	 */
	public void properties(LogProperties properties) {
		this.properties = properties;
	}
	
	/**
	 * Logs messages using an implementation class to an implemented output, using the provided {@link LogLevel}, {@link Category} and message.
	 * @param logLevel of this log message
	 * @param category of this message
	 * @param message to be logged
	 */
	public abstract void log(LogLevel logLevel, Category category, String message);
	
	/**
	 * Logs exceptions using an implementation class to an implemented output, using the provided {@link LogLevel}, {@link Category} and {@link Exception}.
	 * @param logLevel of the exception
	 * @param category of the exception
	 * @param exception to be logged
	 */
	public abstract void log(LogLevel logLevel, Category category, Exception exception);
}
