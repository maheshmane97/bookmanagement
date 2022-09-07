package com.hnt.bookService.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.bookService.entity.Book;
import com.hnt.bookService.entity.BookCategory;
import com.hnt.bookService.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	// Get All Books
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Get book according category, Price, Publisher
	public List<Book> getBook(BookCategory category, BigDecimal price, String publisher, String author) {
		List<Book> books = bookRepository.findAll().stream().filter(e -> e.getCategory() == category
				|| e.getPrice() == price || e.getPublisher().equalsIgnoreCase(publisher)).collect(Collectors.toList());
		return books;
	}

	// Reader Can read Book
	public Book readBook(String readerMailId, Integer bookId) {
		Book book = null;
		Stream<Book> readBook = bookRepository.findAll().stream()
				.filter(e -> e.getReaderMailId().equalsIgnoreCase(readerMailId));
		if (readBook != null) {
			log.debug("Inside readbook for loop line no 42");
			book = bookRepository.findByBookId(bookId);
		}
		return book;

	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
}
