package com.rora.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rora.model.Category;
import com.rora.model.Product;
import com.rora.service.CategoryService;
import com.rora.service.ProductService;

@Controller
public class NewProductController {
	
    private final ProductService productService;
    private final CategoryService categoryService;

	public NewProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping("/new-product")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "new-product";
    }
	
	@PostMapping("/new-product")
		public String saveNewProduct(@ModelAttribute("product") Product product,@RequestParam("categoryId") Long categoryId) {
	        Category category = categoryService.findCategoryById(categoryId);
	        product.setCategory(category);
		    productService.saveProduct(product);
			return "redirect:/products";
		}
	}
