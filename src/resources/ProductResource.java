package resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Product;
import model.Todo;
import repository.ProductRepository;
import service.ProductService;

@Path("/product")
public class ProductResource {

	private ProductService productService;

	public ProductResource() {
		super();
		this.productService = new ProductService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Product> getProducts() {
		return productService.findAll();
	}

	@GET
	@Path("/get_base_data")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getInitialProducts() {

		// create new product
		Product product = new Product();
		product.setName("Laptop");
		product.setPrice(400.00);
		productService.saveProduct(product);
		return productService.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Product product) throws URISyntaxException {
		product = productService.saveProduct(product);
		return Response.created(new URI("/rest/products/" + product.getId())).entity(product).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, Product product) throws URISyntaxException {
		product.setId(id);
		product = productService.saveProduct(product);
		return Response.ok().entity(product).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws URISyntaxException {
		productService.delete(id);
		return Response.ok().entity("Product deleted successfully !!").build();
	}

}
