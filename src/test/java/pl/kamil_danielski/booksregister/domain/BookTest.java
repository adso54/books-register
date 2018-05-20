package pl.kamil_danielski.booksregister.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private final Long ID = 1L;
    private final Long ID_2 = 1L;
    private final String TITLE = "title";
    private final String DESCRIPTION = "description";
    private Book book;
    private Author author;

    @Before
    public void setUp() throws Exception {
        author = new Author();
        author.setId(ID_2);
        book = new Book();
    }

    @Test
    public void testGettersAndSetters(){
       book.setId(ID);
       book.addAuthor(author);
       book.setTitle(TITLE);
       book.setDescription(DESCRIPTION);

       assertEquals(book.getId(), ID);
       assertEquals(book.getAuthors().iterator().next(), author);
       assertEquals(book.getTitle(), TITLE);
       assertEquals(book.getDescription(), DESCRIPTION);

    }
}