package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Book;
import ra.repository.BookRepository;
import ra.repositoryImp.BookRepositoryImp;
import ra.service.BookService;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
//    private BookRepository bookRepository;
//
//    public BookServiceImp() {
//        bookRepository = new BookRepositoryImp();
//    }
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public boolean save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public boolean delete(int bookId) {
        return bookRepository.delete(bookId);
    }
}
