package com.elnanda.onlinestore.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileServiceUtil {

	public String processImage(MultipartFile file) throws IOException {
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
		String fileName = date + file.getOriginalFilename();

		String folderPath = "src/main/resources/static";
		String filePath = folderPath + "/" + fileName;

		// Copies Spring's multipartfile inputStream to /sismed/temp/exames
		// (absolute path)
		Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
		return fileName;
	}

}
