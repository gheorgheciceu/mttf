package com.ps.factory;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.entity.Operation;

@Service
public interface Exporter {

	public void export(List<Operation> operations);
	
	public List<Operation> importOps(String path);

}
