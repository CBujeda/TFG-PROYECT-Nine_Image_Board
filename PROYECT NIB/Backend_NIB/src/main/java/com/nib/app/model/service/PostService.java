package com.nib.app.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nib.app.model.entity.Post;

public interface PostService {

	public long getPostCount();
	
	public Page<Post> getPaginasPosts(Pageable pageable);
}
