package dev.bitbite.logging;

public class LogLevel {
	public final String name;
	public final Color color;
	public final int level;
	
	public LogLevel(String name, Color color, int level) {
		this.name = name;
		this.color = color;
		this.level = level;
	}
}
