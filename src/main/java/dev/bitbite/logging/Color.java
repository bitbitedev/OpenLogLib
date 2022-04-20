package dev.bitbite.logging;

public enum Color {
	RESET ("\u001b[0m"),
	
	// 8 bit
	BLACK ("\u001b[30m"),
	BLUE ("\u001b[34m"),
	CYAN ("\u001b[36m"),
	GREEN ("\u001b[32m"),
	MAGENTA ("\u001b[35m"),
	RED ("\u001b[31m"),
	WHITE ("\u001b[37m"),
	YELLOW ("\u001b[33m"),
	// 16 bit
	BRIGHT_BLACK ("\u001b[30;1m"),
	BRIGHT_BLUE ("\u001b[34;1m"),
	BRIGHT_CYAN ("\u001b[36;1m"),
	BRIGHT_GREEN ("\u001b[32;1m"),
	BRIGHT_MAGENTA ("\u001b[35;1m"),
	BRIGHT_RED ("\u001b[31;1m"),
	BRIGHT_WHITE ("\u001b[37;1m"),
	BRIGHT_YELLOW ("\u001b[33;1m"),
	// 256 bit
	ORANGE ("\u001b[38;5;202m"),
	BRIGHT_ORANGE ("\u001b[38;5;208m"),
	DARK_ORANGE ("\u001b[38;5;166m"),
	PURPLE ("\u001b[38;5;99m"),
	BRIGHT_PURPLE ("\u001b[38;5;135m"),
	DARK_PURPLE ("\u001b[38;5;56m"),
	DARK_BLUE ("\u001b[38;5;17m"),
	DARK_CYAN ("\u001b[38;5;31m"),
	DARK_GREEN ("\u001b[38;5;22m"),
	DARK_MAGENTA ("\u001b[38;5;53m"),
	DARK_RED ("\u001b[38;5;52m"),
	DARK_WHITE ("\u001b[38;5;244m"),
	DARK_YELLOW ("\u001b[38;5;136m");
	
	private final String colorcode;
	
	Color(String colorcode) {
		this.colorcode = colorcode;
	}
	
	public String getColorCode() {
		return this.colorcode;
	}
}