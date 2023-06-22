package org.example.controller;

import org.example.entity.Kategoria;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model model) {
        List<Kategoria> kategorie = categoryService.getCategories();
        model.addAttribute("kategorie", kategorie);
        return "categorieslist";
    }

    @GetMapping("/formadd")
    public String showAddCategoryForm(Model model) {
        Kategoria kategoria = new Kategoria();
        model.addAttribute("kategoria", kategoria);
        return "addcategoryform";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("kategoria") Kategoria kategoria) {
        categoryService.saveCategory(kategoria);
        return "redirect:/categories/list";
    }
}
