package com.naresh.cybershopping.dbservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.naresh.cybershopping.dbservice.document.Users;
import com.naresh.cybershopping.dbservice.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses =UserRepository.class) 
@Configuration
public class MongoDBConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				userRepository.save(new Users(1,"John"));
				userRepository.save(new Users(2,"Smith"));
				userRepository.save(new Users(3,"Craig"));
			}
			
		};
	}

}
