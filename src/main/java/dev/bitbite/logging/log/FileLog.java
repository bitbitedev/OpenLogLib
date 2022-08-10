package dev.bitbite.logging.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

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
	 * @throws FileNotFoundException if the output {@link File} could not be created.
	 */
	public FileLog(File logFile) throws FileNotFoundException {
		this.logFile = logFile;
		if(!Files.exists(this.logFile.toPath().toAbsolutePath().getParent())) this.logFile.toPath().toAbsolutePath().getParent().toFile().mkdirs();
		this.writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.logFile)));
	}
	
	/**
	 * Creates a new Log Object and a new output File, where the log will be written to. Afterwards registers itself to a given {@link ArrayList}.
	 * @param logFile to write to
	 * @param logs to be registered to
	 * @throws FileNotFoundException if the output {@link File} could not be created
	 */
	public FileLog(File logFile, ArrayList<Log> logs) throws FileNotFoundException {
		this(logFile);
		logs.add(this);
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
	public void log(LogMessage logMessage) {
		String logContent = "";
		if(logMessage.message != null) {
			logContent += logMessage.message;
		}
		if(logMessage.message != null && logMessage.exception != null) {
			logContent += " ";
		}
		if(logMessage.exception != null) {
			StackTraceElement elem = logMessage.exception.getStackTrace()[0];
			logContent += logMessage.exception.getMessage()+" in "+elem.getClassName()+":"+elem.getLineNumber();
		}
		this.writer.println(this.format(logMessage.logLevel, logMessage.category, logContent));
		if(logMessage.exception != null) {
			Arrays.stream(logMessage.exception.getStackTrace()).skip(1).forEach(e -> {
				this.writer.println(this.format(LogLevels.STACKTRACE, logMessage.category, e.getClassName()+" in line "+e.getLineNumber()));
			});
		}
		this.writer.flush();
	}

}
