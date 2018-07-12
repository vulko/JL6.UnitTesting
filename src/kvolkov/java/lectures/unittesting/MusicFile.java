package kvolkov.java.lectures.unittesting;

import java.io.File;

public class MusicFile {
	
	enum FileType {
		UNSUPPORTED,
		MP3,
		WAV,
		AAC
	};
	
	private String mName;
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

	@Override
	public String toString() {
		return mName + " of type: " + mFileType.toString();
	}
	
	private void verify() {
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
