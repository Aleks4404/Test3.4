package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyPosterManagerTest {
    private PosterManager manager = new PosterManager();
    private Film one = new Film(1, "one", "Comedy", "www.oneFilm.com");
    private Film two = new Film(2, "two", "Detective", "www.twoFilm.com");
    private Film three = new Film(3, "three", "Drama", "www.threeFilm.com");

    @Test
    void addToEmpty() {
        manager.add(one);
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastEmpty() {
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastWithQuantityLessThanInList() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{three, two,one};
        assertArrayEquals(expected, actual);
    }
}