package com.lilyochs.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lilyochs.bookClub.models.LoginUser;
import com.lilyochs.bookClub.models.User;
import com.lilyochs.bookClub.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser =  userRepository.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "confirmed password must match Password!");
		}
		if(result.hasErrors()) {
			return null;
		}
		String hashd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashd);
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser =  userRepository.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password","Matches", "Invalid Password");
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
}

	
	public User findById(Long id){
		Optional<User> result = userRepository.findById(id);
			if(result.isPresent()) {
				return result.get();
			}
		return null;
		}
	}

