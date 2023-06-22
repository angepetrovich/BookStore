package org.example.dao;

import org.example.entity.Ksiazka;


import java.util.List;
import java.util.Set;

public interface BookDAO {
    public List<Ksiazka> getBooks();

    public void saveBook(Ksiazka ksiazka);

    public void updateBook(Ksiazka ksiazka);
    public Ksiazka getBook(int id);

    public void deleteBook(int id);

    public Set<Ksiazka> getBooksInCart(Set<Integer> id);
}
