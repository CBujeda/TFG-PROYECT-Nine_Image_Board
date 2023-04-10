package com.nib.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.PostDAO;
import com.nib.app.model.entity.Post;
import com.nib.app.model.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO post_dao;
	
	@Override
	public long getPostCount() {
		return post_dao.count();
	}

	@Override
	public Page<Post> getPaginasPosts(Pageable pageable) {
		return post_dao.findAll(pageable);
	}

	
}
