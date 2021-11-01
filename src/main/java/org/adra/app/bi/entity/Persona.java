package org.adra.app.bi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int id;
	
	private String no_persona;
	private String ap_paterno;
	private String ap_materno;
	private String nu_dni;
	private String em_correo_electronico;
	private String nu_telefono;
	
	@OneToOne(mappedBy = "persona")
	private Socio socio;
	
	@OneToOne(mappedBy = "persona")
	private Usuario usuario;
}