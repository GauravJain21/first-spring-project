package com.gaurav.project.bootstrap;

import com.gaurav.project.model.Author;
import com.gaurav.project.model.Book;
import com.gaurav.project.model.Publisher;
import com.gaurav.project.repositories.AuthorRepository;
import com.gaurav.project.repositories.BookRepository;
import com.gaurav.project.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12345");
        Publisher arihant = new Publisher("Arihant Publisher", "Delhi, India");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        arihant.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(arihant);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement without EJB", "123456");
        Publisher wiley = new Publisher("Wiley Inc. Pvt Ltd", "Arizon, USA");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        wiley.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(wiley);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authros: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
