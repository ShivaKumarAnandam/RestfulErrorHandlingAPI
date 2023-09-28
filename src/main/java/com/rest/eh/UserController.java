package com.rest.eh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveuser")
	public String saveData(@RequestBody @Valid User user) {
		return userService.saveUserData(user);
	}
	
	@GetMapping("/fetch/{id}")
	public User getData(@PathVariable Integer id) throws UserNotFoundException {
		return userService.getUser(id);
	}
	
	@GetMapping("/fetchAll")
	public List<User> getData(){
		return userService.getUsers();
	}
	
	@GetMapping("/fetch/{min}/{max}")
	public List<User> getDataByAge(@PathVariable Integer min, @PathVariable Integer max) throws UserAgeNotFoundException{
		return userService.getUserByAge(min, max);
	}
	
}
