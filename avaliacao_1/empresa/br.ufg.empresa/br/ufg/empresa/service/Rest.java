package br.ufg.empresa.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.ufg.empresa.dal.FuncionarioDAL;
import br.ufg.empresa.dto.DeleteDTO;
import br.ufg.empresa.dto.ErroDTO;
import br.ufg.empresa.dto.ListaFuncionarioDTO;
import br.ufg.empresa.dto.ObjetoFuncionarioDTO;
import br.ufg.empresa.exception.FormatoInvalidoException;
import br.ufg.empresa.model.Erro;
import br.ufg.empresa.model.Funcionario;

import com.google.gson.Gson;

@Path("/")
public class Rest {

	private static final Gson GSON = new Gson();

	@GET
	@Path("/funcionarios")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response getAll() {
		try {
			List<Funcionario> lista = new FuncionarioDAL().readAll();
			ListaFuncionarioDTO response = new ListaFuncionarioDTO(lista);
			String json = GSON.toJson(response);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	@GET
	@Path("/funcionario/{id}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response get(@PathParam("id") int id) {
		try {
			Funcionario obj = new FuncionarioDAL().read(id);
			ObjetoFuncionarioDTO response = new ObjetoFuncionarioDTO(obj);
			String json = GSON.toJson(response);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	@POST
	@Path("/funcionario")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response post(Funcionario funcionario) {
		try {

			if (funcionario == null || !funcionario.isValidoParaCadastro()) {
				return retornarErro(new FormatoInvalidoException());
			}

			Funcionario obj = new FuncionarioDAL().create(funcionario);
			ObjetoFuncionarioDTO response = new ObjetoFuncionarioDTO(obj);
			String json = GSON.toJson(response);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	@PUT
	@Path("/funcionario")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response put(Funcionario funcionario) {
		try {

			if (funcionario == null || !funcionario.isValidoParaEdicao()) {
				return retornarErro(new FormatoInvalidoException());
			}

			Funcionario obj = new FuncionarioDAL().update(funcionario);
			ObjetoFuncionarioDTO response = new ObjetoFuncionarioDTO(obj);
			String json = GSON.toJson(response);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	@DELETE
	@Path("/funcionario/{id}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response delete(@PathParam("id") int id) {
		try {
			boolean status = new FuncionarioDAL().delete(id);
			DeleteDTO response = new DeleteDTO(status);
			String json = GSON.toJson(response);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			return retornarErro(e);
		}
	}

	private Response retornarErro(Exception e) {
		if (e != null) {
			Erro erro = new Erro(e);
			ErroDTO response = new ErroDTO(erro);
			String json = GSON.toJson(response);
			return Response.status(erro.getCodeHttp()).entity(json).build();
		}
		return null;
	}
}
