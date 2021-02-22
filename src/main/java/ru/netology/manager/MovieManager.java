package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private int numberMovies = 10;

    public int getNumberMovies() {
        return numberMovies;
    }

    public void setNumberMovies(int numberMovies) {
        this.numberMovies = numberMovies;
    }

    public MovieManager(int numberMovies) { }

    private Movie[] items = new Movie[0];

        public void add(Movie item) {
            // создаём новый массив размером на единицу больше
            int length = items.length + 1;
            Movie[] tmp = new Movie[length];
            // itar + tab
            // копируем поэлементно
            // for (int i = 0; i < items.length; i++) {
            //   tmp[i] = items[i];
            // }
            System.arraycopy(items, 0, tmp, 0, items.length);
            // кладём последним наш элемент
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
            System.out.println("длина массива с фильмами " + items.length);
        }

        public Movie[] getAll() {
            int resultLength = items.length;
            if (resultLength > getNumberMovies()) {
                resultLength = getNumberMovies();
            }

            System.out.println("Длина ленты " +resultLength);

            Movie[] result = new Movie[resultLength];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
            return result;
        }

    }
