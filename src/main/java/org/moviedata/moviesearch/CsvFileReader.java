package org.moviedata.moviesearch;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CsvFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(CsvFileReader.class);

    static void readFile(final String filename) {
        List<Movie> movies = loadMoviesFromFile(filename);
        processMovies(movies);
    }

    // read file with Apache Commons CSV
    static List<Movie> loadMoviesFromFile(final String filename) {

        List<Movie> movies = new ArrayList<>(1000);

        try (Reader csvReader = new java.io.FileReader(filename)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(csvReader);
            for (CSVRecord record : records) {
                Movie movie = MovieFactory.buildMovieFromRecord(record);
                List<Keyword> keywords = KeywordFactory.buildKeywordsFromRecord(record);
                movie.setKeywords(keywords);
                movies.add(movie);
            }
        } catch (IOException e) {
            LOG.warn("Problem reading file.");
        }

        return movies;
    }

    // TODO method for any test movie collection transformations
    private static void processMovies(List<Movie> movies) {

        // sort by run time
//        movies.sort(Comparator.comparingLong(Movie::getRuntimeInMinutes));
        // sort in place by release date (null safe)
//        movies.sort(Comparator.comparing(Movie::getReleaseDate, Comparator.nullsLast(Comparator.reverseOrder())));

        // create new sorted list (null safe on release date)
        List<Movie> sortedMovies = movies.stream().sorted(Comparator.comparing(Movie::getReleaseDate, Comparator.nullsLast(Comparator.reverseOrder()))).collect(Collectors.toList());
        // print sorted movies
        System.out.println("Movies sorted by Release Date/n/n");
        sortedMovies.forEach(System.out::println);
    }
}
