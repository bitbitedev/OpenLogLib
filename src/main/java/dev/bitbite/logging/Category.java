package dev.bitbite.logging;

import dev.thatsnasu.ansi.Ansi;

/**
 * A Category can be used to define some filters for the log output. It will hold some information, which makes it easier to find what
 * you're looking for while reading the logs.
 */
public class Category {
	public final String name;
	public final Ansi ansi;
	
	/**
	 * Creates a new Category Object, which will hold a name for display purposes, as well as an {@link Ansi} Object, which can be used for formatting
	 * @param name of the Category
	 * @param ansi used for formatting
	 */
	public Category(String name, Ansi ansi) {
		this.name = name;
		this.ansi = ansi;
	}
	
	/**
	 * Creates a new Category Object, which will hold a name for display purposes.
	 * @param name of the Category
	 */
	public Category(String name) {
		this.name = name;
		this.ansi = new Ansi();
	}
}
