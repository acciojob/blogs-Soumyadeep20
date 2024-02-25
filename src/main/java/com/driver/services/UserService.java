package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    BlogService bs;
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User obj= new User(username,password);
        userRepository3.save(obj);
        return obj;


    }

    public void deleteUser(int userId){
        User obj=userRepository3.findById(userId).orElse(null);
        ArrayList<Blog> arr=obj.getBlogList();
        for(int i=0;i<arr.size();i++)
        {
            bs.deleteBlog(arr.get(i).getId());
        }
        userRepository3.deleteById(userId);

    }

    public User updateUser(Integer id, String password){
        User obj=userRepository3.findById(id).orElse(null);
        userRepository3.deleteById(id);
        obj.setPassword(password);
        userRepository3.save(obj);
        return obj;
        

    }
}
