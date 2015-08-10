package com.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.OperationType;
import com.ps.entity.User;
import com.ps.repository.OperationTypeRepository;
import com.ps.repository.RoleRepository;
import com.ps.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private OperationTypeRepository operationTypeRepository;
	
	public void save(User user) {
	
		user.setRole(roleRepository.getRole("ROLE_USER"));
		userRepository.save(user);
		
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}

	public void delete(int id) {
		userRepository.delete(id);
		
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public void  setMaximumTransferable(int max){
		OperationType opt = operationTypeRepository.findOne("transfer");
		opt.setMaximum(max);
		operationTypeRepository.save(opt);
	}
}
