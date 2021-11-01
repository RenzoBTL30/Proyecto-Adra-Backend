package org.adra.app.bi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_sesion")
public class Sesion implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sesion")
	private int id;
	private String de_tema;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fe_inicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fe_fin;
	private int nu_orden;
	private int ca_recursos;
	
	@ManyToOne
	@JoinColumn(name="id_capacitacion", nullable = false)
	private Capacitacion capacitacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_recurso")
	private Set<Recurso> recursos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_sesion_socio")
	private Set<Sesion_socio> sesion_socios;
}
