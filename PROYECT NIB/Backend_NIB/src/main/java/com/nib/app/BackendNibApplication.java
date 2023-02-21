package com.nib.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.RolService;
import com.nib.app.model.service.UsuarioService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class BackendNibApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendNibApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Rol r = new Rol();
		r.setId_rol(1L);
		r.setNombre("ADMIN"); 		
		addRol(r);
		
		Rol r2 = new Rol();
		r2.setId_rol(2L);
		r2.setNombre("USER"); 
		addRol(r2);
		
		Usuario usuario = new Usuario();
		usuario.setUsername("ADMIN");
		if(!usuarioService.isExistsUsernameByUsername(usuario)) {
			usuario.setNombre("Admin");
			usuario.setApellido("Admin");
			usuario.setPassword("root");
			usuario.setEmail("admin@admin.com");
			usuario.setImgProfile("image.png");
			usuario.getRoleslist().add(rolService.findByName(r));
			usuarioService.saveUsuario(usuario);
		}
	}
	
	
	private void addRol(Rol rol) {
		if(!rolService.isExistsRolByName(rol)) {
			rolService.saveRol(rol);
		}
	}

}
