package com.nib.app.model.entity;

import java.util.Date;

import com.nib.app.model.entity.user.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * Entidad de comentarios
 */
@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comment")
	private Long id_comment;

	@ManyToOne
    @JoinColumn(name = "id_usuario") // creamos la columna de tipo objeto con joinColumn
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "id_post") // creamos la columna de tipo objeto con joinColumn
    private Post post;
	
	private String message;
	
	private Date date;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long id_comment, Usuario usuario, Post post, String message, Date date) {
		super();
		this.id_comment = id_comment;
		this.usuario = usuario;
		this.post = post;
		this.message = message;
		this.date = date;
	}

	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
}
