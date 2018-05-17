package pl.kamil_danielski.booksregister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamil_danielski.booksregister.services.BookService;

@Controller
public class IndexControler {

    private final BookService bookService;

    public IndexControler(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        model.addAttribute("books", bookService.getAll());
        return "index";
    }
}
