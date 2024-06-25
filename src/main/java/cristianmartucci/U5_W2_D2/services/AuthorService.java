package cristianmartucci.U5_W2_D2.services;

import cristianmartucci.U5_W2_D2.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList(){
        return this.authorList;
    }

    public Author saveAuthor(Author author){
        author.setId(UUID.randomUUID());
        author.setAvatar("https://ui-avatars.com/api/?name=" + author.getNome() + "+" + author.getCognome());
        this.authorList.add(author);
        return author;
    }

    public Author findById(UUID authorId){
        Author author = this.authorList.stream().filter(element -> element.getId().equals(authorId)).toList().getFirst();
        if (author == null) throw new RuntimeException("Nessun autore trovato con id: " + authorId);
        return author;
    }

    public Author updateAuthor(UUID authorId, Author updateAuthor){
        Author author = findById(authorId);
        author.setNome(updateAuthor.getNome());
        author.setCognome(updateAuthor.getCognome());
        author.setEmail(updateAuthor.getEmail());
        author.setDataDiNascita(updateAuthor.getDataDiNascita());
        author.setAvatar("https://ui-avatars.com/api/?name=" + updateAuthor.getNome() + "+" + updateAuthor.getCognome());
        return author;
    }

    public void deleteAuthor(UUID authorId){
        this.authorList.remove(findById(authorId));
    }

}
