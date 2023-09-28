package com.rest.eh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String saveUserData(@Valid User user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		if(userRepository.save(userEntity) != null) {
			return "Data inserted in Database successfully...";
		}
		else {
			return "Data insertion fail into Database";
		}
	}

	public User getUser(Integer id) throws UserNotFoundException {
		
		UserEntity userEntity = userRepository.findById(id).orElse(null);
		if(userEntity != null) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			return user;
		}
		else {
			throw new UserNotFoundException("The user iddata is not present");
		}
	}
	
	public List<User> getUsers(){
		List<UserEntity> entityUsers = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		for(UserEntity userEntity : entityUsers) {
			User u = new User();
			BeanUtils.copyProperties(userEntity, u);
			users.add(u);
		}
		return users;
	}
	
	public List<User> getUserByAge(Integer min,Integer max) throws UserAgeNotFoundException{
		List<UserEntity> entityUsers = userRepository.getUserByAge(min, max);
		if(entityUsers.isEmpty()) {
			throw new UserAgeNotFoundException("The user Age between data is not present");
		}
		else {
			List<User> users = new ArrayList<User>();
			for(UserEntity userEntity : entityUsers) {
				User u = new User();
				BeanUtils.copyProperties(userEntity, u);
				users.add(u);
			}
			return users;
		}
		
	}
}