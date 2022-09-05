package com.hnt.bookService.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
//TODO: "Use @Data instead of setter and getter"
public class Book {
	//TODO: "Change bookID to Id and add another bookID instance variable"
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	@NotBlank(message = "Book Logo url not should be Blank###")
	private String bookLogo;
	
	//TODO: "Change String to enum"
	@NotBlank(message = "Book Category not should be Blank###")
	private String category;
	
	@NotBlank(message = "Book Title not should be Blank###")
	private String title;
	
	@NotBlank(message = "Book Publisher Name not should be Blank###")
	private String publisher;
	
	//TODO: "Change string to LocalDate"
	@JsonFormat(pattern = "dd/mm/yyyy", shape = Shape.STRING)
	private String publishedDate;
	
	//TODO:"Change integer to bigdecimal"
	@Min(value = 1, message = "Price should be more than One Rupees###")
	private Integer price;
	
	@NotBlank(message = "Book Content not should be Blank###")
	private String content;
	
	@NotBlank(message = "Book author name not should be Blank###")
	private String authorName;
	
	@NotBlank(message = "Book reader name not should be Blank###")
	private String readerMailId;



	public Integer getBookId() {
		return bookId;
	}



	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}



	public String getBookLogo() {
		return bookLogo;
	}



	public void setBookLogo(String bookLogo) {
		this.bookLogo = bookLogo;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getPublishedDate() {
		return publishedDate;
	}



	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getAuthorName() {
		return authorName;
	}



	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	public String getReaderMailId() {
		return readerMailId;
	}



	public void setReaderMailId(String readerMailId) {
		this.readerMailId = readerMailId;
	}



	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
