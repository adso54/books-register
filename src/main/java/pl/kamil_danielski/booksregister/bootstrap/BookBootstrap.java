package pl.kamil_danielski.booksregister.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kamil_danielski.booksregister.domain.Author;
import pl.kamil_danielski.booksregister.domain.Book;
import pl.kamil_danielski.booksregister.repositories.AuthorRepository;
import pl.kamil_danielski.booksregister.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class BookBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BookBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Loading bootstrap data");
        bookRepository.saveAll(getBooks()) ;
        log.debug("Bootstrap data saved");
    }

    private List<Book> getBooks() {

        RuntimeException expectedAuthorNotFound = new RuntimeException("Expected author not found!");

        List<Book> books = new ArrayList<>(3);

        Optional<Author> optionalAuthorKing = authorRepository.findByLastName("King");
        if(!optionalAuthorKing.isPresent())
            throw expectedAuthorNotFound;
        Author authorKing = optionalAuthorKing.get();

        Optional<Author> optionalAuthorLem = authorRepository.findByLastName("Lem");
        if(!optionalAuthorLem.isPresent())
            throw expectedAuthorNotFound;
        Author authorLem = optionalAuthorLem.get();

        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Mroczna wieża");
        book1.setAuthor(authorKing);
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Solaris");
        book2.setAuthor(authorLem);
        books.add(book2);

        Book book3 = new Book();
        book3.setId(3L);
        book3.setTitle("Bajki robotów");
        book3.setAuthor(authorLem);
        books.add(book3);

        return books;
    }
}
