package com.rora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rora.model.Category;
import com.rora.service.CategoryService;

@Controller
public class CategoryController {
	
    private final CategoryService categoryService; 
    
    @Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public String showHomePage(Model model) {
		 List<Category> categories = categoryService.getAllCategories();
         model.addAttribute("categories", categories);
		return "categories";
	}

}
