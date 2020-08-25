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

	public void saveProduct(Product product) {
		if (product.getId() == null) {
			productRepository.create(product);
		} else {
			productRepository.update(product);
		}
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
