package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;
    private final Long ID = 1L;

    @Before
    public void setUp() throws Exception {
        book = new Book();
    }

    @Test
    public void testGettersAndSetters(){
        //given
        Author author = new Author();
        author.setFirstName("Kamil");
        //when
        book.setTitle("title");
        book.setAuthor(author);
        book.setId(ID);
        book.setDecription("description");
        //then
        assertEquals(book.getId(), ID);
        assertEquals(book.getTitle(), "title");
        assertEquals(book.getAuthor(), author);
        assertEquals(book.getDecription(),"description");
    }
}