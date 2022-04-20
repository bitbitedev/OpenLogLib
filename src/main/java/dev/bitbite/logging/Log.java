package dev.bitbite.logging;

import java.util.HashMap;

public abstract class Log {
	protected LogProperties properties;
	
	
	protected Log() {
		this.properties = new LogProperties();
	}
	
	protected String format(HashMap<String, String> replaces) {
		String modify = this.properties.logFormat();
		for(var entry : replaces.entrySet()) {
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
	
	public LogProperties properties() {
		return this.properties;
	}
	
	public void properties(LogProperties properties) {
		this.properties = properties;
	}
	
	public abstract void log(LogLevel level, Category category, String message);
	public abstract void log(LogLevel level, Category category, Exception e);
}
