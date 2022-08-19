package com.example.newsapp6;

public class Modalclass {
    private String author,title,description,url,urltoimage,publishat;

    public Modalclass(String author, String title, String description, String url, String urltoimage, String publishat) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urltoimage = urltoimage;
        this.publishat = publishat;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    public String getPublishat() {
        return publishat;
    }

    public void setPublishat(String publishat) {
        this.publishat = publishat;
    }
}
