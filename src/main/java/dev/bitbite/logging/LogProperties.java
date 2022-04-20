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
	
	public SimpleDateFormat dateFormat() {
		return this.dateFormat;
	}
	
	public String logFormat() {
		return this.logFormat;
	}
	
	public boolean colored() {
		return this.colored;
	}
	
	public HashMap<String, String> templates() {
		return this.templates;
	}
	
	public HashMap<String, String> colors() {
		return this.colors;
	}
	
	public void dateFormat(SimpleDateFormat sdf) {
		this.dateFormat = sdf;
	}
	
	public void dateFormat(String format) {
		this.dateFormat = new SimpleDateFormat(format);
	}
	
	public void logFormat(String format) {
		this.logFormat = format;
	}
	
	public void delimiter(String[] delimiter) {
		this.delimiter = delimiter;
		this.revalidate();
	}
	
	public void delimiter(String open, String close) {
		this.delimiter(new String[] {open, close});
	}
	
	public void defaultColor(String colorCode) {
		this.defaultColor = colorCode;
		this.revalidate();
	}
	
	public void defaultColor(Color color) {
		this.defaultColor(color.getColorCode());
	}
	
	public void colored(boolean colored) {
		this.colored = colored;
	}
}
