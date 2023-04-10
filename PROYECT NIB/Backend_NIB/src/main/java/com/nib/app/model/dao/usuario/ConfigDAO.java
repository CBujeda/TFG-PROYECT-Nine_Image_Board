package com.nib.app.model.dao.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nib.app.model.entity.Config;

@Repository
public interface ConfigDAO extends JpaRepository<Config, Long>{
	
	
	@Query(nativeQuery=true, value = "select * from config c where c.conf = ?1 ")
	public List<Config> findbyConfig(String conf);

}