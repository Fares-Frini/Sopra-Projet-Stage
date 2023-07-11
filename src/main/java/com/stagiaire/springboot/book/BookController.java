package com.stagiaire.springboot.book;


import org.springframework.web.bind.annotation.RestController;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="api/v1/Book")

public class BookController {

	
	private final BookService bookService ;
	
	
	
@Autowired
	public BookController(BookService bookService)
	{
		this.bookService=bookService;
	}
	@GetMapping("/getbook")
	public List<Book> getBook()
	{
		return bookService.getBook();
	}
	@PostMapping("/save")
	public Book saveBook(@RequestBody Book b)
	{
		return bookService.saveBook(b);
	}
	  
	    
	  /*  @Autowired
	    private BookRepository bookRepository;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
	                                             @RequestParam("price") double price,
	                                             @RequestParam("author") String author,
	                                             @RequestParam("category") String category) {
	        // Save the file and book details
	        if (file.isEmpty()) {
	            return ResponseEntity.badRequest().body("Please select a file.");
	        }

	        try {
	            // Process the file and save the book
	            byte[] bytes = file.getBytes();
	            // Save the file and book details to the database or any storage medium
	           
	            // Create a new book instance
	            Book book = new Book();
	            book.setName(file.getOriginalFilename());
	            book.setPrice(price);
	            book.setAuthor(author);
	            book.setCategory(category);
	            //book.setFile(bytes);

	            // Save the book to the database
	            bookRepository.save(book);
	            
	            return ResponseEntity.ok("File uploaded successfully and book details saved.");
	        } catch (IOException e) {
	            return ResponseEntity.badRequest().body("File upload failed: " + e.getMessage());
	        }
	    }
	   // public byte[]downloadFile (String fileName){*/
	    	
	    	
	    
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id)
	{
		bookService.deleteBook(id);
	}
	@PutMapping("/update/{id}")

    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook)
	{
        return bookService.updateBook(id, updatedBook);

    }
	


}
