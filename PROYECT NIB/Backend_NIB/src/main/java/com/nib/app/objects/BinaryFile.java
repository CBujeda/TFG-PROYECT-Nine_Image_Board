package com.nib.app.objects;

public class BinaryFile {

	private byte[] data;
	private String format;
	public BinaryFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BinaryFile(byte[] data, String format) {
		super();
		this.data = data;
		this.format = format;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
}
