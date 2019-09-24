package org.moviedata.moviesearch;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AppTest.class,
        MovieTest.class,
        KeywordBuilderTest.class
//        FileReaderTest.class
})

public class MovieSearchTestSuite {
    // leave empty, used as holder for the above annotations
}
