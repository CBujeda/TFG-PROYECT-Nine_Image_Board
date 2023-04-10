package com.nib.app.model.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long>{

}
