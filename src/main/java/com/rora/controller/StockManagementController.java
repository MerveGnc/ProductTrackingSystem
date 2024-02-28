package com.rora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rora.model.Product;
import com.rora.model.StoreProductStock;
import com.rora.service.SPSService;

@Controller
public class StockManagementController {
	
	private final SPSService sPSService;
	
	@Autowired
	public StockManagementController(SPSService sPSService) {
		this.sPSService = sPSService;
	}

	@GetMapping("/stockManagement")
	public String showSManagementPage(Model model) {
	List<StoreProductStock> stocks=sPSService.getAllStocks();
	 model.addAttribute("stocks", stocks);
		return "stockManagement";
	}
	@GetMapping("/update-stock")
	public String showSUpdatePage(@RequestParam("stockId") Long stockId,Model model ) {
		Optional<StoreProductStock> optionalStock= sPSService.getStockById(stockId);
		 if (optionalStock.isPresent()) {
		        model.addAttribute("stock", optionalStock.get());
		        return "update-stock";
		    } else {
		        return "error-page";
		    }	
	}

	
	@PostMapping("/update-stock")
	public String updateStock(@RequestParam("stockId") Long stockId, StoreProductStock updatedStock) {
		sPSService.updateStock(stockId, updatedStock);
		return "redirect:/stockManagement";
	}


}

