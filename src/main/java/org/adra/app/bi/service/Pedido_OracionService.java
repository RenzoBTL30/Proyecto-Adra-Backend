package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Pedido_Oracion;

public interface Pedido_OracionService {
	Pedido_Oracion create(Pedido_Oracion pedido_oracion);
	List<Pedido_Oracion> readAll();
	Pedido_Oracion read(int id);
	void delete(int id);
	Pedido_Oracion update(Pedido_Oracion pedido_oracion);
}
