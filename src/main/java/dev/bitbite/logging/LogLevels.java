package dev.bitbite.logging;

public class LogLevels {
	public static final LogLevel NONE = new LogLevel("DEFAULT", Color.RESET, -1);
	public static final LogLevel DEBUG = new LogLevel("Debug", Color.BLUE, 0);
	public static final LogLevel INFO = new LogLevel("Info", Color.CYAN, 10);
	public static final LogLevel WARNING = new LogLevel("Warning", Color.YELLOW, 20);
	public static final LogLevel ERROR = new LogLevel("Error", Color.ORANGE, 30);
	public static final LogLevel CRITICAL = new LogLevel("Critical", Color.DARK_RED, 40);
	public static final LogLevel STACKTRACE = new LogLevel("StackTrace", Color.RED, 40);
}