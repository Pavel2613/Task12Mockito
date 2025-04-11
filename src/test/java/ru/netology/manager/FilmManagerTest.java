package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test // добавление последних трех фильмов если лимит 3 фильма
    public void shouldReturnLastThreeFilms() {
        FilmManager manager = new FilmManager(3);

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] expected = {"Фильм 5", "Фильм 4", "Фильм 3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual); // сравниваем массивы
    }

    @Test // количество фильмов меньше установленного лимита
    public void theNumberOfFilmsIsLessThanTheSetLimit() {
        FilmManager manager = new FilmManager(4);

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 3", "Фильм 2", "Фильм 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // добавить один фильм
    public void addOneMovie() {
        FilmManager manager = new FilmManager();

        manager.addMovie("Фильм 1");

        String[] expected = {"Фильм 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // добавить несколько фильмов
    public void addMultipleMovies() {
        FilmManager manager = new FilmManager();

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");

        String[] expected = {"Фильм 1", "Фильм 2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // фильмы не добавлены
    public void noMoviesAdded() {
        FilmManager manager = new FilmManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}