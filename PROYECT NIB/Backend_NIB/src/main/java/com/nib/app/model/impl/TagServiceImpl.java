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

/*
 * Implementacion de servicio de tags
 */

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDAO tagdao;
 	
	/*
	 * Pre:
	 * Post: Metodo con el cual obtenemos tags aleatorias
	 */
	@Override
	public List<Tag> getRandomTags(int limit) {
		return tagdao.getRandomerTag(limit);
	}
	
	/*
	 * Pre:
	 * Post: Metodo con el cual obtenemos un page de tags
	 */
	@Override
	public Page<Tag> getPaginasTags(Pageable pageable) {
		return tagdao.findAll(pageable);
		
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual buscamos una tag por su nombre
	 */
	@Override
	public Tag findByName(String name) {
		Optional<Tag> tag = tagdao.findByName(name);
		if(!tag.isEmpty()) {
			return tag.get();
		}else {
			return null;
		}
		
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual almacenamos una tag
	 */
	@Override
	public Tag saveTag(Tag tag) {
		try {
			return tagdao.save(tag);
		} catch (Exception e) {
			System.err.println("[ERROR] [si001] - Error al guardar un tag \n");
			return null;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo con el cual obenemos las tags de un post
	 */
	@Override
	public List<Tag> getTagsByIdPost(Long id) {
		List<Tag> tags = tagdao.getTagsByPostId(id);
		return tags;
	}

}
