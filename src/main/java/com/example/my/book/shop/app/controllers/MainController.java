package com.example.my.book.shop.app.controllers;

import com.example.my.book.shop.app.data.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private final BookService bookService;

    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"bookshops/main",""})
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

}
