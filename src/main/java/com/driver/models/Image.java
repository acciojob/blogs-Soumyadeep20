package com.driver.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int blogid;
    String description;
    String dimension;

    public Image(){

    }
    public Image(int blogid, String description, String dimension) {
        this.id=(int)Math.random();
        this.blogid = blogid;
        this.description = description;
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}