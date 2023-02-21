package com.nib.app.model.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.UsuarioDAO;
import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.RolService;
import com.nib.app.model.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario saveUsuario(Usuario usuario){
		Usuario localUser = findByUsername(usuario.getUsername());
		if(localUser != null) {
			System.err.println("[ERROR] [si002] - El usuario a insertar ya existe");
		}else{
			try {
				localUser = usuarioDAO.save(usuario);
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al añadir un usuario \n" + e.toString());
			}
		}
		return localUser;
	}

	
	
	@Override
	public Usuario findByUsername(String usuario) {
		return usuarioDAO.findByUsername(usuario);
	}

	@Override
	public Usuario findByUsername(Usuario usuario) {
		return findByUsername(usuario.getUsername());
	}

	@Override
	public boolean isExistsUsernameByUsername(Usuario usuario) {
		if(findByUsername(usuario) != null) {
			return true;
		}else {
			return false;
		}
	}



	@Override
	public boolean deleteUser(Usuario usuario) {
		try {
			deleteUserById(usuario.getId_usuario());
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}



	@Override
	public boolean deleteUserById(Long id) {
		try {
			usuarioDAO.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
