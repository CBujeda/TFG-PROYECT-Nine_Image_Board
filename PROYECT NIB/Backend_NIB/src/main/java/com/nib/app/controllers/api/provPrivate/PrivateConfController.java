package com.nib.app.controllers.api.provPrivate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.Config;
import com.nib.app.model.service.ConfService;
import com.nib.app.model.service.RolService;
import com.nib.app.objects.SConf;

@RestController
@RequestMapping("/api/private/conf")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PrivateConfController {
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private ConfService configService;
	
	/*
	 * Pre:
	 * Post: Metodo para cambiar la configuración del sistema
	 */
	@PostMapping("/change")
    public ResponseEntity<?> changeConf(
            @RequestBody SConf sconf
    ){
    	try {
    		String token = sconf.getToken();
    		boolean result = rolService.isthisUserAdminByToken(token);
    		if(result) {
    			Config appNameLocal = configService.getConfbyConf("app_name");
    			Config appShortNameLocal = configService.getConfbyConf("app_short_name");
    			appNameLocal.setValue(sconf.getAppname());
    			appShortNameLocal.setValue(sconf.getAppshortname());
    			configService.addConf(appNameLocal);
    			configService.addConf(appShortNameLocal);
    			return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
    		}
    		return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
    	} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
	
	
}
