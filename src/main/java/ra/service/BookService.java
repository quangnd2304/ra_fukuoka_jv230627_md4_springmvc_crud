package ra.service;

import ra.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int bookId);

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(int bookId);
}
