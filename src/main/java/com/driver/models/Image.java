package com.driver.models;
import javax.persistence.*;

@Entity

public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @JoinColumn
    @ManyToOne
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

    public int getBlog() {
        return blogid;
    }

    public void setBlog(int blogid) {
        this.blogid = blogid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimension;
    }

    public void setDimensions(String dimension) {
        this.dimension = dimension;
    }
}