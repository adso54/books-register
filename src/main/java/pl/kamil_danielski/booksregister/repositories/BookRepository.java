package pl.kamil_danielski.booksregister.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kamil_danielski.booksregister.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
