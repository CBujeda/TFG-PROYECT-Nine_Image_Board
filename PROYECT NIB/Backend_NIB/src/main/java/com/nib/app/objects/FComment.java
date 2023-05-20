package com.nib.app.objects;

import java.util.Date;

import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.user.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FComment {

	private Long id_comment;
	private String token_usuario;
	private Long id_post;
    private String nameUsuario;
    private String imgUsuario;
	
	private String message;
	
	private Date date;

	public FComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FComment(Long id_comment, String token_usuario, Long id_post, String nameUsuario, String imgUsuario,
			String message, Date date) {
		super();
		this.id_comment = id_comment;
		this.token_usuario = token_usuario;
		this.id_post = id_post;
		this.nameUsuario = nameUsuario;
		this.imgUsuario = imgUsuario;
		this.message = message;
		this.date = date;
	}

	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}

	public String getToken_usuario() {
		return token_usuario;
	}

	public void setToken_usuario(String token_usuario) {
		this.token_usuario = token_usuario;
	}

	public Long getId_post() {
		return id_post;
	}

	public void setId_post(Long id_post) {
		this.id_post = id_post;
	}

	public String getNameUsuario() {
		return nameUsuario;
	}

	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}

	public String getImgUsuario() {
		return imgUsuario;
	}

	public void setImgUsuario(String imgUsuario) {
		this.imgUsuario = imgUsuario;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FComment [id_comment=" + id_comment + ", token_usuario=" + token_usuario + ", id_post=" + id_post
				+ ", nameUsuario=" + nameUsuario + ", imgUsuario=" + imgUsuario + ", message=" + message + ", date="
				+ date + "]";
	}

	
	
	
}
