/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.esp.consumoviacep;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aluno
 */
@ManagedBean
public class Main {
    
    private Gson gson = new Gson();    
    private String cepDigitado;
    private CEPCorreios cepCorreios;

    public void pesquisarCep() {
        Client cli = Client.create();
        WebResource webRes = cli.resource(String.format("https://viacep.com.br/ws/%s/json/", cepDigitado));
        String stringJSON = webRes.get(String.class);
        cepCorreios = gson.fromJson(stringJSON, CEPCorreios.class);
    }

    public String getCepDigitado() {
        return cepDigitado;
    }

    public void setCepDigitado(String cepDigitado) {
        this.cepDigitado = cepDigitado;
    }

    public CEPCorreios getCepCorreios() {
        return cepCorreios;
    }

    public void setCepCorreios(CEPCorreios cepCorreios) {
        this.cepCorreios = cepCorreios;
    }
    
    
    
}
