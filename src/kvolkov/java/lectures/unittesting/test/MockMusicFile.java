package kvolkov.java.lectures.unittesting.test;

import kvolkov.java.lectures.unittesting.MusicFile;

public class MockMusicFile extends MusicFile {
	
	public void simulateLoad(String name) {
		mName = name;
		verify();
	}
	
}