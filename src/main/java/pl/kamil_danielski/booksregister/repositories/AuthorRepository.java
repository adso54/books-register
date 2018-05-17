package pl.kamil_danielski.booksregister.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kamil_danielski.booksregister.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByLastName(String lastName);
    Optional<Author> findByFirstName(String firstName);
}
