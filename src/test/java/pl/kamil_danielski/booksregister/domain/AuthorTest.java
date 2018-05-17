package pl.kamil_danielski.booksregister.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author;
    private final Long ID = 3L;

    @Before
    public void setUp() throws Exception {
        author = new Author();
    }

    @Test
    public void testGettersAndSetters(){
        author.setId(ID);
        author.setFirstName("first");
        author.setLastName("last");

        assertEquals(author.getId(), ID);
        assertEquals(author.getFirstName(), "first");
        assertEquals(author.getLastName(), "last");

    }
}