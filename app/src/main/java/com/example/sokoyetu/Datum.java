
package com.example.sokoyetu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("source")
    @Expose
    private String source;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param condition
     * @param thumb
     * @param price
     * @param name
     * @param source
     * @param url
     */
    public Datum(String name, Integer price, String url, String condition, String thumb, String source) {
        super();
        this.name = name;
        this.price = price;
        this.url = url;
        this.condition = condition;
        this.thumb = thumb;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
