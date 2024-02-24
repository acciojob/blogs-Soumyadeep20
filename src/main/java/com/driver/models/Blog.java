package com.driver.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int userid;
    String title;
    String content;
    ArrayList<Integer>imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public ArrayList<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(int x) {
        this.imageList.add(x);
    }

    public Blog(Integer userId, String title, String content) {
        this.content=content;
        this.title=title;
        this.userid=userId;
        imageList=new ArrayList<>();
    }
}