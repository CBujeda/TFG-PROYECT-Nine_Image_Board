package com.nib.app.model.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nib.app.model.entity.user.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
