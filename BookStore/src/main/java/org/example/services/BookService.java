package org.example.services;

import org.example.entity.Ksiazka;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Ksiazka> getBooks();

    public void saveBook(Ksiazka ksiazka);
    Ksiazka getBook(int id);

    public void updateBook(Ksiazka ksiazka);

    void deleteBook(int id);

    Set<Ksiazka> getBooksInCart(Set<Integer> id);
}
