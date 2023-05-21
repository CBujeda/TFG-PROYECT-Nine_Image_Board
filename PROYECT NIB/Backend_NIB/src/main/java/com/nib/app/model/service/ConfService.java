package com.nib.app.model.service;

import com.nib.app.model.entity.Config;

/*
 * Servicio de configuracion
 */
public interface ConfService {

	public Long getCont();
	public void addConf(Config conf);
	public Config getConfbyConf(String conf);
}
