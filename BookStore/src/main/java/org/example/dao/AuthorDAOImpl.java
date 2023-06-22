package org.example.dao;

import org.example.entity.Autor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Autor> getAuthors() {
        Session session = sessionFactory.getCurrentSession();
        Query<Autor> query = session.createQuery(" FROM Autor", Autor.class);
        List<Autor> authors = query.getResultList();
        return authors;
    }

    @Override
    public void saveAuthor(Autor author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

    @Override
    public Autor getAuthor(int author_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Autor.class, author_id);
    }
}
