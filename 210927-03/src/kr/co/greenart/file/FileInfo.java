package kr.co.greenart.file;

import java.util.Arrays;

public class FileInfo {
	private int id;
	private String fileName;
	private byte[] file;
	
	public FileInfo() {
	}

	public FileInfo(int id, String fileName, byte[] file) {
		this.id = id;
		this.fileName = fileName;
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", fileName=" + fileName + ", file=" + Arrays.toString(file) + "]";
	}
}
