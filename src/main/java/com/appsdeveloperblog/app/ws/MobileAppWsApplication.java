package com.appsdeveloperblog.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.appsdeveloperblog.app.ws.security.AppProperties;

@SpringBootApplication
public class MobileAppWsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MobileAppWsApplication.class);
	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext getSpringApplicationContext() {
		return new SpringApplicationContext();
	}

	@Bean
	public AppProperties getAppProperties() {
		return new AppProperties();
	}

}
