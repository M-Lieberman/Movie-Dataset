package org.moviedata.moviesearch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeywordBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(KeywordBuilder.class);

    public static List<Keyword> createKeywordsFromCSVRecord(final CSVRecord record) {
        return  parseKeywordString(record.get("keywords"));
    }

    private static List<Keyword> parseKeywordString(final String keywordString) {
        // String is JSON so parse with Jackson
        return parseJsonArray(keywordString);
    }

    static List<Keyword> parseJsonArray(final String jsonString) {
        List<Keyword> keywords = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            keywords = objectMapper.readValue(jsonString, new TypeReference<List<Keyword>>() {
            });
        } catch (IOException e) {
            LOG.error("error processing Keyword JSON array: " + e.toString());
        }
        return keywords;
    }

}
