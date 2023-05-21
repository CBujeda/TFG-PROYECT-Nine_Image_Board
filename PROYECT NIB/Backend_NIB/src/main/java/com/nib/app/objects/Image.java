package com.nib.app.objects;

/*
 * Objeto el cual almacena una imagen en base64
 */
public class Image {
	
	private String title;
	private String tags;
	private String base64Img;
	private String token;
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String title, String tags, String base64Img, String token) {
		super();
		this.title = title;
		this.tags = tags;
		this.base64Img = base64Img;
		this.token = token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Image [title=" + title + ", tags=" + tags + ", base64Img=" + base64Img + ", token=" + token + "]";
	}

	

}
