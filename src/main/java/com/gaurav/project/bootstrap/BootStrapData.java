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

        publisherRepository.save(arihant);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(arihant);
        arihant.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(arihant);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement without EJB", "123456");
        Book wileyManual = new Book("Wiley Manual", "10");
        Publisher wiley = new Publisher("Wiley Inc. Pvt Ltd", "Arizon, USA");

        publisherRepository.save(wiley);

        rod.getBooks().add(noEJB);
        rod.getBooks().add(wileyManual);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(wiley);
        wileyManual.getAuthors().add(rod);
        wileyManual.setPublisher(wiley);
        wiley.getBooks().add(noEJB);
        wiley.getBooks().add(wileyManual);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        bookRepository.save(wileyManual);
        publisherRepository.save(wiley);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
