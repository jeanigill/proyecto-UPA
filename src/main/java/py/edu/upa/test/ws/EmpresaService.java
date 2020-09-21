package py.edu.upa.test.ws;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.EmpresaBC;


@Path("empresas")
@RequestScoped
public class EmpresaService {
	@Inject
	private EmpresaBC bc;
	
	
	//SERVICIO GET ALL
	//http://localhost:8080/rest/empresa
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
	
	//SERVICIO GET DE UNa Empresa POR ID
	//http://localhost:8080/rest/empresa/X
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
}
