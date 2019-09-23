package org.moviedata.moviesearch;

import org.apache.commons.csv.CSVRecord;

import java.util.List;

class KeywordFactory {


    public static List<Keyword> buildKeywordsFromRecord(CSVRecord record) {
        return KeywordBuilder.createKeywordsFromCSVRecord(record);
    }
}
