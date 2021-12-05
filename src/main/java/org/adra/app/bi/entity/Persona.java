package org.adra.app.bi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String em_correo_electronico;
	private String nu_telefono;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
	@JsonIgnore
	private Socio socio;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
	@JsonIgnore
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
	@JsonIgnore
	//@JoinColumn(name="id_banco_comunal")
	private List<Banco_Comunal> banco_comunal;
}
