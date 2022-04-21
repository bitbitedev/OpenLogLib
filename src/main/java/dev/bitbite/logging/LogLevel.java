package dev.bitbite.logging;

/**
 * A LogLevel can be used to filter the messages by their importance.
 */
public class LogLevel {
	public final String name;
	public final Color color;
	public final int level;
	
	
	/**
	 * Creates a new LogLevel object, which will hold a name for output purposes, a {@link Color} for formatting, as well as the level for filtering the output. 
	 * @param name - The name the LogLevel shall use.
	 * @param color - The {@link Color} which will be used.
	 * @param level - Integer value for filtering the level.
	 */
	public LogLevel(String name, Color color, int level) {
		this.name = name;
		this.color = color;
		this.level = level;
	}
}
