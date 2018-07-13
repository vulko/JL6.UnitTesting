package kvolkov.java.lectures.unittesting.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kvolkov.java.lectures.unittesting.MusicFile;
import kvolkov.java.lectures.unittesting.MusicFile.FileType;
import kvolkov.java.lectures.unittesting.Playlist;

class PlaylistTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlaylistLoadAndIterate() {
		List<MusicFile> fileList = new LinkedList();
		MockMusicFile file = new MockMusicFile();
		
		file.simulateLoad("song1.mp3");
		fileList.add(file);
		
		file = new MockMusicFile();
		file.simulateLoad("song2.mp3");
		fileList.add(file);
		
		file = new MockMusicFile();
		file.simulateLoad("song3.mp3");
		fileList.add(file);
		
		Playlist playlist = new Playlist();
		try {
			playlist.addFiles(fileList);
		} catch (Exception e) {
			fail("Should not throw exception!");
		}

		MusicFile playlistFile = playlist.getCurrentTrack();
		assertTrue(playlistFile.getType() == FileType.MP3);
		assertEquals(playlistFile.getName(), "song1.mp3");

		playlistFile = playlist.nextTrack();
		assertTrue(playlistFile.getType() == FileType.MP3);
		assertEquals(playlistFile.getName(), "song2.mp3");

		playlistFile = playlist.nextTrack();
		assertTrue(playlistFile.getType() == FileType.MP3);
		assertEquals(playlistFile.getName(), "song3.mp3");

		playlistFile = playlist.nextTrack();
		assertEquals(playlistFile, null);

		playlistFile = playlist.previousTrack();
		assertTrue(playlistFile.getType() == FileType.MP3);
		assertEquals(playlistFile.getName(), "song2.mp3");

		playlistFile = playlist.previousTrack();
		assertTrue(playlistFile.getType() == FileType.MP3);
		assertEquals(playlistFile.getName(), "song1.mp3");

		playlistFile = playlist.previousTrack();
		assertEquals(playlistFile, null);
	}
	
}
