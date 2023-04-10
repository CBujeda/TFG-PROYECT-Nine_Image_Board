package com.nib.app.model.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.user.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
