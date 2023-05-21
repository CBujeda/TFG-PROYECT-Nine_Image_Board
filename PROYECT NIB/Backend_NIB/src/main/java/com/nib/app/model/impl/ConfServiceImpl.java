package com.nib.app.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.ConfigDAO;
import com.nib.app.model.entity.Config;
import com.nib.app.model.service.ConfService;

/*
 * Implementacion del servicio de configuracion
 */
@Service
public class ConfServiceImpl implements ConfService {

	@Autowired
	private ConfigDAO confdao;
	
	/*
	 * Pre:
	 * Post: Metodo para obtener las configuraciones disponibles totales
	 */
	@Override
	public Long getCont() {
		return confdao.count();
	}

	/*
	 * Pre:
	 * Post: Metodo para añadir una configuration
	 */
	@Override
	public void addConf(Config conf) {
		confdao.save(conf);
	}

	/*
	 * Pre:
	 * Post: Metodo para obtener la configuracion por su tipo
	 */
	@Override
	public Config getConfbyConf(String conf) {
		List<Config> c = confdao.findbyConfig(conf);
		Config confe = null;
		if(c.size() > 0) {
			confe = c.get(0);
		}
		return confe;
	}

}
