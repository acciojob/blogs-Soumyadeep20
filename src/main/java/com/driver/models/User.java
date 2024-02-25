package com.driver.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User{
    @Id
    int id;
    String ussername;
    String password;
    @OneToMany(mappedBy = "user")
    List<Blog> arr;
    public User(){

    }
    public User(String x, String y){
        this.id=(int)(Math.random()*10000);

        ussername=x;
        password=y;
        arr=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return ussername;
    }

    public void setUsername(String ussername) {
        this.ussername = ussername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return arr;
    }

    public void setBlogList(Blog x) {
        this.arr.add(x);
    }
}