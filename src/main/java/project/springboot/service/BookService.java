package project.springboot.service;

import org.springframework.web.multipart.MultipartFile;
import project.springboot.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
}
