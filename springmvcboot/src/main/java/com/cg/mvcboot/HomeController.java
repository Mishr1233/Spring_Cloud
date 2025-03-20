package com.cg.mvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mvcboot.model.Alien;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void model(ModelMap m) {
		m.addAttribute("name","Alien");
		
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("getAliens")
	public String getAliens(ModelMap m) {
		m.addAttribute("result",repo.findAll());
		return "showAliens";
		
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid,ModelMap m) {
		m.addAttribute("result",repo.getOne(aid));
		return "showAliens"; 
	}
	
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname,ModelMap m) {
		m.addAttribute("result",repo.findByAnameOrderByAidDesc(aname));
		return "showAliens"; 
	}
	
	
	@PostMapping("/addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a ) {
		
	
//		m.addAttribute("alien",a);
		repo.save(a);
		return "result";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap m) {
		
//		int i=Integer.parseInt(req.getParameter("num1"));
//		int j=Integer.parseInt(req.getParameter("num2"));
		
		
		
		int num3=i+j;
		m.addAttribute("num3",num3);
		
		return "result";
	}
	
}
