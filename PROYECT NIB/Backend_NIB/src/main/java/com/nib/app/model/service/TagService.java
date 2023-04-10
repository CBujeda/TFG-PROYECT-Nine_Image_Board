package com.nib.app.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nib.app.model.entity.Tag;

public interface TagService {

	public List<Tag> getRandomTags(int limit);

	public Page<Tag> getPaginasTags(Pageable pageable);
}
