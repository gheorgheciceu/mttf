package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.factory.ExportFactory;
import com.ps.factory.Exporter;
import com.ps.service.OperationService;

@Controller
public class ExportController {

	@Autowired
	private ExportFactory exporterFcatory;

	@Autowired
	private OperationService operationService;

	@RequestMapping("/export-xml")
	public String getExportXml(Model model) {
		Exporter e = exporterFcatory.createExport("XML");
		e.export(operationService.findAll());
		System.out.println("XML EXPORT");
		return "index";
	}

	@RequestMapping("/export-json")
	public String getExportJSON(Model model) {
		Exporter e = exporterFcatory.createExport("JSON");
		e.export(operationService.findAll());
		System.out.println("JSON EXPORT");
		return "index";
	}
	
	@RequestMapping("/import-xml")
	public String getImportXML(Model model) {
		Exporter e = exporterFcatory.createExport("XML");
		e.importOps("");
		System.out.println("XML IMPORT");
		return "index";
	}
}
