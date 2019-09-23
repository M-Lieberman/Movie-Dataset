package org.moviedata.moviesearch;

import org.apache.commons.csv.CSVRecord;

class MovieFactory {

    public static Movie buildMovieFromRecord(CSVRecord record) {
        return MovieBuilder.createMovieFromCSVRecord(record);
    }

}
