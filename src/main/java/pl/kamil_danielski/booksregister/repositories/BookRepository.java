package pl.kamil_danielski.booksregister.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kamil_danielski.booksregister.domain.Book;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
