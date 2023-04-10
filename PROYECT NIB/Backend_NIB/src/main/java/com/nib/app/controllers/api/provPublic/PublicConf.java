package com.nib.app.controllers.api.provPublic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.Config;
import com.nib.app.model.service.ConfService;

@RestController
@RequestMapping("/api/public/conf")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PublicConf {
	
	@Autowired
	private ConfService confserv;
	
	@GetMapping("/name")
	public ResponseEntity<String> getName() {
		try {
			
			String name = "Nine Image Board";
			Config conf = confserv.getConfbyConf("app_name");
			if(conf != null) {
				name = conf.getValue();
			}
			return new ResponseEntity<>("\""+name+"\"", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
