package dev.bitbite.logging;

/**
 * A Category can be used to define some filters for the log output. It will hold some information, which makes it easier to find what
 * you're looking for while reading the logs.
 */
public class Category {
	public final String name;
	public final Color color;
	
	/**
	 * Creates a new Category Object, which will hold a name for display purposes, as well as a {@link Color}, which can be used for formatting
	 * @param name - The name the Category shall use.
	 * @param color - The {@link Color} to be used.
	 */
	public Category(String name, Color color) {
		this.name = name;
		this.color = color;
	}
}
