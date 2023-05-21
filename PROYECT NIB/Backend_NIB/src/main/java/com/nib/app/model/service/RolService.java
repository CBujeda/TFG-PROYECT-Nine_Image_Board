package com.nib.app.model.service;

import java.util.List;

import com.nib.app.model.entity.user.Rol;

/*
 * Servicio de roles
 */
public interface RolService {
	
	public Rol saveRol(Rol rol);
	
	public List<Rol> saveRolList(List<Rol> roles);
	
	public Rol findByName(Rol rol);
	public Rol findByName(String name);
	
	public boolean isExistsRolByName(Rol rol);
	public Rol getDefaultRol();
	
	public boolean isthisUserAdminByToken(String token);
}
