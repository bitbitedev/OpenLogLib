package dev.bitbite.logging;

import java.util.HashMap;

public abstract class Log {
	protected LogProperties properties;
	
	
	protected Log() {
		this.properties = new LogProperties();
	}
	
	protected String format(HashMap<String, String> replaces) {
		String modify = this.properties.getLogFormat();
		for(var entry : replaces.entrySet()) {
			modify = modify.replace(entry.getKey(), entry.getValue());
		}
		for(var entry : this.properties.getTemplates().entrySet()) {
			modify = modify.replace(entry.getKey(), entry.getValue());
		}
		for(var entry : this.properties.getColors().entrySet()) {
			modify = modify.replace("${"+entry.getKey()+"}", entry.getValue());
		}
		return modify;
	}
	
	public LogProperties getProperties() {
		return this.properties;
	}
	
	public void setProperies(LogProperties properties) {
		this.properties = properties;
	}
	
	public abstract void log(LogLevel level, Category category, String message);
	public abstract void log(LogLevel level, Category category, Exception e);
}
