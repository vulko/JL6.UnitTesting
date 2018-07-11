package kvolkov.java.lectures.unittesting;

public class MusicPlayer {
	
	enum PlayerState {
		UNKNOWN, STOPPED, PLAYING, PAUSED
	}
	
	private Playlist mPlaylist = null;
	private PlayerState mState = PlayerState.UNKNOWN;

	public void createPlaylistFromDirectory() {
		if (mState != PlayerState.UNKNOWN) {
			// TODO: stop and cleanup
		}

		mPlaylist = new Playlist();
		try {
			mPlaylist.addFiles(null);
		} catch (Exception e) {
			// TODO: handle
		}
	}
	
	public void play() {
		mState = PlayerState.PLAYING;
		startPlayback();
	}
	
	public void pause() {
		mState = PlayerState.PAUSED;
		pausePlayback();
	}
	
	public void stop() {
		mState = PlayerState.STOPPED;
		stopPlayback();
	}
	
	public void next() {
		if (mState == PlayerState.PLAYING) {
			stop();
		}
		mPlaylist.nextTrack();
	}
	
	public void previous() {
		if (mState == PlayerState.PLAYING) {
			stop();
		}
		mPlaylist.previousTrack();
	}
	
	private void startPlayback() {
		// TODO: implement
	}

	private void pausePlayback() {
		// TODO: implement
	}
	
	private void stopPlayback() {
		// TODO: implement
	}

}
