package org.moviedata.moviesearch;

import org.junit.Test;

public class FileReaderTest {

    @Test
    public void readTestFile() {
        String relativePath = "src/main/resources/";
        String filename = "data/tmdb_5000_movies_testsample.csv";
//        CsvFileReader.loadMoviesFromFile(relativePath + filename);
        CsvFileReader.readFile(relativePath + filename);
    }

    @Test
    public void read1GbTestFile() {
        String relativePath = "src/main/resources/";
        String filename = "data/tmdb_5000_movies_2010-2017.csv";
        CsvFileReader.loadMoviesFromFile(relativePath + filename);
    }

    @Test
    public void readCompleteFile() {
        String relativePath = "src/main/resources/";
        String filename = "data/tmdb_5000_movies.csv";
        CsvFileReader.loadMoviesFromFile(relativePath + filename);
    }

    @Test
    public void readAndSortCompleteFile() {
        String relativePath = "src/main/resources/";
        String filename = "data/tmdb_5000_movies.csv";
        CsvFileReader.readFile(relativePath + filename);
    }
}