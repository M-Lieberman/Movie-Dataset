package org.moviedata.moviesearch;

import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MovieBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(MovieBuilder.class);

    public static Movie createMovieFromCSVRecord(final CSVRecord record) {

        Movie movie = new Movie();

        movie.setId(record.get(Headers.id));
        movie.setOriginalTitle(record.get(Headers.original_title));
        movie.setTitle(record.get(Headers.title));
        movie.setReleaseDate(record.get(Headers.release_date));
        movie.setRuntimeInMinutes(record.get(Headers.runtime));
        movie.setTagline(record.get(Headers.tagline));
        // build keywords
        movie.setKeywords(KeywordBuilder.createKeywordsFromCSVRecord(record));

        LOG.info(">>" + movie.toString() + "\n\n");
        return movie;
    }

    public enum Headers {
        id, original_title, title, release_date, runtime, tagline
    }
}
