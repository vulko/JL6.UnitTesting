package kvolkov.java.lectures.unittesting;

import java.io.File;

public class MusicFile {
	
	enum FileType {
		unsupported,
		mp3,
		wav,
		aac
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
		}
	}

	public void verify() {
		// TODO: check filetype if supported
	}

	public void close() {
		// TODO: cleanup
	}

}
