package br.ufg.empresa.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.ufg.empresa.dal.FuncionarioDAL;
import br.ufg.empresa.dto.Erro;
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
		try {
			List<Funcionario> lista = new FuncionarioDAL().getFuncionarios();
			String json = GSON.toJson(lista);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	private Response retornarErro(Exception e) {
		if (e != null) {
			Erro erro = new Erro(e);
			String json = GSON.toJson(erro);
			return Response.status(erro.getCodeHttp()).entity(json).build();
		}
		return null;
	}
}
