package dev.bitbite.logging;

/**
 * A LogLevel can be used to filter the messages by their importance.
 */
public class LogLevel {
	public final String name;
	public final Color color;
	public final int level;
	
	
	/**
	 * Creates a new LogLevel object, which will hold a name, a {@link Color} for formatting, as well as the level for filtering the output.
	 * @param name of the LogLevel
	 * @param color of the LogLevel
	 * @param level integer; higher is more important
	 */
	public LogLevel(String name, Color color, int level) {
		this.name = name;
		this.color = color;
		this.level = level;
	}
}
