package com.nib.app.model.impl;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.UsuarioDAO;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.UsuarioService;
import com.nib.app.utils.PasswordEncryptor;
import com.nib.app.utils.TokenGen;
import com.nib.app.utils.sqLite.SLUtils;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final String TOKEN_INIT = "NIB_TK_";
	private final int TOKEN_MAX = 100;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario saveUsuario(Usuario usuario){
		Usuario localUser = findByUsername(usuario.getUsername());
		if(localUser != null) {
			localUser.setPassword(null);
			localUser.setToken(null);
			System.err.println("[ERROR] [si002] - El usuario a insertar ya existe");
		}else{
			TokenGen t = new TokenGen();
			PasswordEncryptor encryptor = new PasswordEncryptor();
			System.out.println(usuario.toString());
			usuario.setToken(this.TOKEN_INIT+usuario.getUsername()+"_"+t.generate(TOKEN_MAX));
			try {
				createBinaryData(usuario.getUsername());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			SLUtils u = new SLUtils();
			Connection c = u.getConnection(usuario.getToken());
			try {
				u.createTables(c);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}*/
			usuario.setPassword(encryptor.encrypt(usuario.getPassword()));
			usuario.setVerify(true);	// A Modificar en versiones posteriores
			System.out.println(usuario.toString());
			try {
				usuarioDAO.save(usuario);
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al añadir un usuario \n" + e.toString());
			}
		}
		return localUser;
	}

	private void createBinaryData(String id) throws SQLException {
		SLUtils u = new SLUtils();
		u.getConnection(id);
		u.createTables();
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



	@Override
	public String login(Usuario usuario) {
		Usuario localUser = findByUsername(usuario.getUsername());
		String token = "ERROR";
		if(localUser != null) {
			PasswordEncryptor encrypt = new PasswordEncryptor();
			if(encrypt.checkPassword(usuario.getPassword(), localUser.getPassword())) {
				token = localUser.getToken();
				return token;
			}
			System.err.println("[AVISO] [av032] - Usuario credenciales erroneas \n");
		}else {
			System.err.println("[AVISO] [av032] - Usuario Inexistente \n");
		}
		return token;
	}

	@Override
	public boolean verifyToken(String token) {
		Optional<Usuario> us = usuarioDAO.findByToken(token);
		if(!us.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Usuario findUsernameByToken(String token) {
		Optional<Usuario> us = usuarioDAO.findByToken(token);
		if(!us.isEmpty()) {
			return us.get();
		}else {
			return null;
		}
	}
}
