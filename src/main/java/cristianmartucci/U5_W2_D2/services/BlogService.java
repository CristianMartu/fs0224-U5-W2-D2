package cristianmartucci.U5_W2_D2.services;

import cristianmartucci.U5_W2_D2.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> getBlogsList(){
        return this.blogList;
    }

    public Blog saveBlog(Blog blog){
        blog.setId(new Random().nextInt(1,1000));
        this.blogList.add(blog);
        return blog;
    }
}
