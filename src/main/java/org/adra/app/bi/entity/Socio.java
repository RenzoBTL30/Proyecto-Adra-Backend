package org.adra.app.bi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="id_banco_comunal", nullable = false)
	private Banco_Comunal banco_comunal;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedido_oracion")
	private Set<Pedido_Oracion> pedidos_oracion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_afiliacion")
	private Set<Afiliacion> afiliaciones;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_sesion_socio")
	private Set<Sesion_socio> sesion_socios;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_control_vista")
	private Set<Control_Vista> control_vistas;
}
