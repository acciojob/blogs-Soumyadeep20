package com.driver.models;
import javax.persistence.*;
import java.util.ArrayList;

@Entity

public class User{
    @Id
    int id;
    String ussername;
    String password;
    @OneToMany(mappedBy = "user")
    ArrayList<Blog> arr;
    public User(){

    }
    public User(String x, String y){
        id= (int)Math.random();
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

    public ArrayList<Blog> getBlogList() {
        return arr;
    }

    public void setBlogList(Blog x) {
        this.arr.add(x);
    }
}