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
	
	private void revalidate() {
		HashMap<String, String> templates = new HashMap<String, String>();
		templates.put("${delimiter_open}", this.delimiter[0]);
		templates.put("${delimiter_close}", this.delimiter[1]);
		templates.put("${default_color}", (this.colored) ? this.defaultColor : "");
		this.templates = templates;
	}
	
	/**
	 * Returns the current Date and Time formatting
	 * @return the date and time format as {@link SimpleDateFormat}
	 */
	public SimpleDateFormat dateFormat() {
		return this.dateFormat;
	}
	
	/**
	 * Returns the current logformatting String representation.
	 * @return current logformatting string
	 */
	public String logFormat() {
		return this.logFormat;
	}
	
	/**
	 * Returns whether the log messages will be colorized using ANSI Escape Sequences or not.
	 * @return boolean
	 */
	public boolean colored() {
		return this.colored;
	}
	
	public HashMap<String, String> templates() {
		return this.templates;
	}
	
	@Deprecated
	public HashMap<String, String> colors() {
		return this.colors;
	}
	
	/**
	 * Sets a new Date and Time formatting.
	 * @param simpleDateFormat to be used.
	 */
	public void dateFormat(SimpleDateFormat simpleDateFormat) {
		this.dateFormat = simpleDateFormat;
	}
	
	/**
	 * Sets a new Date and Time formatting.
	 * @param format String to be used for {@link SimpleDateFormat}.
	 */
	public void dateFormat(String format) {
		this.dateFormat(new SimpleDateFormat(format));
	}
	
	/**
	 * Sets a new Log formatting template. 
	 * @param format to be set
	 */
	public void logFormat(String format) {
		this.logFormat = format;
	}
	
	/**
	 * Sets the opening and closing delimiters.
	 * @param delimiter - Array representation of the opening and closing delimiters. Index 0 will be open, 1 the closing delimiter.
	 */
	public void delimiter(String[] delimiter) {
		this.delimiter = delimiter;
		this.revalidate();
	}
	
	/**
	 * Sets the opening and closing delimiters.
	 * @param open - The opening delimiter
	 * @param close - The closing delimiter.
	 */
	public void delimiter(String open, String close) {
		this.delimiter(new String[] {open, close});
	}
	
	/**
	 * Sets the default Color to be used as a fallback.
	 * @param colorCode of a {@link Color} as string.
	 */
	public void defaultColor(String colorCode) {
		this.defaultColor = colorCode;
		this.revalidate();
	}
	
	/**
	 * Sets the default {@link Color} to be used as a fallback.
	 * @param color for usage as fallback
	 */
	public void defaultColor(Color color) {
		this.defaultColor(color.getColorCode());
	}
	
	/**
	 * Sets the option to use ANSI Escape Sequences for {@link Color}s to your preferences.
	 * @param colored True to enable ANSI Escape Sequences, false to disable them
	 */
	public void colored(boolean colored) {
		this.colored = colored;
	}
}
