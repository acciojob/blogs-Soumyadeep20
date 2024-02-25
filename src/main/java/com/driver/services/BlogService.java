package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        obj.setUser(x);
        x.setBlogList(obj);
        userRepository1.deleteById(userId);
        userRepository1.save(x);
        blogRepository1.save(obj);

        return obj;
        //create a blog at the current time

    }

    public void deleteBlog(int blogId){
        Blog x= blogRepository1.findById(blogId).orElse(null);
        ArrayList<Image> arr=x.getImageList();
        for(int i=0;i<arr.size();i++)
        {
            ir.deleteImage(arr.get(i).getId());
        }
        blogRepository1.deleteById(blogId);

        //delete blog and corresponding images

    }
}
