package com.example.facebook.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    String text;
    int image;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd ,yyyy");
    Date dateTime = new Date();
    String date = dateFormat.format(dateTime);

    public Post(String text) {
        this.text = text;
    }

    public Post(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
