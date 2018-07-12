package kvolkov.java.lectures.unittesting;

public class MusicPlayer {
	
	enum PlayerState {
		UNKNOWN, STOPPED, PLAYING, PAUSED
	}
	
	private Playlist mPlaylist = null;
	private PlayerState mState = PlayerState.UNKNOWN;

	public void openDirectory() {
		if (mState != PlayerState.UNKNOWN) {
			stopIfWasPlaying();
			if (mPlaylist != null) {
				mPlaylist.cleanup();
			}
		}

		mPlaylist = new Playlist();
		try {
			mPlaylist.addFiles(null);
		} catch (Exception e) {
			// TODO: handle
		}
	}
	
	public void play() {
		if (mState == PlayerState.PLAYING) {
			return;
		}

		startPlayback();
		mState = PlayerState.PLAYING;
	}
	
	public void pause() {
		if (mState == PlayerState.PAUSED) {
			return;
		}

		pausePlayback();
		mState = PlayerState.PAUSED;
	}
	
	public void stop() {
		if (mState == PlayerState.STOPPED) {
			return;
		}

		stopPlayback();
		mState = PlayerState.STOPPED;
	}
	
	public void next() {
		boolean continuePlayback = stopIfWasPlaying();
		
		mPlaylist.nextTrack();

		if (continuePlayback) {
			play();
		}
	}
	
	public void previous() {
		boolean continuePlayback = stopIfWasPlaying();

		mPlaylist.previousTrack();

		if (continuePlayback) {
			play();
		}
	}
	
	private boolean stopIfWasPlaying() {
		if (mState == PlayerState.PLAYING) {
			stop();

			return true;
		}

		return false;
	}
	
	private void startPlayback() {
		System.out.println("Play file " + mPlaylist.getCurrentTrack().toString());
	}

	private void pausePlayback() {
		System.out.println("Pause file " + mPlaylist.getCurrentTrack().toString());
	}
	
	private void stopPlayback() {
		System.out.println("Stop file " + mPlaylist.getCurrentTrack().toString());
	}

}
