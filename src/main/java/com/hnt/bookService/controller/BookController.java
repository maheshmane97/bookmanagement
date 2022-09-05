package com.hnt.bookService.controller;

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

import com.hnt.bookService.entity.Book;
import com.hnt.bookService.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//TODO: "Remove /api/v1 from url"
@RequestMapping("/api/v1/digitalbooks")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	// Get All Books
	@GetMapping
	public ResponseEntity<Book> findAllBook() {
		
		List<Book> book = bookService.getAllBooks();
		ResponseEntity<Book> response;
		if (book == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}

	// Get book according category, Price, Publisher
	@GetMapping("/search")
	public ResponseEntity<List<Book>> findBooks(@RequestParam String category, @RequestParam Integer price,
			@RequestParam String publisher) {
		ResponseEntity<List<Book>> response;
		List<Book> book = bookService.getBook(category, price, publisher);
		response = new ResponseEntity<>(book, HttpStatus.OK);
		return response;
	}

	// Get book according to readermailID and bookId
	@GetMapping("/readers/{emailId}/books/{bookId}")
	public Book findBook(@PathVariable Integer bookId, @PathVariable String emailId) {
		return bookService.readBook(emailId, bookId);
	}

	// Add Books
	// TODO:"After bad request message should be  shown in postman"
	@PostMapping("/author/books")
	public Integer addBook(@Valid @RequestBody Book book) {
		bookService.addBook(book);
		return book.getBookId();
	}

}
