package dev.bitbite.logging;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import dev.thatsnasu.ansi.Color;
import dev.thatsnasu.ansi.Color3b;
import dev.thatsnasu.ansi.Color4b;
import dev.thatsnasu.ansi.Color8b;

/**
 * Holds all the property information for the {@link Log}.
 *
 */
public class LogProperties {
	private SimpleDateFormat dateTimeFormat;
	private SimpleDateFormat dateFormat;
	private SimpleDateFormat timeFormat;
	private HashMap<String, String> templates;
	private boolean usesAnsi;
	private String logTemplate;
	
	
	/**
	 * Creates a new LogProperties Object and initializes it with default values.
	 */
	public LogProperties() {
		this.dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss");
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.templates = new HashMap<String, String>();
		this.templates.put(TemplateElements.DelimiterOpen, "[");
		this.templates.put(TemplateElements.DelimiterClose, "]");
		this.templates.put(TemplateElements.DefaultColor, Color3b.RESET.toString());
		this.templates.put(TemplateElements.MetaDataSeparator, ": ");
		this.templates.put(TemplateElements.ResetFormat, Color3b.RESET.toString());
		this.logTemplate = TemplateElements.DefaultColor+
				TemplateElements.DelimiterOpen+
				TemplateElements.DateTime+
				TemplateElements.DelimiterClose+
				TemplateElements.LogLevelFormat+
				TemplateElements.DelimiterOpen+
				TemplateElements.LogLevelName+
				TemplateElements.DelimiterClose+
				TemplateElements.CategoryFormat+
				TemplateElements.DelimiterOpen+
				TemplateElements.CategoryName+
				TemplateElements.DelimiterClose+
				TemplateElements.DefaultColor+
				TemplateElements.MetaDataSeparator+
				TemplateElements.Message+
				TemplateElements.ResetFormat;
	}
  
	// -------------------- GETTER --------------------
	/**
	 * Returns the current datetimeformat as {@link SimpleDateFormat}.
	 * @return datetimeFormat used.
	 */
	public SimpleDateFormat getDateTimeFormat() {
		return this.dateTimeFormat;
	}
	
	/**
	 * Returns the current dateformat as {@link SimpleDateFormat}.
	 * @return datetimeFormat used.
	 */
	public SimpleDateFormat getDateFormat() {
		return this.dateFormat;
	}
	
	/**
	 * Returns the current timeformat as {@link SimpleDateFormat}.
	 * @return datetimeFormat used.
	 */
	public SimpleDateFormat getTimeFormat() {
		return this.timeFormat;
	}
	
	/**
	 * Returns the current log template String representation.
	 * @return current log template String
	 */
	public String getLogTemplate() {
		return this.logTemplate;
	}
	
	/**
	 * Returns the current template to value mappings as {@link HashMap}.
	 * @return templates that are mapped
	 */
	public HashMap<String, String> getTemplates() {
		return this.templates;
	}
	
	/**
	 * Returns if the Log object will use Ansi Escape Sequences for formatting.
	 * @return usesAnsi of the Log Object.
	 */
	public boolean usesAnsi() {
		return this.usesAnsi;
	}
	
	// -------------------- SETTER --------------------
	/**
	 * Sets a new {@link SimpleDateFormat}.
	 * @param dateTimeFormat to be set
	 */
	public void setDateTimeFormat(SimpleDateFormat dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}
	
	/**
	 * Sets a new Log formatting template. 
	 * @param template to be set
	 */
	public void setLogTemplate(String template) {
		this.logTemplate = template;
	}
	
	/**
	 * Sets whether or not the Log Object uses Ansi.
	 * @param usesAnsi to be set
	 */
	public void usesAnsi(boolean usesAnsi) {
		this.usesAnsi = usesAnsi;
	}
	
	/**
	 * Sets a new value for a given template String.
	 * @param templateKey of the template element
	 * @param templateValue of the templateKey
	 */
	public void setTemplateElement(String templateKey, String templateValue) {
		if(this.templates.containsKey(templateKey)) {
			this.templates.replace(templateKey, templateValue);
		} else {
			this.templates.put(templateKey, templateValue);
		}
	}
	
	/**
	 * Sets new delimiters.
	 * @param delimiter to be set
	 */
	public void setDelimiter(String[] delimiter) {
		this.templates.replace(TemplateElements.DelimiterOpen, delimiter[0]);
		this.templates.replace(TemplateElements.DelimiterClose, delimiter[1]);
	}
	
	/**
	 * Sets new delimiters.
	 * @param openDelimiter to be set
	 * @param closeDelimiter to be set
	 */
	public void setDelimiters(String openDelimiter, String closeDelimiter) {
		this.setDelimiter(new String[] {openDelimiter, closeDelimiter});
	}
	
	/**
	 * Sets a new default {@link Color3b}.
	 * @param color3b to be set
	 */
	public void setDefaultColor(Color3b color3b) {
		this.setDefaultColor(new Color(color3b.getHexCode()));
	}
	
	/**
	 * Sets a new default {@link Color4b}.
	 * @param color4b to be set
	 */
	public void setDefaultColor(Color4b color4b) {
		this.setDefaultColor(new Color(color4b.getHexCode()));
	}
	
	/**
	 * Sets a new default {@link Color8b}.
	 * @param color8b to be set
	 */
	public void setDefaultColor(Color8b color8b) {
		this.setDefaultColor(new Color(color8b.getHexCode()));
	}
	
	/**
	 * Sets a new default {@link Color}.
	 * @param color to be set
	 */
	public void setDefaultColor(Color color) {
		this.templates.replace(TemplateElements.DefaultColor, color.toString());
	}
}
