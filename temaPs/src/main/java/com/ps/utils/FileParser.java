package com.ps.utils;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileParser {

	public static byte[] readBytesFromFile(MultipartFile filePath)
			throws IOException {

		InputStream inputStream = filePath.getInputStream();

		byte[] fileBytes = filePath.getBytes();
		inputStream.read(fileBytes);
		inputStream.close();

		return fileBytes;
	}

}
