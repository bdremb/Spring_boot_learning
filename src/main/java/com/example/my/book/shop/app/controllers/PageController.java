package com.example.my.book.shop.app.controllers;

import com.example.my.book.shop.app.data.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshops")
public class PageController {

    private final BookService bookService;

    public PageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/genres/slug")
    public String genresSlugPage(Model model) {
        return "genres/slug";
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authorData", bookService.getAuthorsData());
        return "authors/index";
    }

    @GetMapping("/authors/slug")
    public String authorsSLugPage(Model model) {
        return "authors/slug";
    }

}
