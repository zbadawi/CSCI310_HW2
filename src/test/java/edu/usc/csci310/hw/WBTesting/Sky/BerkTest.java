package edu.usc.csci310.hw.WBTesting.Sky;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class and method was created for the purposes of illustrating the most common JUnit5 annotations and the required class naming convention
 */
public class BerkTest {

	@BeforeAll
	static public void setupForAllTests() {
		// a method with this annotation will run once before any method with a Test annotation
		// note that the method needs to be static
	}

	@BeforeEach
	public void setupForATest() {
		// a method with this annotation will run before each method with a Test annotation
	}

	@Test
	public void testMain() {
		// any method intended to be run as a test must have the Test annotation
		// should have a call to an assert(.) function of some sort
		assertEquals("","");
	}

	@AfterEach
	public void testCleanup() {
		// a method with this annotation will run after each method with a Test annotation
	}

	@AfterAll
	static public void cleanupAfterAllTests() {
		// a method with this annotation will run once after all methods with a Test annotation
		// note that the method needs to be static
	}

}
