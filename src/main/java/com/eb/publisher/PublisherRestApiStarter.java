package com.eb.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <h1>Publisher Rest Api Starter</h1> Spring boot starter class that launch
 * Rest API on embedded tomcat on default port 8080.
 * All the beans and configuration happen on the start on this class. 
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 *
 */
@SpringBootApplication
public class PublisherRestApiStarter {

	public static void main(String[] args) {
		SpringApplication.run(PublisherRestApiStarter.class, args);
	}
}
