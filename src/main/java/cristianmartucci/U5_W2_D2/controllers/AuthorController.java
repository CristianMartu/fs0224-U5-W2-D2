package cristianmartucci.U5_W2_D2.controllers;

import cristianmartucci.U5_W2_D2.entities.Author;
import cristianmartucci.U5_W2_D2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    private List<Author> getAllAuthor(){
        return this.authorService.getAuthorList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author saveAuthor(@RequestBody Author author){
        return this.authorService.saveAuthor(author);
    }

    @GetMapping("/{authorId}")
    private Author findById(@PathVariable UUID authorId){
        return this.authorService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author updateAuthor(@PathVariable UUID authorId, @RequestBody Author author){
        return this.authorService.updateAuthor(authorId, author);
    }

    @DeleteMapping("/{authorId}")
    private void deleteAuthor(@PathVariable UUID authorId){
        this.authorService.deleteAuthor(authorId);
    }
}
