package com.nib.app.model.dao.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.Tag;

@Repository
public interface TagDAO extends JpaRepository<Tag, Long>{

	@Query(nativeQuery=true, value=""
			+ "SELECT * FROM tag  "
			+ "ORDER BY RAND ( )  "
			+ "LIMIT ?1 ")
	public List<Tag> getRandomerTag(int limit);
	
	public Optional<Tag> findByName(String name);
}
