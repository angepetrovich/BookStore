package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.entity.Kategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Kategoria> getCategories() {
        List<Kategoria> categories = categoryDAO.getCategories();
        return categories;
    }

    @Override
    @Transactional
    public Kategoria getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void saveCategory(Kategoria category) {
        categoryDAO.saveCategory(category);
    }
}
