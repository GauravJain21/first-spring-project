package com.gaurav.project.repositories;

import com.gaurav.project.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
