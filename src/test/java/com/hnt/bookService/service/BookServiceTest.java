package com.hnt.bookService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.hnt.bookService.entity.Book;
import com.hnt.bookService.repository.BookRepository;

public class BookServiceTest {
	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	BookService bookService;
	
	Book getBook(){
		Book book=new Book();
		book.setBookId(1);
		book.setBookLogo("book.com");
		book.setCategory("Comic");
		book.setContent("marvel");
		book.setPrice(300);
		book.setPublishedDate("20/12/2022");
		book.setPublisher("New");
		book.setReaderMailId("me@gmail.com");
		book.setTitle("XXXX");
		book.setAuthorName("YYYY");
		return book;
	}
	
//	@Test
//	void testAddBook() {
//		Book book=getBook();
//		when(bookRepository.save(book)).thenReturn(book);
//		bookService.addBook(book);
//		assertEquals(book, book.getBookId());
//	}
	
//	@Test
//	void testReadBook() {
//		Book book=getBook();
//		Integer bookId=1;
//		String readermailId="reader@gmail.com";
//		List<Book> list=new ArrayList<>();
//		list.add(book);
//		when(bookRepository.findAll()).thenReturn(list);
//		Book list1=bookService.readBook(readermailId, bookId);
//		assertEquals(list, list1);
//	}
	
//	@Test
//	void testGetBook() {
//		Book book=getBook();
//		List<Book> list=new ArrayList<>();
//		list.add(book);
//		String category="Comic";
//		Integer price=300;
//		String publisher="New";
//		when(bookRepository.findAll()).thenReturn(list);
//		List<Book> actual=bookService.getBook(category, price, publisher);
//		assertEquals(list, actual);
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
