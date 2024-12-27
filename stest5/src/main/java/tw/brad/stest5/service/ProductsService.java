package tw.brad.stest5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.brad.stest5.model.Products;
import tw.brad.stest5.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> getProducts(){
		return productsRepository.findAll();
	}
	
	
}
