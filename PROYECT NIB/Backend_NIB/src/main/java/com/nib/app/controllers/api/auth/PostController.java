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

import com.nib.app.model.service.PostService;
import com.nib.app.objects.Image;

@RestController
@RequestMapping("/api/private/post")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PostController {
	
	@Autowired
	private PostService postService;

    @PostMapping("/postnew")
    public ResponseEntity<?> create(
            @RequestBody Image file
    ){
    	try {
    		boolean result = postService.savePost(file);
    		return new ResponseEntity<Boolean>(result,HttpStatus.CREATED);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
    
    
    
}
