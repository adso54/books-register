package pl.kamil_danielski.booksregister.services;

import org.springframework.stereotype.Service;
import pl.kamil_danielski.booksregister.domain.Book;
import pl.kamil_danielski.booksregister.repositories.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private Book book;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findByTitle(String title) {
            book = bookRepository.findByTitle(title).get();
            return book;
    }

    @Override
    public Book findById(Long id) {
            book = bookRepository.findById(id).get();
            return book;
    }

    @Override
    public Set<Book> getAll() {
        Set<Book> books = new HashSet<>();

        bookRepository.findAll().iterator().forEachRemaining(books::add);

        return books;
    }
}
