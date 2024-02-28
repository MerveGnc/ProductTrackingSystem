package  com.rora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rora.model.Product;
import com.rora.service.ProductService;

@Controller
public class ProductController {
	
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
    	 List<Product> products = productService.getAllProducts();
         model.addAttribute("products", products);
         return "products";
    }
 
    
    @GetMapping("/update-product")
    public String showUpdateProductPage(@RequestParam("productId") Long productId,Model model) {
    	Optional<Product> optionalProduct = productService.getProductById2(productId);
        if (optionalProduct.isPresent()) {
            model.addAttribute("product", optionalProduct.get());
            return "update-product-form";
        } else {
            return "error-page";
        }
    }
    
    @PostMapping("/update-product")
    public String updateSelectedProducts(@RequestParam("productId") Long productId, Product updatedProduct) {
        productService.updateProduct(productId, updatedProduct);
        return "redirect:/products";
    }
    
    
    @GetMapping("/update")
    public String showProductManagementPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "update-product";
    }
}




