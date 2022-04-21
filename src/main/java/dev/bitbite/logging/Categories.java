package dev.bitbite.logging;

/**
 * This is a holder class for some default Categories for use without having to define them yourself. For the most rudimentary projects,
 * this will be enough, but feel free to extend this class as you need.
 * 
 * @see Category
 */
public class Categories {
	public static final Category NONE = new Category("DEFAULT", Color.RESET);
	public static final Category DEBUG = new Category("Debug", Color.BLUE);
	public static final Category FILE = new Category("File", Color.CYAN);
	public static final Category SQL = new Category("SQL", Color.YELLOW);
}
