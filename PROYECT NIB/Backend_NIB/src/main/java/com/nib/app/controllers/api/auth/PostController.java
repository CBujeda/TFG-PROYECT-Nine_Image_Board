package com.nib.app.controllers.api.auth;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.Tag;
import com.nib.app.model.service.PostService;
import com.nib.app.model.service.TagService;
import com.nib.app.objects.Image;

@RestController
@RequestMapping("/api/private/post")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private TagService tagService;
	
	/*
	 * Pre:
	 * Post: Metodo para crear un nuevo post
	 */
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
    
    /*
     * Pre:
     * Post: Metodo para obtener la informacion de un post
     */
    @GetMapping("/getPostInfo")
    public ResponseEntity<?> getPostInfo(@RequestParam("id_post") String id){
    	try {
            if (Pattern.matches("-?\\d+", id)) {
                Long identificador = Long.parseLong(id);
                Post p = postService.getPostById(identificador);
        		return new ResponseEntity<Post>(p,HttpStatus.CREATED);
            } else {
                System.out.println("La variable no es un número.");

        		return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
            }
    			
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
    
    /*
     * Pre:
     * Post: Metodo para obtener las tags de un post
     */
    @GetMapping("/getTagsByPost")
    public ResponseEntity<?> getTagsByPost(@RequestParam("id_post") String id){
    	try {
            if (Pattern.matches("-?\\d+", id)) {
                Long identificador = Long.parseLong(id);
                List<Tag> t = tagService.getTagsByIdPost(identificador);
        		return new ResponseEntity<List<Tag>>(t,HttpStatus.CREATED);
            } else {
                System.out.println("La variable no es un número.");

        		return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
            }
    			
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
}
