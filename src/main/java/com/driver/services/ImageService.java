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
        Blog m=blogRepository2.findById(blogId).orElse(null);
        if(m==null)
            return null;
        obj.setBlog(m);

        List<Image> arr=m.getImageList();
        arr.add(obj);
        m.setImageList(arr);

        blogRepository2.save(m);

        return obj;
        //add an image to the blog

    }

    public void deleteImage(Integer id){
        Image x=imageRepository2.findById(id).orElse(null);
        if(x==null)
            return;
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        Image x=imageRepository2.findById(id).orElse(null);
        if(x==null)
            return 0;

        String  arr[]=(x.getDimensions().split("X",2));
        int a=Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);

        String  arr2[]=(screenDimensions.split("X",2));
        int b=Integer.parseInt(arr2[0])*Integer.parseInt(arr2[1]);
        int c=0;
       if(a!=0)
          c=b/a;


        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        return c;

    }
}
