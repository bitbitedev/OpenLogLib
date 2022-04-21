package dev.bitbite.logging.log;

import java.util.Date;
import java.util.HashMap;

import dev.bitbite.logging.Category;
import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevel;

public class ConsoleLog extends Log {

	@Override
	public void log(LogLevel level, Category category, String message) {
		Date now = new Date();
		HashMap<String, String> replaces = new HashMap<String, String>();
		replaces.put("${datetime}", this.properties.getDateFormat().format(now));
		replaces.put("${loglevel_name}", level.name);
		replaces.put("${category_name}", category.name);
		replaces.put("${loglevel_color_code}", (this.properties.isColored()) ? level.color.getColorCode() : "");
		replaces.put("${category_color_code}", (this.properties.isColored()) ? category.color.getColorCode() : "");
		replaces.put("${message}", message);
		System.out.println(this.format(replaces));
	}

	@Override
	public void log(LogLevel level, Category category, Exception e) {
		Date now = new Date();
		HashMap<String, String> replaces = new HashMap<String, String>();
		replaces.put("${datetime}", this.properties.getDateFormat().format(now));
		replaces.put("${loglevel_name}", level.name);
		replaces.put("${category_name}", category.name);
		replaces.put("${loglevel_color_code}", (this.properties.isColored()) ? level.color.getColorCode() : "");
		replaces.put("${category_color_code}", (this.properties.isColored()) ? category.color.getColorCode() : "");
		replaces.put("${message}", e.getMessage());
		System.out.println(this.format(replaces));
	}
	
}
