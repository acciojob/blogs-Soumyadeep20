package com.driver.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity

public class User{
    @Id
    int id;
    String ussername;
    String password;
    ArrayList<Integer> arr;
    public  User()
    {
        arr=new ArrayList<>();
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

    public String getUssername() {
        return ussername;
    }

    public void setUssername(String ussername) {
        this.ussername = ussername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Integer> getBlogList() {
        return arr;
    }

    public void setBlogList(int x) {
        this.arr.add(x);
    }
}