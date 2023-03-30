package dev.bitbite.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestLog {

	@Test
	public void testLogMessage() {
		assertThrows(IllegalArgumentException.class,
				() -> new LogMessage(null, Categories.DEFAULT, "Hello World", null));
		assertThrows(IllegalArgumentException.class, () -> new LogMessage(LogLevels.INFO, null, "Hello World", null));
		assertThrows(IllegalArgumentException.class,
				() -> new LogMessage(LogLevels.INFO, Categories.DEFAULT, null, null));
	}

	@Test
	public void testLogProperties() {
		Log log = new ExampleLog();
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> log.setProperties(null));
		assertEquals("LogProperties cannot be null", exception.getMessage());
		log.setProperties(null);
	}

	@Test
	public void testLog() {
		Log log = new ExampleLog();
		String message = log.log(new LogMessage(LogLevels.INFO, Categories.DEFAULT, "Hello World", null));
		String time = log.getProperties().getDateTimeFormat().format(new Date());
		assertEquals("[" + time + "][Info][DEFAULT]: Hello World", message);
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> log.log(null));
		assertEquals("LogMessage cannot be null", exception.getMessage());
	
	}
}