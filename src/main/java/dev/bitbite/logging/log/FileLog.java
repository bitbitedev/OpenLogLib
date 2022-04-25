package dev.bitbite.logging.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import dev.bitbite.logging.Category;
import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevel;

/**
 * This class is a full implementation of {@link Log} and will output log messages to a given File;
 */
public class FileLog extends Log {
	private File logFile;
	private PrintWriter writer;
	
	/**
	 * Creates a Log object and a new output File, where the log will be written to.
	 * @param logFile - The output {@link File}.
	 * @throws FileNotFoundException - if the output file could not be created.
	 */
	public FileLog(File logFile) throws FileNotFoundException {
		this.logFile = logFile;
		if(!this.logFile.getParentFile().exists()) this.logFile.getParentFile().mkdirs();
		this.writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.logFile)));
	}
	
	/**
	 * Creates a Log object and a new output File, where the log will be written to.
	 * @param path - String representation of the path
	 * @throws FileNotFoundException - if the output file could not be created.
	 */
	public FileLog(String path) throws FileNotFoundException {
		this(new File(path));
	}

	@Override
	public void log(LogLevel logLevel, Category category, String message) {
		this.writer.println(this.format(logLevel, category, message));
		this.writer.flush();
	}

	@Override
	public void log(LogLevel logLevel, Category category, Exception exception) {
		this.writer.println(this.format(logLevel, category, exception.getMessage()));
		this.writer.flush();
	}

}
