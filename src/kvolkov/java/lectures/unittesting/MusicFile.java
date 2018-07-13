package kvolkov.java.lectures.unittesting;

import java.io.File;

public class MusicFile {
	
	public enum FileType {
		UNSUPPORTED,
		MP3,
		WAV,
		AAC
	};
	
	protected String mName;
	private FileType mFileType;
	private File mFile;

	public void load(String path) throws Exception {
		mFile = new File(path);
		if (!mFile.isFile()) {
			throw new Exception("No file exists with a given path: " + path);
		} else {
			mName = mFile.getName();
			verify();
		}
	}

	public void cleanup() {
		// TODO: cleanup
	}
	
	public FileType getType() {
		return mFileType;
	}

	public String getName() {
		return mName;
	}

	@Override
	public String toString() {
		return mName + " of type: " + mFileType.toString();
	}
	
	protected void verify() {
		// check extension
		String extension = "";
		int pos = mName.lastIndexOf('.');
		if (pos > 0) {
		    extension = mName.substring(pos + 1);
		}
		
		if (extension.toLowerCase().equals("mp3")) {
			mFileType = FileType.MP3;
		} else if (extension.toLowerCase().equals("wav")) {
			mFileType = FileType.WAV;
		} else if (extension.toLowerCase().equals("aac")) {
			mFileType = FileType.AAC;
		} else {
			mFileType = FileType.UNSUPPORTED;
		}
	}

}
