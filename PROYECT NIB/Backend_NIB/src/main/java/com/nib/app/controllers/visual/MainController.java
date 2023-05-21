package com.nib.app.controllers.visual;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	/*
	 * Pre:
	 * Post: Controlador el cual simplemente devuelve
	 * 		 la habilitación de la api
	 */
	@GetMapping("/")
	public String inicio(Model model) {
		return "visual/index";
	}

}
