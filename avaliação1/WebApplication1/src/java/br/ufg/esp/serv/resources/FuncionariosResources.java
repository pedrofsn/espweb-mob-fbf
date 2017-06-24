/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.esp.serv.resources;

import br.ufg.esp.serv.model.Funcionario;
import com.google.gson.Gson;
import dao.AccessManager;
import dao.DAOFuncionario;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author aluno
 */
@Path("funcionarios")
public class FuncionariosResources {

    /**
     * Creates a new instance of Funcionarios
     */
    public FuncionariosResources() {
    }

    /**
     * Retrieves representation of an instance of br.ufg.esp.serv.FuncionariosResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();        
        
        String json = null;
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            lista = new AccessManager().getAll();
            json = gson.toJson(lista);
        } catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }

    /**
     * PUT method for updating or creating an instance of FuncionariosResources
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
