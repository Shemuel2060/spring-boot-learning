package io.iona.joblify.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component // spring automatically creates the bean.
public class Runner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// logic to run immediate after boot app start up
		System.out.println("Hello from ApplicationRunner in a bean");
		
		/* The logic here runs when this bean is created by spring.
		 * */
		
	}

}
