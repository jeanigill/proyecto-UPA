package py.edu.upa.test.ws;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.CategoriaBC;
import py.edu.upa.test.entity.Categoria;


@Path("categorias")
@RequestScoped
public class CategoriaService {
	@Inject
	private CategoriaBC bc;
	
	
	//SERVICIO GET ALL
	//http://localhost:8080/rest/productos
	@GET
	 @Produces("application/json")
		public Response getAll() {
			try {
				return Response.ok().entity(bc.find()).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("ERROR_GENERICO")
						.build();
			}
		}
	
	//SERVICIO GET DE UN PRODUCTO POR ID
	//http://localhost:8080/rest/productos/X
    @GET
    @Path("/{id: \\d+}")
    @Produces({"application/json"})
    public Response get(@PathParam("id") Integer id) {
    	try {
			return Response.ok().entity(bc.findById(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
	
	//SERVICIO POST
	//http://localhost:8080/rest/productos
	@POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
	public Response add(Categoria c) {
		try {
			bc.insert(c);
			return Response.ok().entity(c).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
	
	
	//SERVICIO PUT	
	//http://localhost:8080/rest/productos/X
	@PUT
	@Path("/{id: \\d+}")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response update(@PathParam("id") Integer id, Categoria c) {
		try {
	  		bc.update(id,c);
				return Response.ok().entity("OK").build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("ERROR_GENERICO")
						.build();
			}
	  }
  	
	//SERVICIO DELETE
	//http://localhost:8080/rest/productos/X
	 @DELETE
	 @Path("/{id: \\d+}")
	 @Produces({"application/json"})
	 public Response delete(@PathParam("id") Integer id) {
	   	try {
	   		bc.delete(id);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	 }
	 
	 //EL QUE SIGO SIN ENTENDER PARA QUE FUNCIONA
	 //http://localhost:8080/rest/tasks/prueba?filter=xx
	 @GET
	 @Path("/pruebas")
	 @Produces({"application/json"})
	 public Response update(@QueryParam("filter") String filter) {
		 try {
			 return Response.ok().entity(bc.getWithFilter(filter)).build();
		 } catch (Exception e) {
			 e.printStackTrace();
			 return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					 .entity("ERROR_GENERICO")
					 .build();
		 }
	 }
/*	//PARA PAGINACIÓN
	 //http://localhost:8080/ws/rest/tasks/pagination?page=X&size=X
	 @GET
	 @Path("/pagination")
	 @Produces({"application/json"})
	 public Response getWithPagination (@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
	   	try { 
			return Response.ok().entity(bc.getPaginatedTasks(page, size)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	 }
	 }
 */	
}
