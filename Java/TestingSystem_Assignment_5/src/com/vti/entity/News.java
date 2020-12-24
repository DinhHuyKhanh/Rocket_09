package com.vti.entity;

import com.sun.org.glassfish.external.statistics.AverageRangeStatistic;

public class News implements INews {
//    ID (int), Title (String), PublishDate (String), Author (String),
//    Content (String) và AverageRate (float).
    private  int id;
    private String title;
    private String publishDate,author,content;
    private float averageRate;
    private  int[] rates;

    public News(int ID, String Title, String PublishDate, String Author, String Content){
        this.id = ID;
        this.title = Title;
        this.publishDate = PublishDate;
        this.author = Author;
        this.content = Content;
    }
    public News(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public int[] getRates() {
        return rates;
    }

    public void setRates(int[] rates) {
        this.rates = rates;
    }
    @Override
    public void Display() {
        System.out.println("Title :" + getTitle());
        System.out.println("Publish Date :" + getPublishDate());
        System.out.println("Author :" + getAuthor());
        System.out.println("Content :" + getContent());
        System.out.println("AverageRate :" + getAverageRate());
    }
    @Override
    public float Calculate() {
        averageRate = (float)(rates[0] + rates[1]+rates[2])/3;
    return averageRate;
    }


}
