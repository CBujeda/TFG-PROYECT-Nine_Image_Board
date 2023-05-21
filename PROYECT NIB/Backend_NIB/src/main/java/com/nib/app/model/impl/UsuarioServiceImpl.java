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

/*
 * Implementacion del servicio de usuario
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	/*
	 * Datos de configuracion
	 */
	private final String TOKEN_INIT = "NIB_TK_";
	private final int TOKEN_MAX = 100;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/*
	 * Metodo para registrar un usuario en la BBDD
	 */
	@Override
	public boolean saveUsuario(Usuario usuario){
		Usuario localUser = findByUsername(usuario.getUsername());
		if(localUser != null) {
			localUser.setPassword(null);
			localUser.setToken(null);
			System.err.println("[ERROR] [si002] - El usuario a insertar ya existe");
			return false;
		}else{
			TokenGen t = new TokenGen();
			PasswordEncryptor encryptor = new PasswordEncryptor();
			//System.out.println(usuario.toString());
			usuario.setToken(this.TOKEN_INIT+usuario.getUsername()+"_"+t.generate(TOKEN_MAX));
			try {
				createBinaryData(usuario.getUsername());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			usuario.setPassword(encryptor.encrypt(usuario.getPassword()));
			usuario.setVerify(true);	// A Modificar en versiones posteriores
			//System.out.println(usuario.toString());
			try {
				usuarioDAO.save(usuario);
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al añadir un usuario \n" + e.toString());
			}
		}
		return true;
	}

	/*
	 * Metodo para crear la base de datos y sus tablas por usuario
	 */
	private void createBinaryData(String id) throws SQLException {
		SLUtils u = new SLUtils();
		u.getConnection(id);
		u.createTables();
	}
	
	/*
	 * Pre:
	 * Post: Metodo para buscar un usuario por su
	 * nombre de usuario.
	 */
	@Override
	public Usuario findByUsername(String usuario) {
		return usuarioDAO.findByUsername(usuario);
	}

	/*
	 * Pre:
	 * Post: Metodo para buscar un usuario por su nombreç
	 * 		 de usuario pero con un obrjeto de tipo usuario
	 */
	@Override
	public Usuario findByUsername(Usuario usuario) {
		return findByUsername(usuario.getUsername());
	}

	/*
	 * Pre:
	 * Post: Metodo con el cualverificamos si existe un usuario
	 * 		 filtrado por su nombre de usuario.
	 */
	@Override
	public boolean isExistsUsernameByUsername(Usuario usuario) {
		if(findByUsername(usuario) != null) {
			return true;
		}else {
			return false;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual eliminamos un usuario de la bbdd
	 */
	@Override
	public boolean deleteUser(Usuario usuario) {
		try {
			deleteUserById(usuario.getId_usuario());
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual eliminamos un usuario
	 * 		 por su id de usuario
	 */
	@Override
	public boolean deleteUserById(Long id) {
		try {
			usuarioDAO.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}


	/*
	 * Pre:
	 * Post: Metodo con el cual logueamos un usuario
	 */
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

	/*
	 * Pre:
	 * Post: Metodo con el cual verificamos un token del usuario
	 */
	@Override
	public boolean verifyToken(String token) {
		Optional<Usuario> us = usuarioDAO.findByToken(token);
		if(!us.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual buscamos un usuario por su token
	 */
	@Override
	public Usuario findUsernameByToken(String token) {
		Optional<Usuario> us = usuarioDAO.findByToken(token);
		if(!us.isEmpty()) {
			return us.get();
		}else {
			return null;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual actualizamos a un usuario
	 */
	@Override
	public boolean updateUser(Usuario usuario) {
		Usuario localUser = findByUsername(usuario.getUsername());
		if(localUser != null) {
			try {
				usuarioDAO.save(usuario);
				return true;	
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al añadir un usuario \n" + e.toString());
				return false;	
			}
		}else{
			return false;		
		}
	}
}
