package com.udacity.jdnd.rest.RESTAlphaClient;

import com.udacity.jdnd.rest.RESTAlphaClient.entity.Intraday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestAlphaClientApplication {

	private static final Logger log = LoggerFactory.getLogger(RestAlphaClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestAlphaClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Intraday intraday = restTemplate.getForObject(
					"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=CEF&interval=60min&apikey=U39BYQB9UX8A24BH",
					Intraday.class);
			log.info(intraday.toString());
		};
	}

}
