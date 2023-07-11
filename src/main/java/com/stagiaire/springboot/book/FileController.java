package com.stagiaire.springboot.book;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/upload")
public class FileController {
	@Autowired
	private StorageService storageService;
	

	@PostMapping
	public String uploadPdf(@RequestParam("file")MultipartFile file)throws IOException
	{
		return storageService.uploadFile(file);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> dowloadPdf(@PathVariable Long id ){
		byte[] pdfData=storageService.downloadFile(id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
				.body(pdfData);
		
	

	}

}
