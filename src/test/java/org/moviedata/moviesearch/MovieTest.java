package org.moviedata.moviesearch;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovieTest {

    @Test
    public void testSetReleaseDateFormat1() {
        Movie movie = new Movie();
        movie.setReleaseDate("01/06/1974");
        assertThat(movie.getReleaseDate(), is(LocalDate.of(1974, Month.JUNE, 01)));
    }

    @Test
    public void testSetReleaseDateFormat2() {
        Movie movie = new Movie();
        movie.setReleaseDate("2009-12-10");
        assertThat(movie.getReleaseDate(), is(LocalDate.of(2009, Month.DECEMBER, 10)));
    }

    @Test
    public void testSetUnknownReleaseDateFormatIsNull() {
        Movie movie = new Movie();
        movie.setReleaseDate("2017/01/02");
        assertThat(movie.getReleaseDate(), is(nullValue()));
    }

    @Test
    public void testSetEmptyReleaseDate() {
        Movie movie = new Movie();
        movie.setReleaseDate("");
        assertThat(movie.getReleaseDate(), is(nullValue()));
    }

    @Test
    public void testSetNullReleaseDate() {
        Movie movie = new Movie();
        movie.setReleaseDate(new String());
        assertThat(movie.getReleaseDate(), is(nullValue()));
    }


    @Test
    public void testSetRuntimeInMinutes() {
        Movie movie = new Movie();
        movie.setRuntimeInMinutes("125");
        assertThat(movie.getRuntimeInMinutes(), isA(Integer.class));
        assertThat(movie.getRuntimeInMinutes(), is(125));
    }

    @Test
    public void testSetRuntimeInMinutesWithDecimal() {
        Movie movie = new Movie();
        movie.setRuntimeInMinutes("116.0");
        assertThat(movie.getRuntimeInMinutes(), isA(Integer.class));
        assertThat(movie.getRuntimeInMinutes(), is(116));
    }



    @Test
    public void testSetRuntimeInMinutesZeroValue() {
        Movie movie = new Movie();
        movie.setRuntimeInMinutes("0");
        assertThat(movie.getRuntimeInMinutes(), isA(Integer.class));
        assertThat(movie.getRuntimeInMinutes(), is(0));
    }

    @Test
    public void testSetRuntimeInMinutesNullValue() {
        Movie movie = new Movie();
        movie.setRuntimeInMinutes(null);
        assertThat(movie.getRuntimeInMinutes(), isA(Integer.class));
        assertThat(movie.getRuntimeInMinutes(), is(0));
    }


}