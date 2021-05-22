package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test
    void testEmptyMovies() {

        Movie[] movies = manager.getMovies();
        assertEquals(movies.length, 0);
    }

    @Test
    void testAddMovies() {
        Movie movie = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
        manager.addMovie(movie);
        assertEquals(manager.getMovies().length, 1);
    }

    @Test
    void testSetMoviesCount() {
        MovieManager manager = new MovieManager(1);
        Movie movie = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "https://www.kinopoisk.ru", "Вперёд", "мультфильм");
        manager.addMovie(movie);
        manager.addMovie(movie2);
        assertEquals(1, manager.getMovies().length);
        assertEquals(manager.getMovies()[0].getName(), "Вперёд");
    }

    @Test
    void testMoviesQueue() {
        Movie movie = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "https://www.kinopoisk.ru", "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3, "https://www.kinopoisk.ru", "Отель <<Белград>>", "комедия");
        Movie movie4 = new Movie(4, "https://www.kinopoisk.ru", "Джентльмены", "боевик");
        Movie movie5 = new Movie(5, "https://www.kinopoisk.ru", "Человек-невидимка", "ужасы");
        manager.addMovie(movie);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        assertEquals(manager.getMovies()[0].getName(), "Человек-невидимка");
        assertEquals(manager.getMovies()[4].getName(), "Бладшот");
    }
}

//        @Test
//        public void shouldNotRemoveIfNotExists() {
//            CartManager manager = new CartManager();
//            int idToRemove = 4;
//            PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
//            PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
//            PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
//            manager.add(first);
//            manager.add(second);
//            manager.add(third);
//
//            manager.removeById(idToRemove);
//
//            PurchaseItem[] actual = manager.getAll();
//            PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
//
//            assertArrayEquals(expected, actual);
//        }


