package com.cztek.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    @Test
    public void Test(){
        log.debug("debug..........");
        log.info("info...........");
        log.error("error..........");
    }
}
