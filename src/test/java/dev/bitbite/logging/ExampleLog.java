package dev.bitbite.logging;

public class ExampleLog extends Log {

	@Override
	public String log(LogMessage logMessage) {
		return this.format(logMessage.logLevel, logMessage.category, logMessage.message);
	}

}
