package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author;
    private final Long ID = 1L;

    @Before
    public void setUp(){
        author = new Author();
    }

    @Test
    public void testGettersAndSetters(){

        author.setFirstName("Kamil");
        author.setLastName("Danielski");
        author.setId(ID);
        assertEquals(author.getFirstName(), "Kamil");
        assertEquals(author.getLastName(), "Danielski");
        assertEquals(author.getId(), ID);
    }

}