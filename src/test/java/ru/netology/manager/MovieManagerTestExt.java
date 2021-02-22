package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTestExt {
    private int currentNumberMovies = 10;
    private MovieManager manager = new MovieManager(currentNumberMovies);

    private Movie first = new Movie("1", "//*", "first", "comedy");
    private Movie second = new Movie("2", "//**", "second", "drama");
    private Movie third = new Movie("3", "//***", "third", "thriller");
    private Movie fourth = new Movie("4", "//****", "fourth", "documentary");
    private Movie fifth = new Movie("5", "//*****", "fifth", "documentary");
    private Movie sixth = new Movie("6", "//******", "sixth", "documentary");

    @BeforeEach
    public void setUp() {
        manager.setNumberMovies(currentNumberMovies);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldAddUnderMaxResult() {
        Movie seventh = new Movie("7", "//****", "seventh", "documentary");
        manager.add(seventh);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddUpMaxResult() {
        Movie seventh = new Movie("7", "//****", "seventh", "documentary");
        Movie eighth = new Movie("8", "//****", "eighth", "documentary");
        Movie ninth = new Movie("9", "//*****", "ninth", "documentary");
        Movie tenth = new Movie("10", "//******", "tenth", "documentary");
        Movie eleventh = new Movie("11", "//******", "eleventh", "documentary");
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

}