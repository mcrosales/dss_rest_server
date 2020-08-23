package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Product;

@Path("/product")
public class ProductResource {
	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTestService() {
        return "Hello World! This is coming from webservice!!";
    }
    
    @GET
    @Path("/get_one")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct() {
        Product product = new Product(1, "NIKE SNEAKERS", 200.00, false);
        //ObjectMapper mapper = new ObjectMapper();
        return product;
    }

}
