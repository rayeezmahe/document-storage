package org.demo.documentstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DocumentStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentStorageApplication.class, args);
	}
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(DocumentStorageApplication.class);
	    }

}
