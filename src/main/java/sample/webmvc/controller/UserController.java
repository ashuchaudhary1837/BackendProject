package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kitchen")
public class UserController {
	
	

	@RequestMapping("/")
	public String greet() {
		System.out.println("UserController.greet()");
		return "welcome";
		
	}
	
@RequestMapping("John")
public String Hello() {
	return "Netflix";
}

}
