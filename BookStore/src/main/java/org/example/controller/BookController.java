package org.example.controller;

import org.example.dao.BookDAO;
import org.example.dto.BookDTO;
import org.example.entity.Autor;
import org.example.entity.Kategoria;
import org.example.services.AuthorService;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Ksiazka;
import org.example.services.BookService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookDAO bookDAO;

    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Ksiazka> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }

    @GetMapping("/formadd")
    public String addForm(Model model)
    {
        BookDTO bookDTO = new BookDTO();
        List<Autor> authors = authorService.getAuthors();

        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authors);

        return "addbookform";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("bookDTO") BookDTO bookDTO)
    {
        int id = bookDTO.getId();
        Ksiazka ksiazka = bookService.getBook(id);
        if(ksiazka == null){
            ksiazka = new Ksiazka();
        }

        Kategoria category = categoryService.getCategory(bookDTO.getKategoriaid());
        ksiazka.setKategoria(category);
        ksiazka.setNazwa(bookDTO.getNazwa());
        ksiazka.setWydawnictwo(bookDTO.getWydawnictwo());
        ksiazka.setCena(bookDTO.getCena());

        Set<Autor> authors = new HashSet<>();
        if(bookDTO.getAutorzy() != null){
            for(Integer autorId: bookDTO.getAutorzy()){
                Autor autor = authorService.getAuthor(autorId);
                if (autor != null) {
                    authors.add(autor);
                }
            }
            ksiazka.setAutorzy(authors);
        }

        bookService.saveBook(ksiazka);
        return "redirect:/books/list";
    }

    @GetMapping("/updateBookForm")
    public String updateBookForm(@RequestParam("bookId") int bookId, Model model) {
        Ksiazka ksiazka = bookService.getBook(bookId);
        List<Kategoria> categories = categoryService.getCategories();
        List<Autor> authors = authorService.getAuthors();
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(ksiazka.getId());
        bookDTO.setNazwa(ksiazka.getNazwa());
        bookDTO.setWydawnictwo(ksiazka.getWydawnictwo());
        bookDTO.setCena(ksiazka.getCena());
        bookDTO.setKategoriaid(ksiazka.getKategoria().getId());
        List<Integer> selectedAuthors = new ArrayList<>();
        for (Autor autor : ksiazka.getAutorzy()) {
            selectedAuthors.add(autor.getId());
        }
        bookDTO.setAutorzy(selectedAuthors);

        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categories);
        model.addAttribute("currentCategoryId", ksiazka.getKategoria().getId());
        model.addAttribute("authors", authors);

        return "updateBookForm";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/list";
    }
}
