package cristianmartucci.U5_W2_D2.controllers;

import cristianmartucci.U5_W2_D2.entities.Blog;
import cristianmartucci.U5_W2_D2.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    private List<Blog> getAllBlog(){
        return this.blogService.getBlogsList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Blog saveBlog(@RequestBody Blog blog){
        return this.blogService.saveBlog(blog);
    }

    @GetMapping("/{blogId}")
    private Blog findById(@PathVariable int blogId){
        return this.blogService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    private Blog updateBlog(@PathVariable int blogId, @RequestBody Blog blog){
        return this.blogService.updateBlog(blogId, blog);
    }

    @DeleteMapping("/{blogId}")
    private void deleteBlog(@PathVariable int blogId){
        this.blogService.deleteBlog(blogId);
    }
}
