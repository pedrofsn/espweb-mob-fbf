/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.esp.cliente;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aluno
 */
@ManagedBean
public class AlunoManagedBean {

    private Gson gson = new Gson();
    private static final String GET_ALUNOS = "http://localhost:8084/Rest/resources/alunos";

    public List<Aluno> getAlunosMatriculados() {
        Client cli = Client.create();
        WebResource webRes = cli.resource(GET_ALUNOS);
        String json = webRes.get(String.class);
        List<Aluno> lista = gson.fromJson(json, new TypeToken<List<Aluno>>() {}.getType());
        return lista;
    }

}
