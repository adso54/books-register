package pl.kamil_danielski.booksregister.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PublisherTest {

    public static final long ID_VALUE = 1L;
    private Publisher publisher;

    @Before
    public void setUp() throws Exception {
        publisher = new Publisher();
    }

    @Test
    public void testGettersAndSetters() {
        //given
        Set<Book> bookSet = new HashSet<>();
        Book book = new Book();
        book.setId(2L);
        bookSet.add(book);
        String helion = "Helion";
        
        //when
        publisher.setId(ID_VALUE);
        publisher.setBooks(bookSet);
        publisher.setName(helion);

        //then
        assertEquals(publisher.getBooks().iterator().next(), book);
        assertEquals(publisher.getId(), new Long(ID_VALUE));
        assertEquals(publisher.getName(), helion);

    }
}