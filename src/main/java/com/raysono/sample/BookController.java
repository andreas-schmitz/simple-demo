package com.raysono.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raysono.sample.data.Book;
import com.raysono.sample.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	Iterable<Book> getPersons() {
		return repository.findAll();
	}

	@RequestMapping(path = "/book", method = RequestMethod.POST, consumes = "application/json")
	public void addPerson(@RequestBody Book book) throws JsonProcessingException {
		repository.save(book);
	}

}
