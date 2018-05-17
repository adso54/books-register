package pl.kamil_danielski.booksregister.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.kamil_danielski.booksregister.domain.Book;
import pl.kamil_danielski.booksregister.services.BookService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class indexControlerTest {


    IndexControler controler;

    @Mock
    BookService bookService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controler = new IndexControler(bookService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(controler).build();

        mockMVC.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }


    @Test
    public void getIndexPage() {
        //given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book());
        Book book = new Book();
        book.setId(1L);

        bookSet.add(book);

        when(bookService.getAll()).thenReturn(bookSet);

        ArgumentCaptor<Set<Book>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = controler.getIndexPage(model);

        //then
        assertEquals(viewName, "index");
        verify(bookService, times(1)).getAll();
        verify(model, times(1)).addAttribute(eq("books"), argumentCaptor.capture());
        Set<Book> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());



    }
}