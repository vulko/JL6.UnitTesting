package kvolkov.java.lectures.unittesting.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kvolkov.java.lectures.unittesting.MusicFile;
import kvolkov.java.lectures.unittesting.MusicFile.FileType;
import kvolkov.java.lectures.unittesting.MusicPlayer;
import kvolkov.java.lectures.unittesting.MusicPlayer.PlayerState;
import kvolkov.java.lectures.unittesting.Playlist;

class MusicPlayerTest {
	
	static class MockMusicPlayer extends MusicPlayer {

		public void simulateLoadPlaylist(Playlist list) {
			mPlaylist = list;
		}

	}
	
	MockMusicPlayer mPlayer = new MockMusicPlayer();
	
	@BeforeEach
	void setUp() throws Exception {
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
		
		mPlayer.simulateLoadPlaylist(playlist);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlayerChangeState() {
		assertTrue(mPlayer.getCurrentState() == PlayerState.UNKNOWN);
		
		mPlayer.play();
		assertTrue(mPlayer.getCurrentState() == PlayerState.PLAYING);
		
		mPlayer.pause();
		assertTrue(mPlayer.getCurrentState() == PlayerState.PAUSED);

		mPlayer.play();
		assertTrue(mPlayer.getCurrentState() == PlayerState.PLAYING);
		
		mPlayer.stop();
		assertTrue(mPlayer.getCurrentState() == PlayerState.STOPPED);
	}
	
}
