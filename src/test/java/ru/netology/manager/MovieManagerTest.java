package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private int currentNumberMovies = 5;
    private MovieManager manager = new MovieManager(currentNumberMovies);

    private Movie first = new Movie("1", "//*", "first", "comedy");
    private Movie second = new Movie("2", "//**", "second", "drama");
    private Movie third = new Movie("3", "//***", "third", "thriller");

    @BeforeEach
    public void setUp() {
        manager.setNumberMovies(currentNumberMovies);
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldAddUnderMaxResult() {
        Movie fourth = new Movie("4", "//****", "fourth", "documentary");
        manager.add(fourth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddUpMaxResult() {
        Movie fourth = new Movie("4", "//****", "fourth", "documentary");
        Movie fifth = new Movie("5", "//*****", "fifth", "documentary");
        Movie sixth = new Movie("6", "//******", "sixth", "documentary");
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

}