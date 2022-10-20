package dev.bitbite.logging;

import dev.thatsnasu.ansi.Ansi;

/**
 * A LogLevel can be used to filter the messages by their importance.
 */
public class LogLevel {
	public final String name;
	public final Ansi ansi;
	public final int level;
	
	
	/**
	 * Creates a new LogLevel object, which will hold a name, a {@link Ansi} for formatting, as well as the level for filtering the output.
	 * @param name of the LogLevel
	 * @param ansi of the LogLevel
	 * @param level integer; higher is more important
	 */
	public LogLevel(String name, Ansi ansi, int level) {
		this.name = name;
		this.ansi = ansi;
		this.level = level;
	}
}