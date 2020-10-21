package com.udacity.jdnd.rest.RESTAlphaClient;

import com.udacity.jdnd.rest.RESTAlphaClient.entity.Intraday;
import com.udacity.jdnd.rest.RESTAlphaClient.entity.IntradayData;
import com.udacity.jdnd.rest.RESTAlphaClient.entity.ObjectMapperToMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@SpringBootTest
class RestAlphaClientApplicationTests {

	@Autowired
	RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Test
	void contextLoads() {
		RestTemplate restTemplate = builder.build();

		String symbol = "AMZN";

		Intraday intraday = restTemplate.getForObject(
				"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=60min&apikey=U39BYQB9UX8A24BH",
				Intraday.class);

		Assertions.assertEquals(symbol, intraday.getIntradayMetaData().getSymbol());
		System.out.println("Symbol: " + symbol );

		for (Object obj : intraday.getIntradayTimeSeries60().getSeries().entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println("Date: " + entry.getKey());
			IntradayData data = (IntradayData)entry.getValue();
			System.out.println(data);
		}
	}

	@Test
	void objectMapper() {

		ObjectMapperToMap mapper = new ObjectMapperToMap();
		mapper.readJsonWithObjectMapper();
	}

}
