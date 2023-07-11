 package com.stagiaire.springboot.book;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class BookService { 
	private final BookRepository bookRepository;
	
@Autowired
    public BookService(BookRepository bookRepository) {

        this.bookRepository=bookRepository;

    }
	public List<Book> getBook()
	{
		return bookRepository.findAll();
	} 
	public Book saveBook(Book b)
	{
		return bookRepository.save(b);
	} 
	public void deleteBook(long id)
	{
		bookRepository.deleteById(id);
	}
	public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found"));



        // Update the necessary fields

        existingBook.setName(updatedBook.getName());

        existingBook.setAuthor(updatedBook.getAuthor());

        existingBook.setPrice(updatedBook.getPrice());

        existingBook.setCategory(updatedBook.getCategory());

        return bookRepository.save(existingBook);

	} }

