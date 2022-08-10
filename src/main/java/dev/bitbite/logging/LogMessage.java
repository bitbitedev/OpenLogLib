package dev.bitbite.logging;

/**
 * Wrapper class for single log messages. Holds informations about the given {@link LogLevel}, {@link Category}, the message and exceptions if applicable.
 */
public class LogMessage {
	public final LogLevel logLevel;
	public final Category category;
	public final String message;
	public final Exception exception;
	
	/**
	 * Creates a new LogMessage Object using the provided informations.
	 * 
	 * @param logLevel of this LogMessage Object, may be null.
	 * @param category of this LogMessage Object, may be null.
	 * @param message of this LogMessage Object, may be null.
	 * @param exception of this LogMessage Object, may be null.
	 */
	public LogMessage(LogLevel logLevel, Category category, String message, Exception exception) {
		this.logLevel = logLevel;
		this.category = category;
		this.message = message;
		this.exception = exception;
	}
}