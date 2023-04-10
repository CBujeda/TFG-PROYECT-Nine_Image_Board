package com.nib.app.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.TagDAO;
import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.Tag;
import com.nib.app.model.service.TagService;
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDAO tagdao;
 	
	@Override
	public List<Tag> getRandomTags(int limit) {
		return tagdao.getRandomerTag(limit);
	}
	
	@Override
	public Page<Tag> getPaginasTags(Pageable pageable) {
		return tagdao.findAll(pageable);
		
	}

}
