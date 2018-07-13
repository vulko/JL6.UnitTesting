package kvolkov.java.lectures.unittesting.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kvolkov.java.lectures.unittesting.MusicFile;
import kvolkov.java.lectures.unittesting.MusicFile.FileType;

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
	
	@Test
	void testMockedLoading() {
		MockMusicFile file = new MockMusicFile();
		
		file.simulateLoad("Britney_Spears_is_the_best!!!.mp3");
		assertTrue(file.getType() == FileType.MP3);
		assertEquals(file.getName(), "Britney_Spears_is_the_best!!!.mp3");
		
		file.simulateLoad("SomeStudipSong.WaV");
		assertTrue(file.getType() == FileType.WAV);
		assertEquals(file.getName(), "SomeStudipSong.WaV");
		
		file.simulateLoad("SomeStudipSong.aAc");
		assertTrue(file.getType() == FileType.AAC);
		assertEquals(file.getName(), "SomeStudipSong.aAc");
		
		file.simulateLoad("strange file");
		assertTrue(file.getType() == FileType.UNSUPPORTED);
	}

}
