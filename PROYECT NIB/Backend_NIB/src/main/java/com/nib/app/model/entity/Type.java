package com.nib.app.model.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "type")
public class Type implements Serializable {

	private static final long serialVersionUID = 8124193360669468165L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_type")
	private Long id_type;
	
	private String name;
	private String[] extensions;

	
	@ManyToMany(mappedBy = "typelist")
	// @JoinColumn(name = "posts")
    private Set<Post> postList;


	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Type(Long id_type, String name, String[] extensions, Set<Post> postList) {
		super();
		this.id_type = id_type;
		this.name = name;
		this.extensions = extensions;
		this.postList = postList;
	}


	public Long getId_type() {
		return id_type;
	}


	public void setId_type(Long id_type) {
		this.id_type = id_type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getExtensions() {
		return extensions;
	}


	public void setExtensions(String[] extensions) {
		this.extensions = extensions;
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
