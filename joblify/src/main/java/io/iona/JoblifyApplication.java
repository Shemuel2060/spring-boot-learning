package io.iona;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoblifyApplication implements CommandLineRunner, ApplicationRunner{

	@Override
	public void run(String... args) throws Exception {
		// logic to run immediate after boot app start up
		System.out.println("Hello from command line runner");
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JoblifyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// logic to run immediate after boot app start up
		System.out.println("Hello from ApplicationRunner");
		
		/* Logic here runs before the logic in the command line runner */
		
	}

}

/* 
 * Runners can be used to run any logic just immediately after 
 * application start up but before services and business using.
 * There are two types of Runners: CommanLineRunner and 
 * ApplicationRunner. The latter gives more control.
 * 
 * This can be used to pull resources from external APIs, or 
 * databases. There are two ways of using Runners:
 * 1. implementing them in this entry class
 * 2. implementing them in a bean of choice
 * 
 * 
 * */
 