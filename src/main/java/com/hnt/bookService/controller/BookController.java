package com.hnt.bookService.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hnt.bookService.entity.Book;
import com.hnt.bookService.entity.BookCategory;
import com.hnt.bookService.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/digitalbooks")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;
	
	@Autowired
	RestTemplate restTemplate;

	// Get All Books
	@GetMapping
	public ResponseEntity<List<Book>> findAllBook() {
		log.debug("Inside findall book");
		List<Book> book = bookService.getAllBooks();
		ResponseEntity<List<Book>> response;
		if (book == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(book, HttpStatus.OK);
		}
		return response;
	}

	// Get book according category, Price, Publisher
	@GetMapping("/search")
	public ResponseEntity<List<Book>> findBooks(@RequestParam BookCategory category, @RequestParam BigDecimal price,
			@RequestParam String publisher, @RequestParam String author) {
		ResponseEntity<List<Book>> response;
		List<Book> book = bookService.getBook(category, price, publisher, author);
		response = new ResponseEntity<>(book, HttpStatus.OK);
		return response;
	}

	// Get book according to readermailID and bookId
	@GetMapping("/readers/{emailId}/books/{bookId}")
	public Book findBook( @PathVariable String emailId, @PathVariable Integer bookId) {
		return bookService.readBook(emailId, bookId);
	}

	// Add Books
	@PostMapping("/author/books")
	public ResponseEntity<Integer> addBook(@Valid @RequestBody Book book) {
		ResponseEntity<Integer> response;
		Book book1=bookService.addBook(book);
		if(book1==null) {
			response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			Integer bookId=book1.getBookId();
			response=new ResponseEntity<>(bookId, HttpStatus.CREATED);
			ResponseEntity<String> responseFromEmailService=restTemplate.postForEntity("http://localhost:8083/email", book1.getReaderMailId(), String.class);
			log.debug(responseFromEmailService.getBody());
		}
		
		return response;
	}

}
