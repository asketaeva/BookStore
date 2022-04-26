package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.springboot.model.Book;
import project.springboot.service.BookService;


@Controller
public class BookController {

    @Autowired
    private BookService booksService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listBooks", booksService.getAllBooks());
        return "bookInfo";
    }

    @GetMapping("/form")
    public String add(Model model){
        Book book = new Book();
        model.addAttribute("books", book);
        return "addBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books") Book book) {
        booksService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Book book = booksService.getBookById(id);
        model.addAttribute("books", book);
        return "updateBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable (value = "id") long id) {
        this.booksService.deleteBookById(id);
        return "redirect:/";
    }

}
