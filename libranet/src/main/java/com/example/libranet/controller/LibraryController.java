package com.example.libranet.controller;

import com.example.libranet.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("items", libraryService.getAllItems());
        return "index";
    }
    
    @PostMapping("/borrow")
    public String handleBorrow(@RequestParam("itemId") int itemId, RedirectAttributes redirectAttributes) {
        String message = libraryService.borrowItem(itemId);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @PostMapping("/return")
    public String handleReturn(@RequestParam("itemId") int itemId, RedirectAttributes redirectAttributes) {
        String message = libraryService.returnItem(itemId);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}