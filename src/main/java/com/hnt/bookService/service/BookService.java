package com.hnt.bookService.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.bookService.entity.Book;
import com.hnt.bookService.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	
	
	//Get All Books
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	//Get book according category, Price, Publisher
	public List<Book> getBook(String category, Integer price, String publisher) {
		List<Book> books=bookRepository.findAll().stream().filter(e->
		e.getCategory().equalsIgnoreCase(category) || e.getPrice()==price || e.getPublisher().equalsIgnoreCase(publisher)).collect(Collectors.toList());
		return books;
	}
	
	//Reader Can read Book
	public Book readBook(String readerMailId, Integer bookId) {
		Book book=null;
		Stream<Book> readBook=bookRepository.findAll().stream().filter(e->e.getReaderMailId().equalsIgnoreCase(readerMailId));
		if(readBook!=null) {
			 book=bookRepository.findById(bookId).get();
		}
		return book;
		
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
}
