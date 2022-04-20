package dev.bitbite.logging;

public class Categories {
	public static final Category NONE = new Category("DEFAULT", Color.RESET);
	public static final Category DEBUG = new Category("Debug", Color.BLUE);
	public static final Category FILE = new Category("File", Color.CYAN);
	public static final Category SQL = new Category("SQL", Color.YELLOW);
}
