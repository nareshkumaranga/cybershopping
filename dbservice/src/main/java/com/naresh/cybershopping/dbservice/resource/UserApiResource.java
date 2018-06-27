package com.naresh.cybershopping.dbservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.cybershopping.dbservice.document.Users;
import com.naresh.cybershopping.dbservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserApiResource {
	
	private UserRepository  userRepository;
	
	public UserApiResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/getAll")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PutMapping("/add")
	public void insert(@RequestBody Users user) {
		userRepository.insert(user);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Users user) {
		userRepository.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		userRepository.deleteById(Integer.parseInt(id)); 
	}
	
	@GetMapping("/getById/{id}")
	public Users findById(@PathVariable("id") String id) {
		return userRepository.findById(Integer.parseInt(id));
	}

}
