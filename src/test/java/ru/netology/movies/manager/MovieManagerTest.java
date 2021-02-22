package ru.netology.movies.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.movies.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    private MovieManager manager = new MovieManager();

    public class MovieTestNonEmptyWithSetup {

        private Movie first = new Movie("1", "//*", "first", "comedy");
        private Movie second = new Movie("2", "//**", "second", "drama");
        private Movie third = new Movie("3", "//***", "third", "thriller");


        @BeforeEach
        public void setUp() {
            manager.add(first);
            manager.add(second);
            manager.add(third);
        }

        @Test
        public void shouldAdd() {
            Movie fourth = new Movie("4", "//****", "fourth", "documentary");
            manager.add(fourth);

            Movie[] actual = manager.getAll();
            Movie[] expected = new Movie[]{first, second, third, fourth};

            assertArrayEquals(expected, actual);
        }
    }
}