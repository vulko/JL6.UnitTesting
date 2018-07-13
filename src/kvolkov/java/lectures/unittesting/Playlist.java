package kvolkov.java.lectures.unittesting;

import java.io.File;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
	
	private List<MusicFile> mFilesList = new LinkedList();
	private ListIterator<MusicFile> mCurrentTrackIterator = null;
	private MusicFile mCurrentTrack = null;

	public void addFiles(List<MusicFile> files) throws Exception {
		if (files == null || files.isEmpty()) {
			throw new Exception("Playlist is invalid or empty!");
		}

		mFilesList.addAll(files);
		mCurrentTrackIterator = mFilesList.listIterator(0);
		mCurrentTrack = mCurrentTrackIterator.next();
	}

	public MusicFile getCurrentTrack() {
		return mCurrentTrack;
	}
	
	public MusicFile nextTrack() {
		if (mCurrentTrackIterator.hasNext()) {
			mCurrentTrack = mCurrentTrackIterator.next();

			return mCurrentTrack;
		} else {
			return null;
		}
	}
	
	public MusicFile previousTrack() {
		if (mCurrentTrackIterator.hasPrevious()) {
			mCurrentTrack = mCurrentTrackIterator.previous();

			return mCurrentTrack;
		} else {
			return null;
		}
	}
	
	public void cleanup() {
		for (MusicFile musicFile : mFilesList) {
			musicFile.cleanup();
		}
		mFilesList.clear();
	}

}
