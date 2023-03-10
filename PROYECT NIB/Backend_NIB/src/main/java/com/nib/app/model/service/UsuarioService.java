package com.nib.app.model.service;

import java.util.List;


import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;


public interface UsuarioService {


	public Usuario saveUsuario(Usuario usuario);
	
	public Usuario findByUsername(String usuario);
	public Usuario findByUsername(Usuario usuario);
	
	public boolean isExistsUsernameByUsername(Usuario usuario);
	
	public boolean deleteUser(Usuario usuario);
	public boolean deleteUserById(Long id);
}

