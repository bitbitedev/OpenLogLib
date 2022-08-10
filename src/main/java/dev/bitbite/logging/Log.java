package dev.bitbite.logging;

import java.util.Date;

/**
 * This abstraction provides functionality to format message strings by appending additional information like date and time when the message was logged,
 * or the importance of the message. This class is meant to be extended in order to determine where messages should be logged to (e.g. files or console).
 */
public abstract class Log {
	protected LogProperties properties;
	
	/**
	 * When called by a childclass, constructs a new {@link Log}-Object with default {@link LogProperties}.
	 */
	protected Log() {
		this.properties = new LogProperties();
	}
	
	/**
	 * Formats the template String defined in {@link LogProperties} accordingly with actual information.
	 * @param logLevel for the formatting
	 * @param category for the formatting
	 * @param message for the replacement
	 * @return the formatted String
	 */
	protected String format(LogLevel logLevel, Category category, String message) {
		String modify = this.properties.getLogTemplate();
		for(var template : this.properties.getTemplates().entrySet()) {
			modify = modify.replace(template.getKey(), (!template.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? template.getValue() : "");
		}
		return this.replaceDynamicElements(logLevel, category, message, modify);
	}
	
	/**
	 * Replaces dynamic values of the log template String
	 * @param logLevel of the template String
	 * @param category of the template String
	 * @param message of the template String
	 * @param preFormattedString to replace in
	 * @return formattedString
	 */
	private String replaceDynamicElements(LogLevel logLevel, Category category, String message, String preFormattedString) {
		preFormattedString = (logLevel != null) ? preFormattedString.replace(TemplateElements.LogLevelFormat, (this.properties.usesAnsi()) ? logLevel.ansi.toString() : "") : preFormattedString.replace(TemplateElements.LogLevelFormat, "");
		preFormattedString = (category != null) ? preFormattedString.replace(TemplateElements.CategoryFormat, (this.properties.usesAnsi()) ? category.ansi.toString() : "") : preFormattedString.replace(TemplateElements.CategoryFormat, "");
		preFormattedString = (logLevel != null) ? preFormattedString.replace(TemplateElements.LogLevelName, logLevel.name) : preFormattedString.replace(TemplateElements.LogLevelName, "");
		preFormattedString = (category != null) ? preFormattedString.replace(TemplateElements.CategoryName, category.name) : preFormattedString.replace(TemplateElements.CategoryName, "");
		preFormattedString = preFormattedString.replace("[]", "");
		preFormattedString = preFormattedString.replace(TemplateElements.DateTime, this.properties.getDateTimeFormat().format(new Date()));
		preFormattedString = preFormattedString.replace(TemplateElements.Date, this.properties.getDateFormat().format(new Date()));
		preFormattedString = preFormattedString.replace(TemplateElements.Time, this.properties.getTimeFormat().format(new Date()));
		return preFormattedString.replace(TemplateElements.Message, message);
	}
	
	/**
	 * Returns the current properties of the Log
	 * @return this logs {@link #properties}
	 */
	public LogProperties getProperties() {
		return this.properties;
	}
	
	/**
	 * Sets a new {@link LogProperties} object to be used for this Log.
	 * @param properties to be set
	 */
	public void setProperties(LogProperties properties) {
		this.properties = properties;
	}
	
	/**
	 * Logs a provided {@link LogMessage} using an implementation class to a given output.
	 * @param logMessage to be logged.
	 */
	public abstract void log(LogMessage logMessage);
	
	/**
	 * Logs a given message using default values and an implementation class to a given output.
	 * @param message to be logged.
	 */
	public void debug(String message) {
		this.log(new LogMessage(LogLevels.DEBUG, null, message, null));
	}
	
	/**
	 * Logs a given message using default values and an implementation class to a given output.
	 * @param message to be logged.
	 */
	public void info(String message) {
		this.log(new LogMessage(LogLevels.INFO, null, message, null));
	}
	
	/**
	 * Logs a given message using default values and an implementation class to a given output.
	 * @param message to be logged.
	 */
	public void warning(String message) {
		this.log(new LogMessage(LogLevels.WARNING, null, message, null));
	}
	
	/**
	 * Logs a given message using default values and an implementation class to a given output.
	 * @param message to be logged.
	 */
	public void error(String message) {
		this.log(new LogMessage(LogLevels.ERROR, null, message, null));
	}
	
	/**
	 * Logs a given message using default values and an implementation class to a given output.
	 * @param message to be logged.
	 */
	public void critical(String message) {
		this.log(new LogMessage(LogLevels.CRITICAL, null, message, null));
	}
	
	
}
