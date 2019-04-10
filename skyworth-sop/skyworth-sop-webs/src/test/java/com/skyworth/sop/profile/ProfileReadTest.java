package com.skyworth.sop.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.skyworth.sop.profile.other.PropertiesConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileReadTest {

    
    @Autowired  
    private Environment env;
    
    @Value("${spring.profiles.active}")
    private String active;
    
    @Autowired
    private PropertiesConfig propertiesConfig;
	
    @Test
    public void testProfile() {
    	//1.env
    	System.out.println("spring.profiles.active="+env.getProperty("spring.profiles.active"));
    	//2.active
    	System.out.println("spring.profiles.active="+active);
    	//3.properties
    	System.out.println("spring.profiles.active="+propertiesConfig.getActive());
    	
    }

    
}
