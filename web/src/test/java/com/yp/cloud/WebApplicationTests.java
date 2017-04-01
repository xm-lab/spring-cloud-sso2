package com.yp.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

	@Autowired
	private Environment env;

	@Test
	public void contextLoads() {
		System.err.println("**********************************");
		System.err.println("profiles: "+env.getProperty("spring.profiles.active"));
		System.err.println("**********************************");
	}

}
