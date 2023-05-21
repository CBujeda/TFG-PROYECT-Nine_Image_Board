package com.nib.app.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/*
 * Entidad de insultList
 * 		// Implementacion en futuras versiones
 */
@Entity
@Table(name = "InsultList")
public class InsultList  implements Serializable{

	private static final long serialVersionUID = -6598750758332736257L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="postsecuence",sequenceName="DB_SEQUENCIA", allocationSize=1)
	@Column(name="id_insult")
	private Long id_insult;
	
	@Column(name="insult")
	private String insult;
}
