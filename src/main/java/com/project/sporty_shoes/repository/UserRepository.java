package com.project.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sporty_shoes.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByEmailId(String emailId);
	public User findByUsername(String username);
}
