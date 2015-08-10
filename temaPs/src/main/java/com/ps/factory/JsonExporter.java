package com.ps.factory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.ps.entity.Operation;



public class JsonExporter implements Exporter {

	@Override
	public void export(List<Operation> operations) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			mapper.writeValue(new File("E:\\Operations.json"), operations);
			System.out.println(mapper.writeValueAsString(operations));
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}

	@Override
	public List<Operation> importOps(String path) {
		
		return null;
	}

	
}
