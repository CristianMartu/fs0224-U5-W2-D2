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

    public Blog findById(int id){
        Blog blog = this.blogList.stream().filter(element -> element.getId()==id).toList().getFirst();
        if(blog == null) throw new RuntimeException("Nessun blog trovato con id: " + id);
        return blog;
    }

    public Blog updateBlog(int id, Blog updateBlog){
        Blog blog = findById(id);
        blog.setCategoria(updateBlog.getCategoria());
        blog.setTitolo(updateBlog.getTitolo());
        blog.setCover(updateBlog.getCover());
        blog.setContenuto(updateBlog.getContenuto());
        blog.setTempoDiLettura(updateBlog.getTempoDiLettura());
        return blog;
    }

    public void deleteBlog(int id){
        this.blogList.remove(findById(id));
    }


}
