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

import py.edu.upa.test.business.ProveedorBC;
import py.edu.upa.test.entity.Proveedor;

@Path("proveedores")
@RequestScoped
public class ProveedorService {
	@Inject
	private ProveedorBC bc;
	
	//SERVICIO GET ALL
	//http://localhost:8080/rest/proveedores
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
	
	//SERVICIO GET DE UN PROVEEDOR POR ID
	//http://localhost:8080/rest/proveedores/X
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
	//http://localhost:8080/rest/proveedores
	@POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
	public Response add(Proveedor p) {
		try {
			bc.insert(p);
			return Response.ok().entity(p).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
	
	
	//SERVICIO PUT	
	//http://localhost:8080/rest/proveedores/X
	@PUT
	@Path("/{id: \\d+}")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response update(@PathParam("id") Integer id, Proveedor p) {
		try {
	  		bc.update(id,p);
				return Response.ok().entity("OK").build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("ERROR_GENERICO")
						.build();
			}
	  }
  	
	//SERVICIO DELETE
	//http://localhost:8080/rest/proveedores/X
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
	 
	 //http://localhost:8080/rest/proveedores/prueba?filter=xx
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
}
