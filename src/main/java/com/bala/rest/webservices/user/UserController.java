package com.bala.rest.webservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.rest.webservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable int id) {
		User user = service.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" +id+ " not found");
		}
		return user;
	}

	@PostMapping(path = "/users")
	public User saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	@DeleteMapping(path = "/users/{id}")
	public User deleteUserById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getAllPostsByUserID(@PathVariable int id) {
		return service.findAllPostsByUserId(id);
	}
}
