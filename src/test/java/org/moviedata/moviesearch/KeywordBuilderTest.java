package org.moviedata.moviesearch;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class KeywordBuilderTest {


    @Test
    public void readJSonArraySingleKeyword() {
        String singleKeywordArray = "[{\"id\": 4379, \"name\": \"time travel\"}]";
        List<Keyword> actual = KeywordBuilder.parseJsonArray(singleKeywordArray);

        assertThat(actual.get(0), allOf(
                hasProperty("id", is(4379)),
                hasProperty("name", is("time travel"))
        ));
    }

    @Test
    public void parseJsonArray() {
        String keywordsArray = "[{\"id\": 4379, \"name\": \"time travel\"}, {\"id\": 5455, \"name\": \"time machine\"}, {\"id\": 9951, \"name\": \"alien\"}, {\"id\": 174915, \"name\": \"fictional government agency\"}, {\"id\": 185668, \"name\": \"seeing the future\"}, {\"id\": 208756, \"name\": \"changing history\"}]\n";
        List<Keyword> actual = KeywordBuilder.parseJsonArray(keywordsArray);
//        Keyword expected = new Keyword(4379, "time travel");
        assertThat(actual, hasSize(6));
        assertThat(actual.get(5), allOf(
                hasProperty("id", is(208756)),
                hasProperty("name", is("changing history"))
        ));

    }

}