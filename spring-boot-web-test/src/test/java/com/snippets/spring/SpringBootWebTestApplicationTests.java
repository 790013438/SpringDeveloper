package com.snippets.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(classes = SpringBootWebTestApplication.class)
@WebAppConfiguration
public class SpringBootWebTestApplicationTests {

    @Test
    public void contextLoads() {
    }

}
