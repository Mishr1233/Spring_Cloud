package com.cg.mvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mvcboot.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
//DSL domain specific language
	List<Alien> findByAnameOrderByAidDesc(String aname);
	

}
