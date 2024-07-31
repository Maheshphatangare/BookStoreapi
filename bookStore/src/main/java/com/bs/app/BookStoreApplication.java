package com.bs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableAutoConfiguration

@ComponentScan(basePackages={"com.bs.repository", "com.bs.controller","com.bs.service"})
@EnableJpaRepositories(basePackages="com.bs.repository")
//@EnableTransactionManagement
@EntityScan(basePackages={"com.bs.entity"})

//@ComponentScan(basePackages = "com.smart.repo")

//(scanBasePackages={
//"com.smart.repo", "com.smart.controller","com.smart.entities"})
@SpringBootApplication//(exclude =  {DataSourceAutoConfiguration.class })
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
