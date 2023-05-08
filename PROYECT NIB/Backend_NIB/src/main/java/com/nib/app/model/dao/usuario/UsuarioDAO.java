package com.nib.app.model.dao.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.user.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
	//@Query(value = "SELECT * FROM usuario u where u.token = ?1 ;")
	//public List<Usuario> findByToken(String token);
	
	public Optional<Usuario> findByToken(String token);
}
