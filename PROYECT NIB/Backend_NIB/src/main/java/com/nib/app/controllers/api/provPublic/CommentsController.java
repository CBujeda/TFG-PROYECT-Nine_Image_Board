package com.nib.app.controllers.api.provPublic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.Post;
import com.nib.app.model.service.CommentService;
import com.nib.app.objects.FComment;

@RestController
@RequestMapping("/api/public/comments")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	/*
	 * Pre:
	 * Post: Controlador para almacenar un nuevo comentario
	 */
	@PostMapping("/save")
    public ResponseEntity<?> create(
            @RequestBody FComment fcomment
    ){
    	try {
    		boolean result = commentService.saveComment(fcomment);
    		return new ResponseEntity<Boolean>(result,HttpStatus.CREATED);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
	
	/*
	 * Pre:
	 * Post: Metodo para obtener una lista de comnetarios de un post
	 */
	@PostMapping("/get")
    public ResponseEntity<?> getComments(
            @RequestBody Post p
    ){
    	try {
    		//System.out.println(p.getId_post());
    		List<FComment> comments = commentService.getCommentsByPostId(p.getId_post());
    		//System.out.println("XD"	);
    		/*
    		for (FComment comment : comments) {
    			System.out.println(comment.toString());
    		}*/
    		//boolean result = commentService.saveComment(fcomment);
    		return new ResponseEntity<List<FComment>>(comments,HttpStatus.CREATED);
    	} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
		}
    }
}
