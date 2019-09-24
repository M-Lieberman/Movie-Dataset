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
            filename = "src/main/resources/tmdb_5000_movies.csv";
        } else {
            filename = args[0];
        }
        CsvFileReader.readFile(filename);
    }
}
