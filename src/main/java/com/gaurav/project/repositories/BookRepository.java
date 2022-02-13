package com.gaurav.project.repositories;

import com.gaurav.project.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
