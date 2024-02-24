package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Image obj=new Image(blogId,description,dimensions);
        imageRepository2.save(obj);
        Blog x= blogRepository2.findById(blogId).orElse(null);
        x.setArr(blogId);
        blogRepository2.deleteById(blogId);
        blogRepository2.save(x);
        return obj;
        //add an image to the blog

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        return 0;

    }
}
