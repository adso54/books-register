package pl.kamil_danielski.booksregister.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.kamil_danielski.booksregister.domain.Book;
import pl.kamil_danielski.booksregister.services.BookService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class BookControlerTest {

    private BookControler bookControler;
    MockMvc mockMvc;

    @Mock
    BookService bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bookControler = new BookControler(bookService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(bookControler)
                .build();
    }

    @Test
    public void showById() throws Exception {
        Book book = new Book();
        book.setId(1L);

        when(bookService.findById(anyLong())).thenReturn(book);

        mockMvc.perform(get("/book/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("book/show"))
                .andExpect(model().attributeExists("book"));

    }
}