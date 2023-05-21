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

/*
 * Entidad de Tag
 */
@Entity
@Table(name = "tag")
public class Tag implements Serializable {

	private static final long serialVersionUID = -8511788052263461642L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tag")
	private Long id_tag;
	
	private String name;
	
	@ManyToMany(mappedBy = "taglist")
   // @JoinColumn(name = "posts")
    private Set<Post> postList;

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tag(Long id_tag, String name, Set<Post> postList) {
		super();
		this.id_tag = id_tag;
		this.name = name;
		this.postList = postList;
	}

	public Long getId_tag() {
		return id_tag;
	}

	public void setId_tag(Long id_tag) {
		this.id_tag = id_tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
