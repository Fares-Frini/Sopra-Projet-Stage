package com.stagiaire.springboot.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<BookFile,Long> {
	
	
	 Optional<BookFile> findById(Long id);

}
