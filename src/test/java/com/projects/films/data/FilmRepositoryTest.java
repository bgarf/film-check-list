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
    private Film film = new Film(title, "Stanley Kubrick", 1967, true);


    @Before
    public void mongoSetup() {
        filmRepository.save(film);
    }


    @Test
    public void findByTitle() {
        Film result = filmRepository.findByTitle(title);

        assertEquals(result, film);
    }
}
