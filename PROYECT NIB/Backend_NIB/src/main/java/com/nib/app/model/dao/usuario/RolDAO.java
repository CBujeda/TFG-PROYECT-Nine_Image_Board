package com.nib.app.model.dao.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;

@Repository
public interface RolDAO extends JpaRepository<Rol, Long> {

	public Rol findByNombre(String nombre);

	@Query(nativeQuery=true, value=
			"SELECT r.* FROM "
			+ "usuario u, usuario_nn_rol ur, roles r "
			+ "where u.id_usuario = ur.id_usuario "
			+ "and ur.id_rol = r.id_rol "
			+ "and u.token = ?1 ")
	public List<Rol> findRolesByUserToken(String token);
}
