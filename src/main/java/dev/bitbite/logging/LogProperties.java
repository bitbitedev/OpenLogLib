package dev.bitbite.logging;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class LogProperties {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss");
	private String logFormat = "${default_color}${delimiter_open}${datetime}${delimiter_close}${loglevel_color_code}${delimiter_open}${loglevel_name}${delimiter_close}${category_color_code}${delimiter_open}${category_name}${delimiter_close}${default_color}: ${message}${Color.RESET}";
	private String[] delimiter = new String[] {"[", "]"};
	private String defaultColor = Color.RESET.getColorCode();
	private boolean colored = false;
	private HashMap<String, String> colors = new HashMap<String, String>();
	private HashMap<String, String> templates = new HashMap<String, String>();
	
	public LogProperties() {
		for(Color color : Color.values()) {
			this.colors.put("Color."+color.toString(), color.getColorCode());
		}
		this.revalidate();
	}
	
	public void revalidate() {
		HashMap<String, String> templates = new HashMap<String, String>();
		templates.put("${delimiter_open}", this.delimiter[0]);
		templates.put("${delimiter_close}", this.delimiter[1]);
		templates.put("${default_color}", (this.colored) ? this.defaultColor : "");
		this.templates = templates;
	}
	
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
	
	public HashMap<String, String> getColors() {
		return this.colors;
	}
	
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
		this.delimiter = delimiter;
		this.revalidate();
	}
	
	public void setDelimiter(String open, String close) {
		this.setDelimiter(new String[] {open, close});
	}
	
	public void setDefaultColor(String colorCode) {
		this.defaultColor = colorCode;
		this.revalidate();
	}
	
	public void setDefaultColor(Color color) {
		this.setDefaultColor(color.getColorCode());
	}
	
	public void isColored(boolean colored) {
		this.colored = colored;
	}
}
