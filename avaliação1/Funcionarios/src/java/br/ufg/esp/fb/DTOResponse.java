/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.esp.fb;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class DTOResponse implements Serializable {
    
    private Object data;

    public DTOResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }  
    
}
