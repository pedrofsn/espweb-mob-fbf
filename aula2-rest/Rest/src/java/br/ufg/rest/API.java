/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aluno
 */
@Path("/alunos") 
public class API {
    
    private Gson gson = new Gson();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(0, "Pedro"));
        alunos.add(new Aluno(1, "Luatane"));
        alunos.add(new Aluno(2, "João Pedro"));
        
        return (String) gson.toJson(alunos);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno postAluno(Aluno aluno) {
        aluno.setNome("João");
        return aluno;
    }
    
}
