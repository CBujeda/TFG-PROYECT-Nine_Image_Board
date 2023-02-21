package com.nib.app.model.entity.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
	
	private static final long serialVersionUID = 3552707046208988658L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long id_rol;
	private String nombre;
	
	//@JsonBackReference
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "roleslist")//,fetch = FetchType.LAZY,mappedBy = "rol"
	private Set<Usuario> userlist;

	public Rol() {
		super();
		userlist = new HashSet<>(); 
		// TODO Auto-generated constructor stub
	}

	public Rol(Long id_rol, String nombre, Set<Usuario> userlist) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.userlist = userlist;
	}

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUserlist() {
		return userlist;
	}

	public void setUserlist(Set<Usuario> userlist) {
		this.userlist = userlist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
