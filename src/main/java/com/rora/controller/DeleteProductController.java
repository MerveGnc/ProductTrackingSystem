package com.rora.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rora.model.Product;
import com.rora.service.ProductService;

@Controller
public class DeleteProductController {
	
	private final ProductService productService;
	
	public DeleteProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/delete-product")
	public String showDeletePage(){
		return "delete-product";
	}
	
	@GetMapping("/delete-by-name")
	public String showDeleteByNamePage(Model model){
		model.addAttribute("productToDelete",new Product());
		return "delete-by-name";
	}
	
	@PostMapping("/delete-by-name")
	public String deleteByName(@ModelAttribute("productToDelete")Product productToDelete) {
		productService.deleteProductByName(productToDelete.getName());
		return "redirect:/products";
	}
	
	@GetMapping("/delete-by-id")
	public String showDeleteByIdPage(Model model){
		model.addAttribute("productToDelete",new Product());
		return "delete-by-id";
	}
	
	@PostMapping("/delete-by-id")
	public String DeleteById(@ModelAttribute("productToDelete")Product productToDelete){
		productService.deleteProductById(productToDelete.getId());
		return "redirect:/products";
	}
	
	@GetMapping("/delete-by-selection")
	public String showDeleteBySelectionPage(Model model){
		 List<Product> products = productService.getAllProducts();
         model.addAttribute("products", products);
		return "delete-by-selection";
	}
	
	@PostMapping("/deleteSelectedProducts")
    public String deleteSelectedProducts(@RequestParam("selectedProducts") List<Long> selectedProducts) {
        if (selectedProducts != null && !selectedProducts.isEmpty()) {
            for (Long productId : selectedProducts) {
                productService.deleteProductById(productId);
            }
            return "redirect:/delete-by-selection";
        } else {
            return "No products selected for deletion.";
        }
    }


}
