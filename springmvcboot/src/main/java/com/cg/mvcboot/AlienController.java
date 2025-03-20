package com.cg.mvcboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mvcboot.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@GetMapping("aliens")
	public List<Alien> getAliens() {

		List<Alien> aliens=repo.findAll();
		return aliens;
		
	}
	
	@GetMapping("alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		Optional<Alien> alien =repo.findById(aid);
		return alien;
	}
	
	@PostMapping("alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
}
