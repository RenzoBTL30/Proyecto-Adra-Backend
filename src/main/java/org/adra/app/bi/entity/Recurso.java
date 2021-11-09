package org.adra.app.bi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_recurso")
public class Recurso implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recurso")
	private int id;
	private String no_recurso;
	private int nu_orden;
	private String di_url;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_sesion", referencedColumnName = "id_sesion")
	private Sesion sesion;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_tipo_recurso", referencedColumnName = "id_tipo_recurso")
	private Tipo_Recurso tipo_recurso;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_pregunta")
	private Set<Pregunta> preguntas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_control_vista")
	private Set<Control_Vista> control_vistas;
	*/
}
