package com.nib.app.model.dao.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.nib.app.model.entity.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long>{
	
	@Query(nativeQuery=true, value="select DISTINCT p.* "
			+ "from post p, post_nn_tag pt, tag t "
			+ "where p.id_post = pt.id_post "
			+ "and pt.id_tag = t.id_tag "
			+ "and t.name like %?1% "
			+ "ORDER BY p.id_post ")
	public List<Post> findPostsByTag(String keyword);
}
