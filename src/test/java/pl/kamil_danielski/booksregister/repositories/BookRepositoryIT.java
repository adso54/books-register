package pl.kamil_danielski.booksregister.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kamil_danielski.booksregister.domain.Book;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIT {

    public static final String LOD = "Lód";

    @Autowired
    private BookRepository bookRepository;

    Optional<Book> bookOptional;

    @Test
    public void findByTitle() {
        bookOptional = bookRepository.findByTitle(LOD);
        assertEquals(LOD, bookOptional.get().getTitle());
    }
}