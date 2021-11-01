package org.adra.app.bi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_afiliacion")
public class Afiliacion implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_afiliacion")
	private int id;
	private int ca_recursos_vistos;
	
	@ManyToOne
	@JoinColumn(name="id_persona", nullable = false)
	private Socio socio;
	
	@ManyToOne
	@JoinColumn(name="id_capacitacion", nullable = false)
	private Capacitacion capacitacion;
	
	
}