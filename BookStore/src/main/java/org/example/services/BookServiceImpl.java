package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.dao.BookDAO;
import org.example.dao.CategoryDAO;
import org.example.entity.Kategoria;
import org.example.entity.Ksiazka;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Ksiazka> getBooks() {
        List<Ksiazka> books = bookDAO.getBooks();
        return books;
    }

    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka) {
        if (ksiazka.getId() != 0) {
            Ksiazka existingBook = bookDAO.getBook(ksiazka.getId());
            if (existingBook.getId() != 0) {
                existingBook.setNazwa(ksiazka.getNazwa());
                existingBook.setWydawnictwo(ksiazka.getWydawnictwo());
                existingBook.setCena(ksiazka.getCena());
                existingBook.setKategoria(ksiazka.getKategoria());
                existingBook.setAutorzy(ksiazka.getAutorzy());
                bookDAO.updateBook(existingBook);
            }
        } else {
            bookDAO.saveBook(ksiazka);
        }
    }

    @Override
    @Transactional
    public Ksiazka getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void updateBook(Ksiazka ksiazka) {
        bookDAO.updateBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    @Override
    @Transactional
    public Set<Ksiazka> getBooksInCart(Set<Integer> id) {
        return bookDAO.getBooksInCart(id);
    }
}
