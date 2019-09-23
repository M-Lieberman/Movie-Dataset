package org.moviedata.moviesearch;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

class CsvFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(CsvFileReader.class);

    // read file with Apache Commons CSV
    public static List<Movie> loadMoviesFromFile(final String filename) {


        Reader csvReader;
        List<Movie> movies = new ArrayList<>(1000);

        try {
            csvReader = new java.io.FileReader(filename);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(csvReader);

            for (CSVRecord record : records) {
                Movie movie = MovieFactory.buildMovieFromRecord(record);
                List<Keyword> keywords = KeywordFactory.buildKeywordsFromRecord(record);
                movie.setKeywords(keywords);
                movies.add(movie);

            }
            csvReader.close();
        } catch (IOException e) {
            LOG.warn("Problem reading file.");
        }

        return movies;
    }


}
