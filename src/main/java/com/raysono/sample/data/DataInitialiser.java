package com.raysono.sample.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DataInitialiser implements CommandLineRunner {
	private BookRepository repository;

	@Autowired
	public DataInitialiser(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("978-0-321-12521-7|Domain Driven Design|Eric Evans", "978-0-13-235088-4|Clean Code|Robert C. Martin",
				"978-0-201-61622-4|The Pragmatic Programmer|Andrew Hunt, David Thomas", "0-586-06645-4|Neuromancer|William Gibson")
				.forEach(bookInfo -> {
			String[] bookInfoParts = bookInfo.split("\\|");
			if (repository.findByIsbn(bookInfoParts[0]) == null) {
				repository.save(new Book(bookInfoParts[0], bookInfoParts[1], bookInfoParts[2]));
			}
		});
	}
}
