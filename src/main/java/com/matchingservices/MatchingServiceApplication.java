package com.matchingservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages ="com.matchingservices")
@ImportResource({"classpath:configOracleDao.xml"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class})
@SpringBootApplication

public class MatchingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchingServiceApplication.class, args);
	}

}
