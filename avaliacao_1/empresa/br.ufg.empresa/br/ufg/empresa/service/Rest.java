package br.ufg.empresa.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.ufg.empresa.dal.FuncionarioDAL;
import br.ufg.empresa.model.Funcionario;

import com.google.gson.Gson;

@Path("/")
public class Rest {

	private static final Gson GSON = new Gson();

	@GET
	@Path("/funcionarios")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response get() {
		String json = null;

		try {
			List<Funcionario> lista = new FuncionarioDAL().getFuncionarios();
			json = GSON.toJson(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(json).build();
	}

}
