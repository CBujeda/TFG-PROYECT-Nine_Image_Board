package com.nib.app.model.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;

@Repository
public interface RolDAO extends JpaRepository<Rol, Long> {

	public Rol findByNombre(String nombre);
}
