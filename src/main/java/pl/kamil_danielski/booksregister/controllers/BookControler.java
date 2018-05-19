package pl.kamil_danielski.booksregister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamil_danielski.booksregister.services.BookService;

@Controller
public class BookControler {

    private final BookService bookService;

    public BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/book/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("book", bookService.findById(new Long(id)));
        return "book/show";
    }
}
