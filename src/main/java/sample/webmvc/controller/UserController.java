package sample.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import sample.webmvc.entity.User;
import sample.webmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	 UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	@GetMapping("/login")
	public String login() {
		System.out.println("UserController.login()");
		return "login";

	}
	
	
	
	@GetMapping("/path/{id}")
	public String pathVariablle(@PathVariable(name = "id") int id) {
		System.out.println("UserController.pathVariablle : "+id);
		return "welcome";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		System.out.println("UserController.login()");
		return "signup";

	}
	
	
	@PostMapping("/sign-up")
	public String saveUser(@RequestParam(name = "name") String name,@RequestParam(name = "gender") String gender,@RequestParam(name = "address") String address,Model model) {
		
		System.out.println("UserController.userLogin : "+name);
		System.out.println("UserController.userLogin : "+gender);
		
		User user = new User(name, gender, address) ;
		
		userService.saveUser(user);
		
		model.addAttribute("user", user);
		
		return "success";

	}
	
	
	@PostMapping("/login")
	public String userLogin(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password,Model model) {
		
		System.out.println("UserController.userLogin : "+username);
		System.out.println("UserController.userLogin : "+password);
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		
		return "profile";

	}
	
	
	
}