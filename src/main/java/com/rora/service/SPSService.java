package com.rora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rora.model.Product;
import com.rora.model.StoreProductStock;
import com.rora.repository.SPSRepository;

@Service
public class SPSService {
	
	private final SPSRepository  sPSRepository;
	
	
	@Autowired
	public SPSService(SPSRepository sPSRepository) {
		this.sPSRepository = sPSRepository;
	}
	
	  public List<StoreProductStock> getAllStocks() {
	        return  sPSRepository.findAll();
	    }
	  
	  public Optional<StoreProductStock> getStockById(Long id) {
		 return sPSRepository.findById(id);
	  }
	  
	  public void updateStock(Long stockId, StoreProductStock updatedStock) {
	        Optional<StoreProductStock>  optionalStock = sPSRepository.findById(stockId);
	        if (optionalStock.isPresent()) {
	        	StoreProductStock storeProductStock = optionalStock.get();
	        	storeProductStock.setStockQuantity(updatedStock.getStockQuantity());
	        	sPSRepository.save(storeProductStock); 
	        } else {
	            // Hata işlemleri veya yönlendirme yapılabilir
	        }
	  }
	        

}
	  
