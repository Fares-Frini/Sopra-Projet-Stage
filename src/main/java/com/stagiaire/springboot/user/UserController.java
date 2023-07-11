package com.stagiaire.springboot.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
	
	private final UserService userService;
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/getuser")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	@GetMapping("/getuser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
	

	@PostMapping
	public User saveUsers(@RequestBody User u) {
		return userService.saveUsers(u);
	}
	@DeleteMapping("/{id}")
	  public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	@PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

}
