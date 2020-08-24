package resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.Todo;
import util.EntityManagerUtil;

@Path("/todo")
public class TodoResource {

	private EntityManager em = EntityManagerUtil.getEntityManager();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestService() {
		return "Hello World! This is coming from webservice motherfucker!!";
	}

	@GET
	@Path("/get_list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getTodos() {

		// read the existing entries and write to console
		Query q = em.createQuery("select t from Todo t");
		List<Todo> todoList = q.getResultList();
		for (Todo todo : todoList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + todoList.size());

		// create new person
		em.getTransaction().begin();
		Todo todo = new Todo();
		todo.setDescription("follankele");
		todo.setSummary("ahora si");
		em.persist(todo);
		em.getTransaction().commit();
		em.close();
		return todoList;
	}

}
