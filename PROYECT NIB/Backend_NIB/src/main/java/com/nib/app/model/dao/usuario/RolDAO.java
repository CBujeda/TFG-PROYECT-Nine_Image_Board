package com.nib.app.model.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;

public interface RolDAO extends JpaRepository<Rol, Long> {

	public Rol findByNombre(String nombre);
}
