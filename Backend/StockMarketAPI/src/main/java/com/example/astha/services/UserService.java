package com.example.astha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.astha.entities.Users;
import com.example.astha.repositories.UsersRepository;

@Service
public class UserService {

	
	@Autowired
	private UsersRepository userRepository;
	
	
	public boolean checkUser(Users user) {
		
		String username = user.getName();
		String password = user.getPassword();
		
		Users userTemp = userRepository.findByName(username);
		String usernameDB = userTemp.getName();
		String passwordDB = userTemp.getPassword();
		boolean confirmed = userTemp.getConfirmed();
		if(username.equals(usernameDB) && password.equals(passwordDB) && confirmed==true)
		{
			return true;
		}
		return false;
		
	}

}
