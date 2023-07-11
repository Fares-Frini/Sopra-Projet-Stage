package com.stagiaire.springboot.user;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
		
		
	}
	 public User getUserById(Long id) {
	        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
	    }
	public User saveUsers(User u) {
		return userRepository.save(u);
		
	}
	
	 public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	 public User updateUser(Long id, User updatedUser) {
	        User existingUser = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));

	        // Update the necessary fields
	        existingUser.setFirstName(updatedUser.getFirstName());
	        existingUser.setLastName(updatedUser.getLastName());
	        existingUser.setBirthDate(updatedUser.getBirthDate());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setPassword(updatedUser.getPassword());
	        existingUser.setGender(updatedUser.getGender());
	        existingUser.setRole(updatedUser.getRole());

	        return userRepository.save(existingUser);
	    }

}
