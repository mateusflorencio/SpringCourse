package com.florencio.springcourse.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.florencio.springcourse.services.DBService;
import com.florencio.springcourse.services.EmailService;
import com.florencio.springcourse.services.MockEmailService;
import com.florencio.springcourse.services.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	public DBService dbService;
	
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
@Bean
	public EmailService emailService(){
		return new MockEmailService();
	}

}
