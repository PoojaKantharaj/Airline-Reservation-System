package com.Reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Reservation.entities.User;
import com.Reservation.repository.UserRepository;

@Controller

public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping("/showCreatePage")
	public String showCreatePage() {
		return "login/showReg";
	}
	
 
	//http://localhost:8080/showReg
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLoginCredential(@RequestParam("emailId") String emailId,
			@RequestParam("password") String password, ModelMap modelMap) {
		User user = userRepo.findByEmail(emailId);
		if(user!=null) {
		if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
		return "findFlights";
	} else {
		modelMap.addAttribute("error", "invalid username / password");
		return "login/login";
	}
		} else {
			modelMap.addAttribute("error", "invalid username / password"); 
			return "login/login";
		}	
	}
	
}
