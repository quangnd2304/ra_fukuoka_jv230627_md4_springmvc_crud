package ra.repository;

import ra.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(int bookId);

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(int bookId);
}
