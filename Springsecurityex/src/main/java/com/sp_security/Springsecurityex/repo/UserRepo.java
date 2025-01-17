package com.sp_security.Springsecurityex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp_security.Springsecurityex.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

	Users findByUsername(String username);

	
}
