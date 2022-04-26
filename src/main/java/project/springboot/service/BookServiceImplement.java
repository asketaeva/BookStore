package project.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springboot.model.Book;
import project.springboot.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplement implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException(" Book not found for id :: " + id);
        }
        return book;
    }

    @Override
    public void deleteBookById(long id) {
        this.bookRepository.deleteById(id);
    }

}
