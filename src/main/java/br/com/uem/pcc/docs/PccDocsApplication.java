package br.com.uem.pcc.docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PccDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PccDocsApplication.class, args);
	}

}
