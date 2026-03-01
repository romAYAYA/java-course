package Object;

import java.util.Objects;

public class Book {
    public String title;
    public String author;
    public int pagesNumber;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pagesNumber == book.pagesNumber && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pagesNumber);
    }

    public Book(String title, String author, int pagesNumber) {
        this.title = title;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }
}