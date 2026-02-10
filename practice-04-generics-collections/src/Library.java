import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(b -> b.author().equals(author))
                .toList();
    }

    public List<Book> findByYear(int year) {
        return books.stream()
                .filter(b -> b.year() == year)
                .toList();
    }

    public void removeBook(String title) {
        books.removeIf(b -> b.title().equals(title));
    }

    public Book findNewestBook() {
        return books.stream()
                .max(Comparator.comparingInt(Book::year))
                .orElse(null);
    }

    public Map<String, Integer> getBookCountByAuthor() {
        var res = new HashMap<String, Integer>();

        for (var b : books) {
            res.put(b.author(), res.getOrDefault(b.author(), 0) + 1);
        }

        return res;
    }

    public record Book(String title, String author, int year) {
    }
}
