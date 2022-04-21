package dev.bitbite.logging;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class LogProperties {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss");
	private String logFormat = "${default_color}${delimiter_open}${datetime}${delimiter_close}${loglevel_color_code}${delimiter_open}${loglevel_name}${delimiter_close}${category_color_code}${delimiter_open}${category_name}${delimiter_close}${default_color}: ${message}${Color.RESET}";
	private boolean colored = false;
	private HashMap<String, String> templates = new HashMap<String, String>();
	
	public LogProperties() {
		this.templates = new HashMap<String, String>();
		templates.put("${delimiter_open}", "[");
		templates.put("${delimiter_close}", "]");
		templates.put("${default_color}", Color.RESET.getColorCode());
	}
	
	// -------------------- GETTER --------------------
	public SimpleDateFormat getDateFormat() {
		return this.dateFormat;
	}
	
	public String getLogFormat() {
		return this.logFormat;
	}
	
	public boolean isColored() {
		return this.colored;
	}
	
	public HashMap<String, String> getTemplates() {
		return this.templates;
	}
	
	// -------------------- SETTER --------------------
	public void setDateFormat(SimpleDateFormat sdf) {
		this.dateFormat = sdf;
	}
	
	public void setDateFormat(String format) {
		this.dateFormat = new SimpleDateFormat(format);
	}
	
	public void setLogFormat(String format) {
		this.logFormat = format;
	}
	
	public void setDelimiter(String[] delimiter) {
		this.templates.replace("${delimiter_open}", delimiter[0]);
		this.templates.replace("${delimiter_close}", delimiter[1]);
	}
	
	public void setDelimiter(String open, String close) {
		this.setDelimiter(new String[] {open, close});
	}
	
	public void setDefaultColor(String colorCode) {
		this.templates.replace("${default_color}", colorCode);
	}
	
	public void setDefaultColor(Color color) {
		this.setDefaultColor(color.getColorCode());
	}
	
	public void isColored(boolean colored) {
		this.colored = colored;
	}
}
