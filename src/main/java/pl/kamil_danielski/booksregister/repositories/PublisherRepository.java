package pl.kamil_danielski.booksregister.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kamil_danielski.booksregister.domain.Publisher;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Optional<Publisher> findByName(String name);
}
