package com.projects.films.data;

import com.projects.films.model.Film;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    private String title = "2001 Space Odyssey";
    private Film spaceOdyssey = new Film(title, "Stanley Kubrick", 1968, true);
    private Film goodfellas = new Film("Goodfellas", "Martin Scorsese", 1990, true);


    @Before
    public void mongoSetup() {
        filmRepository.save(spaceOdyssey);
        filmRepository.save(goodfellas);
    }


    @Test
    public void findByTitleShouldReturnFilmWithSameTitle() {
        Film result = filmRepository.findByTitle(title);

        assertEquals(result, spaceOdyssey);
    }
}
