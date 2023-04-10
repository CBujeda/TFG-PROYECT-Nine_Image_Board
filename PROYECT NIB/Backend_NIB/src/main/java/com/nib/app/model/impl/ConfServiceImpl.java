package com.nib.app.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.ConfigDAO;
import com.nib.app.model.entity.Config;
import com.nib.app.model.service.ConfService;

@Service
public class ConfServiceImpl implements ConfService {

	@Autowired
	private ConfigDAO confdao;
	
	@Override
	public Long getCont() {
		return confdao.count();
	}

	@Override
	public void addConf(Config conf) {
		confdao.save(conf);
	}

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
