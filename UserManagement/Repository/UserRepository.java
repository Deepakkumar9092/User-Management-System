package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserManagement.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
