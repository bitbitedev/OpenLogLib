package dev.bitbite.logging;

import java.util.Date;
import java.util.HashMap;

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
	 * @param replacements HashMap with user defined templates with their replacement information.
	 * @return the formatted String
	 */
	protected String format(LogLevel logLevel, Category category, String message, HashMap<String, String> replacements) {
		String modify = this.properties.getLogTemplate();
		for(var replacement : replacements.entrySet()) {
			modify = modify.replace(replacement.getKey(), (!replacement.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? replacement.getValue() : "");
		}
		for(var template : this.properties.getTemplates().entrySet()) {
			modify = modify.replace(template.getKey(), (!template.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? template.getValue() : "");
		}
		return this.replaceDynamicElements(logLevel, category, message, modify);
	}
	
	/**
	 * Formats the template String defined in {@link LogProperties} accordingly with actual information.
	 * @param logLevel for the formatting
	 * @param message for the replacement
	 * @param replacements HashMap with user defined templates with their replacement information
	 * @return the formatted String
	 */
	protected String format(LogLevel logLevel, String message, HashMap<String, String> replacements) {
		String modify = this.properties.getLogTemplate();
		for(var replacement : replacements.entrySet()) {
			modify = modify.replace(replacement.getKey(), (!replacement.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? replacement.getValue() : "");
		}
		for(var template : this.properties.getTemplates().entrySet()) {
			modify = modify.replace(template.getKey(), (!template.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? template.getValue() : "");
		}
		return this.replaceDynamicElements(logLevel, null, message, modify);
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
	 * Formats the template String defined in {@link LogProperties} accordingly with actual information.
	 * @param logLevel for the formatting
	 * @param message for the replacement
	 * @return the formatted String
	 */
	protected String format(LogLevel logLevel, String message) {
		String modify = this.properties.getLogTemplate();
		for(var template : this.properties.getTemplates().entrySet()) {
			modify = modify.replace(template.getKey(), (!template.getValue().contains("\u001b[") || this.properties.usesAnsi()) ? template.getValue() : "");
		}
		return this.replaceDynamicElements(logLevel, null, message, modify);
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
		preFormattedString = preFormattedString.replace(TemplateElements.LogLevelFormat, (this.properties.usesAnsi()) ? logLevel.ansi.toString() : "");
		preFormattedString = (category != null) ? preFormattedString.replace(TemplateElements.CategoryFormat, (this.properties.usesAnsi()) ? category.ansi.toString() : "") : preFormattedString.replace(TemplateElements.CategoryFormat, "");
		preFormattedString = preFormattedString.replace(TemplateElements.LogLevelName, logLevel.name);
		preFormattedString = (category != null) ? preFormattedString.replace(TemplateElements.CategoryName, category.name) : preFormattedString.replace(TemplateElements.CategoryName, "");
		preFormattedString = preFormattedString.replace("[]", "");
		//preFormattedString = (category != null) ? preFormattedString.replace(TemplateElements.CategoryName, category.name) : "";
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
	public void setProperies(LogProperties properties) {
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
	 * Logs messages using an implementation class to an implemented output, using the provided {@link LogLevel} and message.
	 * @param logLevel of this message
	 * @param message to be logged
	 */
	public abstract void log(LogLevel logLevel, String message);
	
	/**
	 * Logs exceptions using an implementation class to an implemented output, using the provided {@link LogLevel}, {@link Category} and {@link Exception}.
	 * @param logLevel of the exception
	 * @param category of the exception
	 * @param exception to be logged
	 */
	public abstract void log(LogLevel logLevel, Category category, Exception exception);
	
	/**
	 * Logs exceptions using an imlementation class to an implemented output, using the provided {@link LogLevel} and {@link Exception}.
	 * @param logLevel of the exception
	 * @param exception to be logged
	 */
	public abstract void log(LogLevel logLevel, Exception exception);
}
