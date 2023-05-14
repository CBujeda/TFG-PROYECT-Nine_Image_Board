package com.nib.app.controllers.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.user.Rol;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.RolService;
import com.nib.app.model.service.UsuarioService;
import com.nib.app.objects.PO;

@RestController
@RequestMapping("/api/users")	
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	
	@PostMapping("/get")
	public Usuario getUser(@RequestBody PO token) {
		System.out.println("Entra usuario");
		Usuario tmp = usuarioService.findUsernameByToken(token.getToken());
		tmp.setPassword(null);
		tmp.setToken(null);
	
		return tmp;
	}
	/*
	@DeleteMapping("/delete_{userID}")
	public boolean deleteUser(@PathVariable("userID") String userID) {
		long id = -1L;
		try {
			id = Long.parseLong(userID);
		} catch(Exception e) {
			
		}
		boolean tmp = false;
		if(id != -1L) {
			 tmp = usuarioService.deleteUserById(id);
		}
		return tmp;
	}
	*/
	
	// DEPRECATED
	/*
	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public Usuario saveNewUser(@RequestBody Usuario usuario){//@RequestBody Usuario usuario) {
		
		Usuario tmp = null;
		System.out.println("HOALAAA");
		System.out.println(usuario);
		if(usuario != null) {

			System.out.println(usuario.getNombre());
			Rol r = rolService.getDefaultRol();
			usuario.getRoleslist().add(r);
			tmp = usuarioService.saveUsuario(usuario);
		}
		return tmp;
	}*/
	
}
