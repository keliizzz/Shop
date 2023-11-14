package ua.project.buyers;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ua.project.buyers.dao.DAOConfig;

@SpringBootApplication
@EnableConfigurationProperties({DAOConfig.class})
public class Practice6Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice6Application.class, args);
	}

}
