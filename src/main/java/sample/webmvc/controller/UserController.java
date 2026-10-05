package sample.webmvc.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;

    @Controller
	@ResponseBody
	public class UserController {
		
		static Map<Integer, User> users = new HashMap<>();
		static {
			
			users.put(1, new User(1,"Vikas","Male","Noida"));
			users.put(2, new User(2,"Kunal","Male","GZB"));
			users.put(3, new User(3,"Nakul","Male","Noida"));
			users.put(4, new User(4,"Abhi","Male","Gurgaon"));
			users.put(5, new User(5,"Arjun","Male","Noida"));
		}
		
		@GetMapping
		public User greet() {
			System.out.println("UserController.greet : ");
			return new User(99,"Dummy","No","Planet Not Found");
		}
			
			@GetMapping("/getuser/{id}")
			public User getuserbyid(@PathVariable(name = "id") int id) {
				System.out.println("getuserbyid"+id);
				return users.get(id);
			}
			
			@PostMapping
			public void adduser(@RequestBody User user) {
				
				System.out.println("adduser()");
				System.out.println(user);
				users.put(user.getId(),user);
			}
			
			@PutMapping
			public void updateUser(@RequestBody User user) {

			    System.out.println("updateUser()");
			    System.out.println(user);

			    users.put(user.getId(), user);
			}
			
			@PatchMapping
			public void patchUser(@RequestBody User user) {

			    System.out.println("patchUser()");
			    System.out.println(user);

			    User existingUser = users.get(user.getId());

			    if (existingUser != null) {

			        if (user.getName() != null) {
			            existingUser.setName(user.getName());
			        }

			        if (user.getGender() != null) {
			            existingUser.setGender(user.getGender());
			        }

			        if (user.getAddress() != null) {
			            existingUser.setAddress(user.getAddress());
			        }

			        users.put(user.getId(), existingUser);
			    }
			}
			
			@DeleteMapping("/{id}")
			public String deleteuser(@PathVariable(name="id")int id)
			{
				System.out.println("deleteuser()"+id);
				users.remove(id);
				
				return "userdeleted succesfully";
			}
			
			
			
			
			}
			
			

		
		
	
	
