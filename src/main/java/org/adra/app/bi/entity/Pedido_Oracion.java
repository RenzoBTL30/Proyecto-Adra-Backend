package org.adra.app.bi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_pedido_oracion")
public class Pedido_Oracion implements Serializable{
	
	private static final long serialVersionUID = -962936564953879252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_oracion")
	private int id;
	private String de_pedido_oracion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fe_creacion;
	
	@ManyToOne
	@JoinColumn(name="id_persona", nullable = false)
	private Socio socio;
}