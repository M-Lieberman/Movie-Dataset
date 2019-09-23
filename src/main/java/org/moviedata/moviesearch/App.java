package org.moviedata.moviesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class App {

    static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String filename;
        if (args.length == 0 || args[0].isEmpty()) {
            filename = "src/main/resources/tmdb_5000_movies_2010-2017.csv";
        } else {
            filename = args[0];
        }

        List<Movie> movies = CsvFileReader.loadMoviesFromFile(filename);

        // sort by run time
//        movies.sort(Comparator.comparingLong(Movie::getRuntimeInMinutes));
        // sort in place
        movies.sort(Comparator.comparing(Movie::getReleaseDate));
        // create new sorted list
        List<Movie> sortedMovies = movies.stream().sorted(Comparator.comparing(Movie::getReleaseDate)).collect(Collectors.toList());

        // print
        sortedMovies.forEach(System.out::println);

    }
}
