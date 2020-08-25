package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Product;
import model.Todo;
import util.EntityManagerUtil;

public class ProductRepository {

	private EntityManager em;

	public List<Product> findAll() {
		em = EntityManagerUtil.getEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select t from Product t");
		List<Product> productList = q.getResultList();
		for (Product product : productList) {
			System.out.println(product);
		}
		System.out.println("Size: " + productList.size());
		em.close();
		return productList;
	}

	public Product create(Product product) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		return product;
	}

	public Product update(Product product) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		em.close();
		return product;
	}

	public Product findById(Integer id) {
		return null;
	}

	public boolean delete(Integer id) {
		return true;
	}

}
