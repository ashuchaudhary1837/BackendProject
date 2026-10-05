package sample.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/")
	public String greet() {
		System.out.println("UserController.greet : ");

		return "welcome";

	}

	@GetMapping("/login")
	public String login() {
		System.out.println("UserController.login()");
		return "login";

	}

	@GetMapping("/path/{id}")
	@ResponseBody
	public User pathVariablle(@PathVariable(name = "id") int id) {
		
		System.out.println("UserController.pathVariablle : " + id);

		return userService.getUserById(id);
	}

	@GetMapping("/sign-up")
	public String signUp() {
		System.out.println("UserController.login()");
		return "signup";

	}

	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User user, Model model) {
		System.out.println("UserController.saveUser : ");
		System.out.println(user);
		userService.saveUser(user);
		model.addAttribute("user", user);
		return "success";

	}
	
	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {

	    System.out.println("UserController.deleteUser: " + id);

	    userService.deleteuser(id);

	    return "user deleted succesfully";
	}

	
	@PutMapping("/update/{id}")
	@ResponseBody
	public String updateUser(
	        @PathVariable(name = "id") int id,
	        @RequestBody User user) {

	    System.out.println("UserController.updateUser(): " + id);

	    user.setId(id);

	    userService.updateUser(user);

	    return "User updated successfully";
	}
	

//	@PostMapping("/sign-up")
//	public String saveUser(@RequestParam(name = "name") String name,@RequestParam(name = "gender") String gender,@RequestParam(name = "address") String address,Model model) {
//		
//		System.out.println("UserController.userLogin : "+name);
//		System.out.println("UserController.userLogin : "+gender);
//		
//		User user = new User(name, gender, address) ;
//		
//		userService.saveUser(user);
//		
//		model.addAttribute("user", user);
//		
//		return "success";
//
//	}

	@PostMapping("/login")
	public String userLogin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, Model model) {

		System.out.println("UserController.userLogin : " + username);
		System.out.println("UserController.userLogin : " + password);

		model.addAttribute("username", username);
		model.addAttribute("password", password);

		return "profile";

	}

}