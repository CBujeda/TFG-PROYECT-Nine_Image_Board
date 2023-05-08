package com.nib.app.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.TagDAO;
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

	@Override
	public Tag findByName(String name) {
		Optional<Tag> tag = tagdao.findByName(name);
		if(!tag.isEmpty()) {
			return tag.get();
		}else {
			return null;
		}
		
	}

	@Override
	public Tag saveTag(Tag tag) {
		try {
			return tagdao.save(tag);
		} catch (Exception e) {
			System.err.println("[ERROR] [si001] - Error al guardar un tag \n");
			return null;
		}
	}

}
