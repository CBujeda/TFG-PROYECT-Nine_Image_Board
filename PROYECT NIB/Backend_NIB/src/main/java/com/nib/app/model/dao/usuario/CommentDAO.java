package com.nib.app.model.dao.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.Comment;
import com.nib.app.model.entity.Post;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {

	@Query(nativeQuery=true, value=""
			+ "SELECT c.* FROM  "
			+ "comments c "
			+ "where c.id_post = ?1 ")
	public List<Comment> findCommentsByIdPost(Long id_post);
}
