package com.akhil.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhil.UserService.Repository.UserRepository;
import com.akhil.UserService.VO.Department;
import com.akhil.UserService.VO.ResponseTemplateVO;
import com.akhil.UserService.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;

	 @Autowired
	 private RestTemplate restTemplate;
	 
	public User saveUser(User user) {
		log.info("inside saveUser of UserService");
        return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment of UserService");
	
		ResponseTemplateVO vo = new ResponseTemplateVO();
			 User user = userRepository.findByUserId(userId);
			 Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
			 
			 vo.setUser(user);
			 vo.setDepartment(department);
			 return vo;
	}
}
