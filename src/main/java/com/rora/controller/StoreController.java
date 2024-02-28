package com.rora.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rora.model.Store;
import com.rora.service.StoreService;

@Controller
public class StoreController {
	
	private final StoreService storeService;

	
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@GetMapping("/store")
	public String showStorePage(Model model) {	
		List<Store> stores= storeService.getAllStores();
		model.addAttribute("stores",stores);
		return "store";
	}

}
