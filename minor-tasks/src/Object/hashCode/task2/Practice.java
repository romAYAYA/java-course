package Object.hashCode.task2;

import Object.hashCode.task2.Actor;
import Object.hashCode.task2.Movie;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        HashMap<Actor, ArrayList<Movie>> filmography = new HashMap<>();
        HashMap<Movie, Double> ratings = new HashMap<>();

        Movie pulpFictionMovie = new Movie("Криминальное чтиво", 1994);
        Movie dieHardMovie = new Movie("Крепкий Орешек", 1988);
        ratings.put(pulpFictionMovie, 8.9);
        ratings.put(dieHardMovie, 8.2);

        Actor bWillis = new Actor("Брюс", "Уиллис");

        ArrayList<Movie> actorMovies = new ArrayList<>();
        actorMovies.add(pulpFictionMovie);
        actorMovies.add(dieHardMovie);

        filmography.put(bWillis, actorMovies);

        if (filmography.containsKey(new Actor("Брюс", "Уиллис"))) {
            ArrayList<Movie> foundMovies = filmography.get(new Actor("Брюс", "Уиллис"));
            System.out.println("В фильмографии актёра Б. Уиллис найдены следующие фильмы: ");
            for (Movie movie : foundMovies) {
                if (ratings.containsKey(new Movie(movie.title, movie.releaseYear))) {
                    double rating = ratings.get(movie);
                    System.out.println("Фильм " + movie.description() + " с рейтингом " + rating);
                } else {
                    System.out.println("Что-то пошло не так... Проверьте реализацию equals и hashCode в классе Movie.");
                }
            }
        } else {
            System.out.println("Что-то пошло не так... Проверьте реализацию equals и hashCode в классе Actor.");
        }
    }
}