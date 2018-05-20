package pl.kamil_danielski.booksregister.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kamil_danielski.booksregister.domain.Author;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryIT {

    public static final String STANISŁAW = "Stanisław";
    public static final String LEM = "Lem";
    @Autowired
    private AuthorRepository authorRepository;

    Optional<Author> authorOptional;

    @Test
    public void findByLastName() {
        authorOptional = authorRepository.findByLastName(LEM);
        assertEquals(LEM, authorOptional.get().getLastName());
    }

    @Test
    public void findByFirstName() {
        authorOptional = authorRepository.findByFirstName(STANISŁAW);
        assertEquals(STANISŁAW, authorOptional.get().getFirstName());
    }

}