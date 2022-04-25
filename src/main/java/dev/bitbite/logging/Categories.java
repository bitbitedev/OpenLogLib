package dev.bitbite.logging;

import dev.thatsnasu.ansi.Ansi;
import dev.thatsnasu.ansi.Color3b;

/**
 * This is a holder class for some default Categories for use without having to define them yourself. For the most rudimentary projects,
 * this will be enough, but feel free to extend this class as you need.
 * 
 * @see Category
 */
public class Categories {
	public static final Category NONE = new Category("DEFAULT", new Ansi(Color3b.RESET));
	public static final Category DEBUG = new Category("DEFAULT", new Ansi(Color3b.MAGENTA));
	public static final Category FILE = new Category("DEFAULT", new Ansi(Color3b.CYAN));
	public static final Category SQL = new Category("DEFAULT", new Ansi(Color3b.YELLOW));
}
