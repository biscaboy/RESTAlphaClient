package com.udacity.jdnd.rest.RESTAlphaClient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Intraday {

    @JsonProperty("Meta Data")
    private IntradayMetaData intradayMetaData;

    @JsonProperty("Time Series (60min)")
    private IntradayTimeSeries60 intradayTimeSeries60;

    public Intraday() {}

    public Intraday(IntradayMetaData intradayMetaData, IntradayTimeSeries60 intradayTimeSeries60) {
        this.intradayMetaData = intradayMetaData;
        this.intradayTimeSeries60 = intradayTimeSeries60;
    }

    public IntradayMetaData getIntradayMetaData() {
        return intradayMetaData;
    }

    public void setIntradayMetaData(IntradayMetaData intradayMetaData) {
        this.intradayMetaData = intradayMetaData;
    }

    public IntradayTimeSeries60 getIntradayTimeSeries60() {
        return intradayTimeSeries60;
    }

    public void setIntradayTimeSeries60(IntradayTimeSeries60 intradayTimeSeries60) {
        this.intradayTimeSeries60 = intradayTimeSeries60;
    }

    @Override
    public String toString() {
        return "Intraday{" +
                "intradayMetaData=" + intradayMetaData +
                ", intradayTimeSeries60=" + intradayTimeSeries60 +
                '}';
    }
}
