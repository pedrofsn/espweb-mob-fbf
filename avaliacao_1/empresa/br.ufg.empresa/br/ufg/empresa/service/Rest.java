package br.ufg.empresa.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class Rest {

	@GET
	@Path("/teste")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response get() {
		String response = "teste";
		return Response.status(200).entity(response).build();
	}

}
