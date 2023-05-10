package com.nib.app.controllers.api.provPublic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.config.NibConfig;
import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.PostService;

@RestController
@RequestMapping("/api/public/posts")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PublicPosts {

	@Autowired 
	private PostService post_serv;
	
	//"http://localhost:3000","http://localhost:8080","http://localhost:4200"
	@GetMapping("/count")
	public ResponseEntity<Long> getCount() {
		try {
			return new ResponseEntity<>(post_serv.getPostCount(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(0L, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/postsLimited")
	public ResponseEntity<Page<Post>> getPosts( 
												@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int size,
												@RequestParam(defaultValue = "date") String order,
												@RequestParam(defaultValue = "false") boolean asc) {
		Page<Post> posts = null;
		try {
			
			if(asc) {
				posts = post_serv.getPaginasPosts(
						PageRequest.of(page, size, Sort.by(order)));
			}else {
				posts = post_serv.getPaginasPosts(
						PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return new ResponseEntity<>(posts, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(posts, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/postsfiterbytag")
	public ResponseEntity<Page<Post>> getPostsByTag( 
												@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int size,
												@RequestParam(defaultValue = "date") String order,
												@RequestParam(defaultValue = "false") boolean asc,
												@RequestParam(defaultValue = "") String tag) {
		Page<Post> posts = null;
		try {
			
			if(asc) {
				posts = post_serv.getPaginasToPostsByTag(
						PageRequest.of(page, size, Sort.by(order)),tag);
			}else {
				posts = post_serv.getPaginasToPostsByTag(
						PageRequest.of(page, size, Sort.by(order).descending()),tag);
			}
			return new ResponseEntity<>(posts, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(posts, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
