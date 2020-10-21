package com.udacity.jdnd.rest.RESTAlphaClient.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class IntradayTimeSeries60 {

    private Map<String, IntradayData> series;

    public IntradayTimeSeries60() {}

    @JsonAnyGetter
    public Map<String, IntradayData> getSeries() {
        return series;
    }

    @JsonAnySetter
    public void addData(String time, IntradayData data) {

        if (this.series == null) {
            this.series = new HashMap<>();
        }
        this.series.put(time, data);
    }

    @Override
    public String toString() {
        return "IntradayTimeSeries60{" +
                "series=" + series +
                '}';
    }
}
