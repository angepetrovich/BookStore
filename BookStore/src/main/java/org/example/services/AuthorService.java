package org.example.services;

import org.example.entity.Autor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorService {

    List<Autor> getAuthors();

    public void saveAuthor(Autor autor);

    Autor getAuthor(int id);

}
