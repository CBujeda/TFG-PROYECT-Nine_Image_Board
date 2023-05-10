package com.nib.app.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nib.app.model.entity.user.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "post")
public class Post implements Serializable{

	private static final long serialVersionUID = -2462737385258353400L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="postsecuence",sequenceName="DB_SEQUENCIA", allocationSize=1)
	@Column(name="id_post")
	private Long id_post;
	private String img_name;
	private String extension;
	private Date date;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "id_usuario") // creamos la columna de tipo objeto con joinColumn
    private Usuario usuario;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
  		  name = "post_NN_type", 
  		  joinColumns = @JoinColumn(name = "id_post"), 
  		  inverseJoinColumns = @JoinColumn(name = "id_type"))
	
	//@JoinColumn(name = "id_type") // creamos la columna de tipo objeto con joinColumn
	private Set<Type> typelist;
    
	@JsonIgnore
    @ManyToMany
    @JoinTable(
    		  name = "post_NN_tag", 
    		  joinColumns = @JoinColumn(name = "id_post"), 
    		  inverseJoinColumns = @JoinColumn(name = "id_tag"))
    
    //@JoinColumn(name = "tags")
    private Set<Tag> taglist;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long id_post, String img_name, String extension, Date date, Usuario usuario, Set<Type> typelist,
			Set<Tag> taglist) {
		super();
		this.id_post = id_post;
		this.img_name = img_name;
		this.extension = extension;
		this.date = date;
		this.usuario = usuario;
		this.typelist = typelist;
		this.taglist = taglist;
	}

	public Long getId_post() {
		return id_post;
	}

	public void setId_post(Long id_post) {
		this.id_post = id_post;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Type> getTypelist() {
		return typelist;
	}

	public void setTypelist(Set<Type> typelist) {
		this.typelist = typelist;
	}

	public Set<Tag> getTaglist() {
		return taglist;
	}

	public void setTaglist(Set<Tag> taglist) {
		this.taglist = taglist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
