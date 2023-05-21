package com.nib.app.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nib.app.model.entity.Tag;
/*
 * Servicio de tags
 */
public interface TagService {

	public List<Tag> getRandomTags(int limit);

	public Page<Tag> getPaginasTags(Pageable pageable);
	
	public List<Tag> getTagsByIdPost(Long id);
	
	public Tag findByName(String name);
	
	public Tag saveTag(Tag tag);
}
