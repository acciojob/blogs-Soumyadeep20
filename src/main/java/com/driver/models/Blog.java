package com.driver.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int userId;
    String title;
    String content;
    ArrayList<Integer> arr;
    Date PubDate;

    public Blog(){
        arr=new ArrayList<>();
    }
    public Blog(Integer userId, String title, String content) {
        this.content=content;
        this.title=title;
        this.userId=userId;
        this.id=(int)Math.random();
        this.arr=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return PubDate;
    }

    public void setPubDate(Date pubDate) {
        PubDate = pubDate;
    }

    public ArrayList<Integer> getImageList() {
        return arr;
    }

    public void setImageList(int x) {
        this.arr.add(x);
    }
}