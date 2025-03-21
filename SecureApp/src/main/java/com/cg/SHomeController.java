package com.cg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SHomeController {
	

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/login")

	public String loginPage() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")

	public String logoutPage() {
		return "logout.jsp";
	}
	
}
