package org.adra.app.bi.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name="tbl_socio")
public class Socio {
	
	@Id
	@Column(name="id_persona")
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@PrimaryKeyJoinColumn
	private Persona persona;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_banco_comunal", referencedColumnName = "id_banco_comunal")
	private Banco_Comunal banco_comunal;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "socio")
	@JsonIgnore
	//@JoinColumn(name="id_pedido_oracion")
	private List<Pedido_Oracion> pedido_oracion;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "socio")
	@JsonIgnore
	//@JoinColumn(name="id_afiliacion")
	private List<Afiliacion> afiliacion;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "socio")
	@JsonIgnore
	//@JoinColumn(name="id_sesion_socio")
	private List<Sesion_socio> sesion_socio;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "socio")
	@JsonIgnore
	//@JoinColumn(name="id_control_vista")
	private List<Control_Vista> control_vista;
	
}
