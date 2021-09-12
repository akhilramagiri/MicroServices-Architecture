package com.akhil.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhil.UserService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

	User findByUserId(Long userId);

	

}
