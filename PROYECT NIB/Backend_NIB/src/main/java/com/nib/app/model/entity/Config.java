package com.nib.app.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "config")
public class Config implements Serializable{

	private static final long serialVersionUID = -247852851119605382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conf")
	private Long id_conf;
	
	@Column(name="conf",unique = true)
	private String conf;
	private String value;
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Config(String conf, String value) {
		super();
		this.conf = conf;
		this.value = value;
	}
	public Config(Long id_conf, String conf, String value) {
		super();
		this.id_conf = id_conf;
		this.conf = conf;
		this.value = value;
	}
	public Long getId_conf() {
		return id_conf;
	}
	public void setId_conf(Long id_conf) {
		this.id_conf = id_conf;
	}
	public String getConf() {
		return conf;
	}
	public void setConf(String conf) {
		this.conf = conf;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
