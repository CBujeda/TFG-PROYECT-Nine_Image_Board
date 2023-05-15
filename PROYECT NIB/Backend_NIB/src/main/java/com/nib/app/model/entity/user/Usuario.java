package com.nib.app.model.entity.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nib.app.model.entity.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

	private static final long serialVersionUID = -3256103979765596155L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id_usuario;
	
	private String username;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private boolean verify = true;
	private String imgProfile;
	private String token;
	
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",orphanRemoval = true, cascade = CascadeType.ALL)   
    private Set<Post> postList; 
	
	//@JsonManagedReference
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)	//fetch = FetchType.EAGER, ,mappedBy = "userlist"
	@JoinTable(
			name="usuario_nn_rol",
			joinColumns = @JoinColumn(name="id_usuario",unique = false),
			inverseJoinColumns = @JoinColumn(name="id_rol",unique = false)
			)
	@JsonIgnore
	private Set<Rol> roleslist;


	public Usuario() {
		super();
		roleslist = new HashSet<>();
		
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long id_usuario, String username, String nombre, String apellido, String email, String password,
			boolean verify, String imgProfile, Set<Post> postList, Set<Rol> roleslist) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.verify = verify;
		this.imgProfile = imgProfile;
		this.postList = postList;
		this.roleslist = roleslist;
	}


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isVerify() {
		return verify;
	}


	public void setVerify(boolean verify) {
		this.verify = verify;
	}


	public String getImgProfile() {
		return imgProfile;
	}


	public void setImgProfile(String imgProfile) {
		this.imgProfile = imgProfile;
	}


	public Set<Post> getPostList() {
		return postList;
	}


	public void setPostList(Set<Post> postList) {
		this.postList = postList;
	}


	public Set<Rol> getRoleslist() {
		return roleslist;
	}


	public void setRoleslist(Set<Rol> roleslist) {
		this.roleslist = roleslist;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario:" + id_usuario + ", username:" + username + ", nombre:" + nombre + ", apellido:"
				+ apellido + ", email:" + email + ", password:" + password + ", verify:" + verify + ", imgProfile:"
				+ imgProfile + ", postList:[NO VIEW], roleslist: [NO VIEW] ]";
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

}
