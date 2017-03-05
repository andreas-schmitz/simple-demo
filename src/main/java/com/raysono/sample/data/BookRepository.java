package com.raysono.sample.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "book", path = "bookinfo")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
	Book findByIsbn(String isbn);
}
