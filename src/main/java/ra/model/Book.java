package ra.model;

public class Book {
    private int bookId;
    private String bookName;
    private String title;
    private String description;
    private float price;
    private boolean status;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, String description, float price, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
