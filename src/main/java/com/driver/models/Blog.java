package com.driver.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    User user;
    String title;
    String content;
    Date pub;
    @OneToMany(mappedBy = "blog")
    ArrayList<Image>imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(Image x) {
        this.imageList.add(x);
    }

    public Date getPubDate() {
        return pub;
    }

    public void setPubDate(Date pub) {
        this.pub = pub;
    }

    public Blog() {
    }

    public Blog(String title, String content) {
        this.content=content;
        this.title=title;
        imageList=new ArrayList<>();
    }
}