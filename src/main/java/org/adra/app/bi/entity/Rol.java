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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private int id;
	private String no_rol;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario_rol")
	private Set<Usuario_rol> usuario_roles;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_rol_privilegio")
	private Set<Rol_privilegio> rol_privilegios;
}
