package com.springbasics.BasicSpringAppln;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.springbasics.BasicSpringAppln.scope.PersonDAO;

@SpringBootApplication
public class BasicSpringScopeApplication {
	
	private static Logger logger = LoggerFactory.getLogger(BasicSpringScopeApplication.class);

	public static void main(String[] args) {		

		ApplicationContext applicationContext = SpringApplication.run(BasicSpringScopeApplication.class, args);
		
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		logger.info("{}", personDAO);
		logger.info("{}", personDAO.getJdbcConnection());
		
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		logger.info("{}", personDAO2);
		logger.info("{}", personDAO2.getJdbcConnection());

	}

}
