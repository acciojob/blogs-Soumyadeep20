package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;
    @Autowired
    ImageService ir;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        Blog obj=new Blog(title,content);
        User x= userRepository1.findById(userId).orElse(null);
        if(x==null) {
            x = new User(userId);
            userRepository1.save(x);
        }

        obj.setUser(x);
        List<Blog> arr=x.getBlogList();
        arr.add(obj);
        x.setBlogList(arr);
       userRepository1.save(x);

        return obj;
        //create a blog at the current time

    }

    public void deleteBlog(int blogId){
        Blog x= blogRepository1.findById(blogId).orElse(null);
        if(x==null)
            return;
        blogRepository1.deleteById(blogId);

        //delete blog and corresponding images

    }
}
