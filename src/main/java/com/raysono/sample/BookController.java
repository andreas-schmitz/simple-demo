package com.raysono.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raysono.sample.data.Book;
import com.raysono.sample.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	private BookRepository repository;

	@Autowired
	public BookController(BookRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	Iterable<Book> getBooks() {
		return repository.findAll();
	}

	@RequestMapping(path = "/book/{isbn}", method = RequestMethod.GET)
	Book getBook(@PathVariable String isbn) {
		return repository.findByIsbn(isbn);
	}

	@RequestMapping(path = "/book", method = RequestMethod.POST, consumes = "application/json")
	public void addBook(@RequestBody Book book) throws JsonProcessingException {
		repository.save(book);
	}

}
