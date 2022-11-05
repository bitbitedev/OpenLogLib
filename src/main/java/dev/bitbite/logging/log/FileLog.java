package dev.bitbite.logging.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import dev.bitbite.logging.Log;
import dev.bitbite.logging.LogLevels;
import dev.bitbite.logging.LogMessage;

/**
 * This class is a full implementation of {@link Log} and will output log messages to a given File;
 */
public class FileLog extends Log {
	private File logFile;
	private PrintWriter writer;
	
	/**
	 * Creates a Log object and a new output File, where the log will be written to.
	 * @param logFile to write to
	 * @param append true if the log should append to existing files, false to overwrite them
	 * @throws FileNotFoundException if the output {@link File} could not be created.
	 */
	public FileLog(File logFile, boolean append) throws FileNotFoundException {
		this.logFile = logFile;
		if(!Files.exists(this.logFile.toPath().toAbsolutePath().getParent())) this.logFile.toPath().toAbsolutePath().getParent().toFile().mkdirs();
		this.writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.logFile)));
	}
	
	/**
	 * Creates a new Log Object and a new output File, where the log will be written to. Afterwards registers itself to a given {@link ArrayList}.
	 * @param logFile to write to
	 * @param append true if the log should append to existing files, false to overwrite them
	 * @param logs to be registered to
	 * @throws FileNotFoundException if the output {@link File} could not be created
	 */
	public FileLog(File logFile, boolean append, ArrayList<Log> logs) throws FileNotFoundException {
		this(logFile, append);
		logs.add(this);
	}
	
	/**
	 * Creates a Log object and a new output File, where the log will be written to.
	 * @param path - String representation of the path
	 * @param append true if the log should append to existing files, false to overwrite them
	 * @throws FileNotFoundException - if the output file could not be created.
	 */
	public FileLog(String path, boolean append) throws FileNotFoundException {
		this(new File(path), append);
	}

	@Override
	public String log(LogMessage logMessage) {
		String finalMessage = "";
		String logContent = "";
		if(logMessage.message != null) {
			logContent += logMessage.message;
		}
		if(logMessage != null && logMessage.exception != null) {
			logContent += " ";
		}
		if(logMessage.exception != null) {
			StackTraceElement elem = logMessage.exception.getStackTrace()[0];
			logContent += logMessage.exception.getMessage()+" in "+elem.getClassName()+":"+elem.getLineNumber();
		}
		finalMessage += this.format(logMessage.logLevel, logMessage.category, logContent);
		if(logMessage.exception != null) {
			boolean first = true;
			finalMessage += "\n";
			for(int i = 0; i < logMessage.exception.getStackTrace().length; i++) {
				if(first) {
					first = false;
					continue;
				}
				StackTraceElement elem = logMessage.exception.getStackTrace()[i];
				finalMessage += this.format(LogLevels.STACKTRACE, logMessage.category, elem.getClassName()+" in line "+elem.getLineNumber())+"\n";
			}
		}
		this.writer.println(finalMessage);
		this.writer.flush();
		return finalMessage;
	}
}
