package org.example.services;

import org.example.entity.Kategoria;

import java.util.List;

public interface CategoryService {

    List<Kategoria> getCategories();

    Kategoria getCategory(int id);

    public void saveCategory(Kategoria category);
}
