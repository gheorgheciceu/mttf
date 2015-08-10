package com.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Operation;
import com.ps.entity.User;
import com.ps.repository.OperationRepository;
import com.ps.repository.UserRepository;

@Service
public class OperationService {

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Operation> findAll() {
		return operationRepository.findAll();
	}

	public void saveAll(List<Operation> importOps) {
		for(Operation o : importOps){
			User u = o.getUser();
			u=userRepository.findOne(u.getId());
			o.setUser(u);
			operationRepository.save(o);
		}
		
	}

}
