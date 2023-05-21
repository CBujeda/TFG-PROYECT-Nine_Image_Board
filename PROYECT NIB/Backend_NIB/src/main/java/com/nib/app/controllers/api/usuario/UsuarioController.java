package com.nib.app.controllers.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.nib.app.utils.PasswordEncryptor;

@RestController
@RequestMapping("/api/users")	
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	/*
	 * Pre:
	 * Post: Metodo el cual devuelve la informacion de un usuario
	 * 		 siempre y cuando sea este mismo usuario
	 */
	@PostMapping("/get")
	public Usuario getUser(@RequestBody PO token) {
		Usuario tmp = usuarioService.findUsernameByToken(token.getToken());
		tmp.setPassword(null);
		tmp.setToken(null);
	
		return tmp;
	}
	
	/*
	 * Pre:
	 * Post: Metodo el cual actualiza los datos de un usuario
	 * Nota: Se debe mejorar el sistema de almacenamiento de
	 *       contraseña en fututas veriones.
	 */
	@PostMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody Usuario usuario) {
		boolean correct = false;
		try {
			String nombre = usuario.getNombre();
			String apellido = usuario.getApellido();
			String newPassword = usuario.getPassword();
			//System.out.println(newPassword);
			String image = usuario.getImgProfile();
			String token = usuario.getToken();
			Usuario lu = usuarioService.findUsernameByToken(token);
			
			if(lu != null) {
				//System.out.println("Ha entrado :3");
				if(newPassword != null && !newPassword.equalsIgnoreCase(" ")) {
					PasswordEncryptor encryptor = new PasswordEncryptor();
					lu.setPassword(encryptor.encrypt(newPassword));
					//System.out.println("Ha entrado :3");
				}
				lu.setImgProfile(image);
				lu.setApellido(apellido);
				lu.setNombre(nombre);
				correct = usuarioService.updateUser(lu);
			}
			return new ResponseEntity<>(formatJson(correct), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(formatJson(correct), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public String formatJson(boolean value) {return formatJson(value+"");}
	public String formatJson(String value) {
		return "{\"value\":\""+value+"\"}";
	}
	/*

	// Deprecated
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
		//System.out.println("HOALAAA");
		//System.out.println(usuario);
		if(usuario != null) {

			System.out.println(usuario.getNombre());
			Rol r = rolService.getDefaultRol();
			usuario.getRoleslist().add(r);
			tmp = usuarioService.saveUsuario(usuario);
		}
		return tmp;
	}*/
	
}
