package workingwithelements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitIntro {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Executing BeforeAll...");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Executing AfterAll...");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Executing BeforeEach...");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Executing AfterEach...");
	}

	@Test
	void test1() {
		System.out.println("Executing Test1...");
	}

	@Test
	void test2() {
		System.out.println("Executing Test2...");
	}

}
