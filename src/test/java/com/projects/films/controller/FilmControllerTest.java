package com.projects.films.controller;

import com.projects.films.Application;
import com.projects.films.data.FilmRepository;
import com.projects.films.model.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FilmControllerTest {

    @MockBean
    private FilmRepository filmRepository;

    @Autowired
    private FilmController controller;

    private String spaceTitle = "2001 Space Odyssey";
    private Film spaceOdyssey = new Film(spaceTitle, "Stanley Kubrick", 1967, true);
    private Film goodfellas = new Film("Goodfellas", "Martin Scorsese", 1990, true);


    private List<Film> allFilms = new ArrayList<>();


    @Test
    public void findByTitleShouldReturnAFilmWithExpectedTitle() {
        given(filmRepository.findByTitle(spaceTitle)).willReturn(spaceOdyssey);

        Film result = controller.findByTitle(spaceTitle);

        assertEquals(spaceOdyssey, result);
    }

    @Test
    public void listFilmsShouldReturnAllFilmsFromMongoDB() {
        allFilms.add(spaceOdyssey);
        allFilms.add(goodfellas);

        given(filmRepository.findAll()).willReturn(allFilms);

        List<Film> result = controller.listFilms();

        assertEquals(allFilms, result);
    }
}
