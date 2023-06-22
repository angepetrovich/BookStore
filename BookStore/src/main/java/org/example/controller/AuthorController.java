package org.example.controller;

import org.example.entity.Autor;
import org.example.entity.Kategoria;
import org.example.services.AuthorService;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Autor> autorzy = authorService.getAuthors();
        model.addAttribute("autorzy", autorzy);
        return "authorlist";
    }

    @GetMapping("/formadd")
    public String addForm(Model model)
    {
        Autor autor = new Autor();
        model.addAttribute("autor",autor);
        return "authorformadd";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("autorzy") Autor autor)
    {
        authorService.saveAuthor(autor);
        return "redirect:/authors/list";
    }

}
