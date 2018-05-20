package pl.kamil_danielski.booksregister.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kamil_danielski.booksregister.domain.Publisher;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PublisherRepositoryIT {

    @Autowired
    PublisherRepository publisherRepository;

    Optional<Publisher> publisherOptional;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByName() {
        publisherOptional = publisherRepository.findByName("PWN");
        assertEquals("PWN", publisherOptional.get().getName());

    }
}