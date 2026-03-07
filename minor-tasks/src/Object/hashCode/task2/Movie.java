package Object.hashCode.task2;

import java.util.Objects;

public class Movie {
    String title;
    int releaseYear;

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) return false;
        Movie other = (Movie) o;
        return Objects.equals(title, other.title) && releaseYear == other.releaseYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear);
    }

    public String description() {
        return '"' + title + "\" (" + releaseYear + " год)";
    }
}
