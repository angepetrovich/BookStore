package org.example.dao;

import org.example.entity.Kategoria;
import org.example.entity.Ksiazka;

import java.util.List;

public interface CategoryDAO {
    public List<Kategoria> getCategories();

    public void saveCategory(Kategoria kategoria);
    public Kategoria getCategory(int id);
}
