package dev.bitbite.logging;

import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Holds all the property information for the {@link Log}.
 *
 */
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
	/**
	 * Returns the current Date and Time formatting
	 * @return the date and time format as {@link SimpleDateFormat}
	 */
	public SimpleDateFormat getDateFormat() {
		return this.dateFormat;
	}
	
	/**
	 * Returns the current logformatting String representation.
	 * @return current logformatting string
	 */
	public String getLogFormat() {
		return this.logFormat;
	}
	
	/**
	 * Returns whether the log messages will be colorized using ANSI Escape Sequences or not.
	 * @return boolean
	 */
	public boolean isColored() {
		return this.colored;
	}
	
	public HashMap<String, String> getTemplates() {
		return this.templates;
	}
	
	// -------------------- SETTER --------------------
	/**
	 * Sets a new Date and Time formatting.
	 * @param simpleDateFormat to be used.
	 */
	public void setDateFormat(SimpleDateFormat simpleDateFormat) {
		this.dateFormat = simpleDateFormat;
	}
	
	/**
	 * Sets a new Date and Time formatting.
	 * @param format String to be used for {@link SimpleDateFormat}.
	 */
	public void setDateFormat(String format) {
		this.setDateFormat(new SimpleDateFormat(format));
	}
	
  /**
	 * Sets a new Log formatting template. 
	 * @param format to be set
	 */
	public void setLogFormat(String format) {
		this.logFormat = format;
	}
	
  /**
	 * Sets the opening and closing delimiters.
	 * @param delimiter Array representation of the opening and closing delimiters. Index 0 will be open, 1 the closing delimiter.
	 */
	public void setDelimiter(String[] delimiter) {
		this.templates.replace("${delimiter_open}", delimiter[0]);
		this.templates.replace("${delimiter_close}", delimiter[1]);
	}
	
  /**
	 * Sets the opening and closing delimiters.
	 * @param open The opening delimiter
	 * @param close The closing delimiter.
	 */
	public void setDelimiter(String open, String close) {
		this.setDelimiter(new String[] {open, close});
	}
	
  /**
	 * Sets the default Color to be used as a fallback.
	 * @param colorCode of a {@link Color} as string.
	 */
	public void setDefaultColor(String colorCode) {
		this.templates.replace("${default_color}", colorCode);
	}
	
  /**
	 * Sets the default {@link Color} to be used as a fallback.
	 * @param color for usage as fallback
	 */
	public void setDefaultColor(Color color) {
		this.setDefaultColor(color.getColorCode());
	}
  
  /**
	 * Sets the option to use ANSI Escape Sequences for {@link Color}s to your preferences.
	 * @param colored True to enable ANSI Escape Sequences, false to disable them
	 */
	public void isColored(boolean colored) {
		this.colored = colored;
	}
}
