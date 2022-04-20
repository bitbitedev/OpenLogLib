package dev.bitbite.logging.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import dev.bitbite.logging.Category;
import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevel;

public class FileLog extends Log {
	private File logFile;
	private PrintWriter writer;
	
	
	public FileLog(File logFile) throws FileNotFoundException {
		this.logFile = logFile;
		if(!this.logFile.getParentFile().exists()) this.logFile.getParentFile().mkdirs();
		this.writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.logFile)));
	}
	
	public FileLog(String path) throws FileNotFoundException {
		this(new File(path));
	}

	@Override
	public void log(LogLevel level, Category category, String message) {
		Date now = new Date();
		HashMap<String, String> replaces = new HashMap<String, String>();
		replaces.put("${datetime}", this.properties().dateFormat().format(now));
		replaces.put("${loglevel_name}", level.name);
		replaces.put("${category_name}", category.name);
		replaces.put("${loglevel_color_code}", (this.properties().colored()) ? level.color.getColorCode() : "");
		replaces.put("${category_color_code}", (this.properties().colored()) ? category.color.getColorCode() : "");
		replaces.put("${message}", message);
		replaces.put("${Color.RESET}", "");
		this.writer.println(this.format(replaces));
		this.writer.flush();
	}

	@Override
	public void log(LogLevel level, Category category, Exception e) {
		Date now = new Date();
		HashMap<String, String> replaces = new HashMap<String, String>();
		replaces.put("${datetime}", this.properties().dateFormat().format(now));
		replaces.put("${loglevel_name}", level.name);
		replaces.put("${category_name}", category.name);
		replaces.put("${loglevel_color_code}", (this.properties().colored()) ? level.color.getColorCode() : "");
		replaces.put("${category_color_code}", (this.properties().colored()) ? category.color.getColorCode() : "");
		replaces.put("${message}", e.getMessage());
		replaces.put("${Color.RESET}", "");
		this.writer.println(this.format(replaces));
		this.writer.flush();
	}

}
