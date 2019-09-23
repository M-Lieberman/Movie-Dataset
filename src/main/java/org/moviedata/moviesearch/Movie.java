package org.moviedata.moviesearch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Movie {

    private static final Logger LOG = LoggerFactory.getLogger(Movie.class);

    private String id;
    private String originalTitle;
    private String title;
    private LocalDate releaseDate;
    private int runtimeInMinutes = 0;
    private String tagline;
    private List<Keyword> keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        // There are multiple date formats in the dataset, so we try and parse all the known formats.
        List<DateTimeFormatter> knownDatePatterns = getDateTimeFormatters();

        if (!releaseDate.isEmpty()) {
            for(DateTimeFormatter dateFormatter: knownDatePatterns) {
                try {
                    setReleaseDate(LocalDate.parse(releaseDate, dateFormatter));
                } catch (DateTimeParseException e) {
                    // go to the next date pattern
                }
            }
        }
    }

    private List<DateTimeFormatter> getDateTimeFormatters() {
        List<DateTimeFormatter> knownDatePatterns = new ArrayList<>();
        knownDatePatterns.add(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH));
        knownDatePatterns.add(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
        return knownDatePatterns;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(String runtimeInMinutes) {
        if (runtimeInMinutes != null && !runtimeInMinutes.isEmpty()) {
            double d = Double.parseDouble(runtimeInMinutes);
            setRuntimeInMinutes((int)d);
        }
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public void addKeyword(Keyword keyword) {
        this.keywords.add(keyword);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", runtimeInMinutes=" + runtimeInMinutes +
                ", tagline='" + tagline + '\'' +
                ", keywords=" + keywords +
                '}';
    }
}
