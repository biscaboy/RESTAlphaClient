package com.udacity.jdnd.rest.RESTAlphaClient.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapperToMap {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void readJsonWithObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        Map empMap = null;
        try {
            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=CEF&interval=60min&adjusted=false&outputsize=compact&datatype=json&apikey=U39BYQB9UX8A24BH");
            empMap = objectMapper.readValue(url, Map.class);
        } catch (IOException ioException) {
            logger.error("Failed reading IO Stream", ioException);
        } catch (Exception e) {
            logger.error("We had some trouble with the JSON.", e);
        }
        if (empMap != null) {
            for (Object obj : empMap.entrySet()) {
                Map.Entry entry = (Map.Entry) obj;
                logger.info("\n----------------------------\n" + entry.getKey() + "=" + entry.getValue() + "\n");
            }
        }
    }
}
