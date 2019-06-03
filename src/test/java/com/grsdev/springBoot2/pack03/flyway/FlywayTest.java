package com.grsdev.springBoot2.pack03.flyway;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.System.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlywayTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Test
    public void flyShouldCreateTable(){

        out.println(jdbc.queryForMap("select * from PUBLIC.USER"));
    }

}
