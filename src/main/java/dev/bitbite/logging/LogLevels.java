package dev.bitbite.logging;

import dev.thatsnasu.ansi.Ansi;
import dev.thatsnasu.ansi.Color3b;

/**
 * This class contains some default predefined {@link LogLevel}s. Add custom LogLevels by extending this class.
 */
public class LogLevels {
	public static final LogLevel NONE = new LogLevel("DEFAULT", new Ansi(Color3b.RESET), -1);
	public static final LogLevel DEBUG = new LogLevel("Debug", new Ansi(Color3b.MAGENTA), 0);
	public static final LogLevel INFO = new LogLevel("Info", new Ansi(Color3b.GREEN), 10);
	public static final LogLevel WARNING = new LogLevel("Warning", new Ansi(Color3b.CYAN), 20);
	public static final LogLevel ERROR = new LogLevel("Error", new Ansi(Color3b.YELLOW), 30);
	public static final LogLevel CRITICAL = new LogLevel("Critical", new Ansi(Color3b.RED), 40);
	public static final LogLevel STACKTRACE = new LogLevel("StackTrace", new Ansi(Color3b.RED), 40);
}