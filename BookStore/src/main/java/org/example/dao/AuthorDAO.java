package org.example.dao;

import org.example.entity.Autor;

import java.util.List;

public interface AuthorDAO {

    public List<Autor> getAuthors();
    public void saveAuthor(Autor author);
    public Autor getAuthor(int author_id);
}
