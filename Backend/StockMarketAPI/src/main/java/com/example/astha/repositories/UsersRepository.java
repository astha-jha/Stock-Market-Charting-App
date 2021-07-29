package com.example.astha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.astha.entities.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{

	Users findByName(String username);
     

}
