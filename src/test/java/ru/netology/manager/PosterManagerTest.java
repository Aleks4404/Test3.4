
package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest{
    private PosterManager manager = new PosterManager();
    private Film one = new Film(1, "one", "Comedy", "https://www.kinopoisk.ru");
    private Film two = new Film(2, "two", "Detective", "https://www.kinopoisk.ru");
    private Film three = new Film(3, "three", "Drama", "https://www.kinopoisk.ru");
    private Film four = new Film(4, "four", "Horrors", "https://www.kinopoisk.ru");
    private Film five = new Film(5, "five", "Anime", "https://www.kinopoisk.ru");
    private Film six = new Film(6, "two", "Biography", "https://www.kinopoisk.ru");
    private Film seven = new Film(7, "three", "Military", "https://www.kinopoisk.ru");
    private Film eight = new Film(8, "four", "Story", "https://www.kinopoisk.ru");
    private Film nine = new Film(9, "one", "Music", "https://www.kinopoisk.ru");
    private Film ten = new Film(10, "two", "Thriller", "https://www.kinopoisk.ru");
    private Film eleven = new Film(11, "three", "Fantasy", "https://www.kinopoisk.ru");

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
    }

    @Test
    void getLastWithQuantityMoreThanInList() { //пол-ть последн. с кол-вом БОЛЬШЕ, чем в списке
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastWithQuantityLessThanInList() { //пол-ть последн. с кол-вом МЕНЬШЕ, чем в списке
        manager.add(ten);
        manager.add(eleven);
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
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


