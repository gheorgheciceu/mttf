package com.ps.factory;

import org.springframework.stereotype.Service;

@Service
public class ExportFactory {

	public Exporter createExport(String export) {

		if (export.equals("JSON")) {
			return new JsonExporter();
		}

		else if (export.equals("XML")) {
			return new XmlExporter();
		}

		else
			return null;

	}
}
