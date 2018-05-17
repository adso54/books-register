package pl.kamil_danielski.booksregister.services;

import pl.kamil_danielski.booksregister.domain.Book;

import java.util.Set;

public interface BookService {

    Book findByTitle(String title);
    Book findById(Long id);
    Set<Book> getAll();

}
