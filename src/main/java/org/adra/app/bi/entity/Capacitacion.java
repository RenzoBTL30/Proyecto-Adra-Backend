package org.adra.app.bi.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_capacitacion")
public class Capacitacion implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_capacitacion")
	private int id;
	private String no_capacitacion;
	private String de_capacitacion;
	private int ca_recursos;
	private char es_capacitacion;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_capacitacion", nullable = false)
	private Tipo_Capacitacion tipo_capacitacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_sesion")
	private Set<Sesion> sesiones;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_afiliacion")
	private Set<Afiliacion> afiliaciones;
}
