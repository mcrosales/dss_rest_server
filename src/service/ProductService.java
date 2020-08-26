package service;

import java.util.List;

import javax.persistence.EntityManager;
import model.*;
import repository.ProductRepository;
import util.EntityManagerUtil;

public class ProductService {

	private ProductRepository productRepository;

	public ProductService() {
		super();
		this.productRepository = new ProductRepository();
	}

	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			product = productRepository.create(product);
		} else {
			product = productRepository.update(product);
		}
		return product;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public boolean delete(Integer id) {
		return productRepository.delete(id);
	}

}
