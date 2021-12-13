package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Control_Vista;

public interface Control_VistaService {
	Control_Vista create(Control_Vista control_vista);
	List<Control_Vista> readAll();
	Control_Vista read(int id);
	void delete(int id);
	Control_Vista update(Control_Vista control_vista);
	String actualizarVisto(int param1, int param2);
}
