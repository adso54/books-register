package pl.kamil_danielski.booksregister.services;

import pl.kamil_danielski.booksregister.domain.Author;

import java.util.Set;

public interface AuthorService {

    Set<Author> getAuthors();

    Author findById(Long id);

}
