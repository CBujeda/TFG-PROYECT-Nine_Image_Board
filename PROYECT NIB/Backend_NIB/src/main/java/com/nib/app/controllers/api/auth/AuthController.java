package com.nib.app.controllers.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.impl.UsuarioServiceImpl;
import com.nib.app.model.service.RolService;
import com.nib.app.objects.PO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class AuthController {

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private RolService rolService;
	
	@PostMapping("/register")
	public ResponseEntity<String> authRegister(@RequestBody Usuario usuario) {
		try {
			usuario.setId_usuario(null);
			usuario.setToken(null);
			usuario.setVerify(true);
			usuario.setImgProfile("image.png");	
			boolean u = usuarioServiceImpl.saveUsuario(usuario);
			if(u == false) {
				System.out.println("Hola");
				return new ResponseEntity<>(formatJson("ERROR"), HttpStatus.OK);
				
			}
			System.out.println(usuario.toString());
		
			return new ResponseEntity<>(formatJson("OK"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(formatJson("ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> authLogin(@RequestBody Usuario usuario) {
		try {
			String token = usuarioServiceImpl.login(usuario);
			return new ResponseEntity<>(formatJson(token), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(formatJson("ERR://401/UNATHORIZED"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/verifyToken")
	public ResponseEntity<String> veifyToken(@RequestBody PO token){
		try {
			System.out.println(token.getToken());
			boolean result = usuarioServiceImpl.verifyToken(token.getToken());
			return new ResponseEntity<String>(formatJson(result), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(formatJson(false), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public String formatJson(boolean value) {return formatJson(value+"");}
	public String formatJson(String value) {
		return "{\"value\":\""+value+"\"}";
	}
	
	
	@PostMapping("/verifyAdmin")
	public ResponseEntity<String> veifyAdmin(@RequestBody PO token){
		try {
			boolean result = rolService.isthisUserAdminByToken(token.getToken());
			System.out.println(result);
			return new ResponseEntity<String>(formatJson(result), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(formatJson(false), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
