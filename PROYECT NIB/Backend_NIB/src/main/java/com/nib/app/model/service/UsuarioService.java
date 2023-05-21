package com.nib.app.model.service;

import java.util.List;


import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;

/*
 * Servicio de usuarios
 */
public interface UsuarioService {


	public boolean saveUsuario(Usuario usuario);
	
	public Usuario findByUsername(String usuario);
	public Usuario findByUsername(Usuario usuario);
	
	public boolean isExistsUsernameByUsername(Usuario usuario);
	
	public boolean deleteUser(Usuario usuario);
	public boolean deleteUserById(Long id);
	
	public String login(Usuario usuario);
	
	public Usuario findUsernameByToken(String token);
	
	public boolean verifyToken(String token);
	
	public boolean updateUser(Usuario usuario);
}

