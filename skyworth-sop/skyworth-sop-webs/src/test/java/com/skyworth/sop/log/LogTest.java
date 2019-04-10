package com.skyworth.sop.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(LogTest.class);
    private static final Logger logger= LoggerFactory.getLogger("TEST_LOG");
    @Test
    public void testLog() {
    	LOGGER.info("this is a info message!");
    	LOGGER.error("this is a error message!");
    	logger.info("this is a test_log info message");
    }

    
}
