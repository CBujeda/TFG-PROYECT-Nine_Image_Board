package com.nib.app.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.RolDAO;
import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.service.RolService;

/*
 * Implementacion del servicio de roles
 */
@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDAO roldao;
	
	/*
	 * Pre:
	 * Post: Metodo con el cual almacenamos un rol en la BBDD
	 */
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

	/*
	 * Pre:
	 * Post: Metodo el cual devuelve una lista de roles
	 */
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
	
	/*
	 * Pre:
	 * Post: Metodo el cual busca un rol por su nombre
	 * 		 con un objeto de tipo Rol
	 */
	@Override
	public Rol findByName(Rol rol) {
		Rol r = findByName(rol.getNombre());
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}
	
	/*
	 * Pre:
	 * Post: Metodo el cual busca un rol por su nombre
	 */
	@Override
	public Rol findByName(String name) {
		Rol r = roldao.findByNombre(name);
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo el cual verifica si existe un rol
	 */
	@Override
	public boolean isExistsRolByName(Rol rol) {
		if(findByName(rol) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Pre:
	 * Post: Metodo el cual devuelve el rol default
	 */
	@Override
	public Rol getDefaultRol() {
		Rol r = findByName("USER");
		if(r == null) {
			return null;
		}else {
			return r;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo el cual verifica si un usuario es administrador
	 */
	@Override
	public boolean isthisUserAdminByToken(String token) {
		boolean isAdmin = false;
		List<Rol> r = roldao.findRolesByUserToken(token);
		for(int i = 0; i < r.size(); i++) {
			if(r.get(i).getNombre().equalsIgnoreCase("ADMIN")) {
				isAdmin = true;
			}
		}
		return isAdmin;
	}

	
	
}
