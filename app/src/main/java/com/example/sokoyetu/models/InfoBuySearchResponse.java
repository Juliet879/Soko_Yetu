
package com.example.sokoyetu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class InfoBuySearchResponse {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("sources")
    @Expose
    private List<String> sources = null;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfoBuySearchResponse() {
    }

    /**
     * 
     * @param sources
     * @param data
     * @param query
     * @param results
     */
    public InfoBuySearchResponse(String query, Integer results, List<String> sources, List<Datum> data) {
        super();
        this.query = query;
        this.results = results;
        this.sources = sources;
        this.data = data;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
