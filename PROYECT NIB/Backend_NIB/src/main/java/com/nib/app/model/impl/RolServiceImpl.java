package com.nib.app.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.RolDAO;
import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDAO roldao;
	
	@Override
	public Rol saveRol(Rol rol) {
		Rol localRol = findByName(rol);
		
		if(localRol != null) {
			System.err.println("[ERROR] [si003] - El Rol a insertar ya existe");
		}else {
			try {
				localRol = roldao.save(rol);
			}catch(Exception e) {
				System.out.println("[ERROR] [si004] - Error al insertar un rol");
			}
		}
		return localRol;
	}

	@Override
	public List<Rol> saveRolList(List<Rol> roles) {
		List<Rol> localRoles = new ArrayList<Rol>();
		System.out.println("Hola");
		System.out.println(roles.size());
		for(int i = 0; i < roles.size();i++) {
			localRoles.add(i, this.saveRol(roles.get(i)));
		}
		return localRoles;
	}

	@Override
	public Rol findByName(Rol rol) {
		Rol r = findByName(rol.getNombre());
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}
	@Override
	public Rol findByName(String name) {
		Rol r = roldao.findByNombre(name);
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}

	@Override
	public boolean isExistsRolByName(Rol rol) {
		if(findByName(rol) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Rol getDefaultRol() {
		Rol r = findByName("USER");
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}

	
	
}
