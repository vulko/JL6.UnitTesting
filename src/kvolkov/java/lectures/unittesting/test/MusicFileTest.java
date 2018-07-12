package kvolkov.java.lectures.unittesting.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kvolkov.java.lectures.unittesting.MusicFile;

class MusicFileTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLoad() {
		MusicFile file = new MusicFile();

		try {
			file.load(null);
			fail("Should generate exception");
		} catch (Exception e) {
			// expected
		}	

		try {
			file.load("");
			fail("Should generate exception");
		} catch (Exception e) {
			// expected
		}	
	}

}
