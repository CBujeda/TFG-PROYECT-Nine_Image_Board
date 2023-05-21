package com.nib.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nib.app.model.entity.Config;
import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.ConfService;
import com.nib.app.model.service.RolService;
import com.nib.app.model.service.UsuarioService;
import com.nib.app.utils.NIBShell;

import jakarta.transaction.Transactional;

/*
 * NIB BACKEND APPLICATION
 * --------------------------------
 * Created by Clara Bujeda Muñoz 
 * 		Date: 2023
 * 		email: clarabujedamunoz@gmail.com 
 */
@SpringBootApplication
public class BackendNibApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private ConfService confserv;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendNibApplication.class, args);
	}

	/*
	 * Pre:
	 * Post: Metodo de preconfiguración
	 */
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		printInfo("Verifying configuration...");
		if(confserv.getCont() == 0) {
			printInfo("Updating configuration");
			confserv.addConf(new Config("app_name","Nine Image Board"));
			confserv.addConf(new Config("app_short_name","NIB"));
		}
		String username = "ADMIN";
		Usuario usuario = new Usuario();
		usuario.setUsername("ADMIN");
		printInfo("Verifying Users");
		if(!usuarioService.isExistsUsernameByUsername(usuario)) {
			printInfo("Creating user ADMIN...");
			Rol r = new Rol();
			r.setId_rol(1L);
			r.setNombre("ADMIN"); 		
			addRol(r);
			Rol r2 = new Rol();
			r2.setId_rol(2L);
			r2.setNombre("USER"); 
			addRol(r2);
			usuario.setNombre("Admin");
			usuario.setApellido("Admin");
			usuario.setPassword("ADMIN");
			usuario.setEmail("admin@admin.com");
			usuario.setImgProfile("image.png");
			usuario.getRoleslist().add(rolService.findByName(r));
			usuarioService.saveUsuario(usuario);
		}
	}
	
	/*
	 * Pre:
	 * Post: Metodo con el cual almacenamos un nuevo rol en la BBDD
	 */
	private void addRol(Rol rol) {
		if(!rolService.isExistsRolByName(rol)) {
			rolService.saveRol(rol);
		}
	}
	
	/*
	 * Pre:
	 * Post: Metodo con el cual imprimimos por consola.
	 */
	public void printInfo(String str) {
		new NIBShell().printInfo(str);
		/*
	    String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	    String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	    String RESET = "\033[0m"; // RESET
	    String date = java.time.Clock.systemUTC().instant().toString();
		System.out.println(date.substring(0, date.length()-1)+"  "+YELLOW_BOLD+"[NIB] "+PURPLE_BOLD+"    --- "+RESET + str);
		*/
	}

}
