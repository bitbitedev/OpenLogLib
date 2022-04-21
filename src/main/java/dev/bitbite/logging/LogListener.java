package dev.bitbite.logging;

/**
 * This class holds methods to be called when certain events occur
 */
public interface LogListener {
	
	/**
	 * Will be called whenever a new log message is processed
	 */
	public void onLog();
}
