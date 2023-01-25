package com.nib.app.model.entity;

import java.io.Serializable;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3256103979765596155L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;

	private String email;
	private String username;
	private String password;
	private int rol;
	private boolean verify;
	
	@OneToMany(mappedBy = "usuario",orphanRemoval = true)   
    private Set<Post> postList; 
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, String apellido, String email, String username, String password, int rol,
			boolean verify, Set<Post> postList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.verify = verify;
		this.postList = postList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	public Set<Post> getPostList() {
		return postList;
	}

	public void setPostList(Set<Post> postList) {
		this.postList = postList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
}
