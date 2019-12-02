package br.com.ficticiusClean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"br.com.ficticiusClean.services"})
@SpringBootApplication
public class FicticiusCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicticiusCleanApplication.class, args);
	}

}
