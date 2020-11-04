package com.boa.api.response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class GenericResponse {

    protected String code;
    protected String description;
    protected Instant dateResponse;
    private Map<String, Object> data = new HashMap<>();

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDateResponse() {
        return this.dateResponse;
    }

    public void setDateResponse(Instant dateResponse) {
        this.dateResponse = dateResponse;
    }
    

    /**
     * @return Map<String, Object> return the data
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}