package pl.kamil_danielski.booksregister.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kamil_danielski.booksregister.domain.Author;
import pl.kamil_danielski.booksregister.repositories.AuthorRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AuthorServiceImplTest {

    private AuthorServiceImpl authorService;

    @Mock
    private AuthorRepository authorRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        authorService = new AuthorServiceImpl(authorRepository);
    }

    @Test
    public void getAuthors() {
        Author author = new Author();
        HashSet<Author> authorsData = new HashSet<>();
        authorsData.add(author);

        when(authorService.getAuthors()).thenReturn(authorsData);

        Set<Author> authors = authorService.getAuthors();

        assertEquals(authors.size(), 1);
        verify(authorRepository, times(1)).findAll();
        verify(authorRepository, never()).findById(anyLong());
    }

    @Test
    public void findById() {
        Author author = new Author();
        author.setId(1L);
        Optional<Author> authorOptional = Optional.of(author);

        when(authorRepository.findById(anyLong())).thenReturn(authorOptional);

        Author authorReturned = authorService.findById(1L);

        assertNotNull("Null obcject returned!", authorReturned);
        verify(authorRepository, times(1)).findById(anyLong());
        verify(authorRepository, never()).findAll();

    }
}