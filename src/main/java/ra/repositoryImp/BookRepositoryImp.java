package ra.repositoryImp;

import org.springframework.stereotype.Repository;
import ra.model.Book;
import ra.repository.BookRepository;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBook = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_book()}");
            ResultSet rs = callSt.executeQuery();
            listBook = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("Descriptions"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
                listBook.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBook;
    }

    @Override
    public Book findById(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_book_by_id(?)}");
            callSt.setInt(1,bookId);
            ResultSet rs = callSt.executeQuery();
            book = new Book();
            if (rs.next()) {
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("Descriptions"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insert_book(?,?,?,?,?)}");
            callSt.setString(1,book.getBookName());
            callSt.setString(2,book.getTitle());
            callSt.setString(3,book.getDescription());
            callSt.setFloat(4,book.getPrice());
            callSt.setBoolean(5,book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?,?,?)}");
            callSt.setInt(1,book.getBookId());
            callSt.setString(2,book.getBookName());
            callSt.setString(3,book.getTitle());
            callSt.setString(4,book.getDescription());
            callSt.setFloat(5,book.getPrice());
            callSt.setBoolean(6,book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setInt(1,bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
