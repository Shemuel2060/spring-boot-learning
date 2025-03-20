package com.iona.springBoot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.iona.springBoot") // This makes the JVM recognize this as a spring boot application
/* The annotation consists of three annotaitons:
 * 1. @Confgiration
 * 2. @ComponentScan
 * 3. @EnableAutoConfiguration
 * 
 * Note here that we added an explicit scan base packages. If we don't want to do so, we whould
 * have our controllers in the same package as our class with the main(). So, we would move them
 * to com.iona.springBoot.starter.controllers, and other classes to scan.
 * 
 * But with the above, all classes within com.iona.springBoot will be detected.
 * 
 * */
public class StarterApp {

	public static void main(String[] args) {
		/* The following single line starts the application context
		 * and the application is ready to run and deploy
		 * */
		
		SpringApplication.run(StarterApp.class, args); // first argument should be the class with the main method
		/* *
		 * 1. Sets up the default configurations
		 * 2. Starts spring application context
		 * 3. Performs class path scan
		 * 4. Starts Tomcat server
		 */
	}

}
