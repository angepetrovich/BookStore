package org.example.services;

import org.example.dao.AuthorDAO;
import org.example.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Autor> getAuthors() {
        return authorDAO.getAuthors();
    }

    @Override
    @Transactional
    public void saveAuthor(Autor autor) {
        authorDAO.saveAuthor(autor);
    }

    @Override
    @Transactional
    public Autor getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

}
