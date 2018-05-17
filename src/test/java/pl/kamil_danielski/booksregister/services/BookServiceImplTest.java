package pl.kamil_danielski.booksregister.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kamil_danielski.booksregister.domain.Book;
import pl.kamil_danielski.booksregister.repositories.BookRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BookServiceImplTest {

    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);

        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void findByTitle() {
        Book book = new Book();
        book.setTitle("Test");

        Optional<Book> bookOptional = Optional.of(book);

        when(bookRepository.findByTitle(anyString())).thenReturn(bookOptional);

        Book bookReturned = bookService.findByTitle("Test");

        assertNotNull(bookReturned);
        verify(bookRepository, times(1)).findByTitle(anyString());
        verify(bookRepository, never()).findAll();
        verify(bookRepository, never()).findById(anyLong());
    }

    @Test
    public void findById() {
        Book book = new Book();
        book.setId(1L);
        Optional<Book> bookOptional = Optional.of(book);

        when(bookRepository.findById(anyLong())).thenReturn(bookOptional);

        Book bookReturned = bookService.findById(1L);

        assertNotNull(bookReturned);
        verify(bookRepository, times(1)).findById(anyLong());
        verify(bookRepository, never()).findAll();
        verify(bookRepository, never()).findByTitle(anyString());

    }

    @Test
    public void getAll() {
        Book book = new Book();
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book);

        when(bookRepository.findAll()).thenReturn(bookSet);

        Set<Book> books = bookService.getAll();

        assertEquals(books.size(), 1);
        verify(bookRepository, times(1)).findAll();
        verify(bookRepository, never()).findByTitle(anyString());
        verify(bookRepository, never()).findById(anyLong());

    }
}