package org.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.example.entity.Kategoria;
import org.example.entity.Ksiazka;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Kategoria> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Kategoria> query = currentSession.createQuery(" from Kategoria", Kategoria.class);
        List<Kategoria> kategorie= query.getResultList();
        return kategorie ;
    }

    @Override
    public void saveCategory(Kategoria kategoria) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(kategoria);
    }

    @Override
    public Kategoria getCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        Kategoria category = session.get(Kategoria.class,id);
        return category;
    }
}
