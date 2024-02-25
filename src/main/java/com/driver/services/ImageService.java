package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Image obj=new Image(description,dimensions);
        obj.setBlog(blogRepository2.findById(blogId).orElse(null));
        imageRepository2.save(obj);
        Blog x= blogRepository2.findById(blogId).orElse(null);
        List<Image> arr=x.getImageList();
        arr.add(obj);
        x.setImageList(arr);
        blogRepository2.deleteById(blogId);
        blogRepository2.save(x);
        return obj;
        //add an image to the blog

    }

    public void deleteImage(Integer id){
        Image x=imageRepository2.findById(id).orElse(null);
        Blog b=x.getBlog();
        List<Image> arr1=b.getImageList();
        for(int i=0;i<arr1.size();i++)
        {
            if(arr1.get(i)==x)
                arr1.remove(i);
        }
        b.setImageList(arr1);
        blogRepository2.deleteById(x.getBlog().getId());

        blogRepository2.save(b);

        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        Image x=imageRepository2.findById(id).orElse(null);
        String  arr[]=(x.getDimensions().split("x"));
        int a=Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
        String  arr2[]=(screenDimensions.split("x"));
        int b=Integer.parseInt(arr2[0])*Integer.parseInt(arr2[1]);
        int c=0;
       // if(a!=0)
         //   c=b/a;


        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        return c;

    }
}
