package com.nib.app.controllers.api.provPublic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.Tag;
import com.nib.app.model.service.TagService;

@RestController
@RequestMapping("/api/public/tags")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class PublicTags {

	@Autowired
	private TagService tagserv;
	
	@GetMapping("/random10")
	public ResponseEntity<List<Tag>> getUser() {
		try {
			List<Tag> a = tagserv.getRandomTags(10);
			System.out.println("Aqui ha entrado");
			
			return new ResponseEntity<>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<Tag>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tagsLimited")
	public ResponseEntity<Page<Tag>> getPosts( 
												@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int size,
												@RequestParam(defaultValue = "name") String order,
												@RequestParam(defaultValue = "false") boolean asc) {
		Page<Tag> posts = null;
		try {
			System.out.println(asc);
			if(asc) {
				posts = tagserv.getPaginasTags(
						PageRequest.of(page, size, Sort.by(order)));
			}else {
				posts = tagserv.getPaginasTags(
						PageRequest.of(page, size, Sort.by(order).descending()));
			}		
			posts.getTotalPages();
			return new ResponseEntity<>(posts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(posts, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
