package com.nib.app.objects;

/*
 * Generic Private Objects
 */
public class PO {

	private String token;
	private String data;
	public PO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PO(String token, String data) {
		super();
		this.token = token;
		this.data = data;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PO [token=" + token + ", data=" + data + "]";
	}
	
	
}
