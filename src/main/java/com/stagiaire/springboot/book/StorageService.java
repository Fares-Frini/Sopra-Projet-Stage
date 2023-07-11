package com.stagiaire.springboot.book;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	 @Autowired
	    private StorageRepository repository;

	    public String uploadFile(MultipartFile file) throws IOException {

	        BookFile fileData = repository.save(BookFile.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .fileData(BookUtils.compressFile(file.getBytes())).build());
	        if (fileData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	    }

	    public byte[] downloadFile(Long id){
	        Optional<BookFile> dbFileData = repository.findById(id);
	        byte[] files=BookUtils.decompressFile(dbFileData.get().getFileData());
	        return files;
	    }

}
