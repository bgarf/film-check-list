package com.projects.films.data;

import com.mongodb.Mongo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class FilmRepositoryTest {

    @Autowired
    public FilmRepository filmRepository;

    public Mongo mongo;

    @Before
    public void mongoSetup() {

    }


    @Test
    public void findByTitle() {

    }
}
