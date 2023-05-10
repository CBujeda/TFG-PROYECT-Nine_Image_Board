package com.nib.app.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nib.app.model.entity.Post;
import com.nib.app.objects.BinaryFile;
import com.nib.app.objects.Image;

public interface PostService {

	public long getPostCount();
	
	public Page<Post> getPaginasPosts(Pageable pageable);
	
	public boolean savePost(Image image);
	
	public Post savePostDatBBDD(Post post);
	
	public BinaryFile getImageById_Post(Long id);
	
	public Page<Post> getPaginasToPostsByTag(Pageable pageable, String tag);
}
