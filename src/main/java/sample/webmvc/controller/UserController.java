package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


//
//	@RequestMapping("/")
//	public String greet() {
//		System.out.println("UserController.greet()");
//		return "welcome";
//		
//	}
	
//    @RequestMapping("/")
//    public String log(@RequestParam(name="user")String name,Model model)
//    {
//    	
//    	System.out.println("UserController.welcome: "+name);
//    	model.addAttribute("name",name);
//    	return "welcome";	
//    }
    
    @GetMapping("/login")
    public String login() {
    	System.out.println("UserController.login");
    	return "login";
    }
    
    
    @PostMapping("/login")
    public String UserLogin(@RequestParam(name="username")String username,@RequestParam(name="password")String Pass,Model model)
    {
    	System.out.println("userController.UserLogin");
    	model.addAttribute("Pass", Pass);
    	model.addAttribute("username",username);
    	
    	return "profile";
    }
    
    @GetMapping("/path/{id}")
    public String pathVariable(@PathVariable(name="id")int id)
    {
    	
    	System.out.println("usercontroller.pathvariable  "+id);
    	
    	return "Netflix";
    }
    
    
}
