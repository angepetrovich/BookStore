package org.example.controller;

import org.example.entity.Cart;
import org.example.entity.Ksiazka;
import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/cart")
public class CartController {
    private Cart cart;
    private BookService bookService;

    @Autowired
    public CartController(Cart cart, BookService bookService) {
        this.cart = cart;
        this.bookService = bookService;
    }

    @GetMapping
    public String cart(Model model) {
        Set<Ksiazka> cartBooks = bookService.getBooksInCart(cart.getBookIds());
        model.addAttribute("books", cartBooks);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam(name = "bookId") int id) {
        cart.addBookId(id);
        return "redirect:/cart";
    }

    @PostMapping("/delete")
    public String removeFromCart(@RequestParam("bookId") int id) {
        cart.deleteBookId(id);
        return "redirect:/cart";
    }


}
