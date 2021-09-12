package com.akhil.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.UserService.VO.ResponseTemplateVO;
import com.akhil.UserService.entity.User;
import com.akhil.UserService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService; 
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside save user of UaserController");
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) 
	{
		log.info("Inside getUserWithDepartment UaserController");
    return userService.getUserWithDepartment(userId);
	}

}
