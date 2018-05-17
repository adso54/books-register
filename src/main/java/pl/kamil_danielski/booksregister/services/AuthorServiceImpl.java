package pl.kamil_danielski.booksregister.services;

import org.springframework.stereotype.Service;
import pl.kamil_danielski.booksregister.domain.Author;
import pl.kamil_danielski.booksregister.repositories.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Author> getAuthors() {
        Set<Author> authors = new HashSet<>();

        authorRepository.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }
}
