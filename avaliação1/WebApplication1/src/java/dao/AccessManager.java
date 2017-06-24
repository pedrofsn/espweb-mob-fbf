/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.ufg.esp.serv.model.Funcionario;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class AccessManager {
    
    public ArrayList<Funcionario> getAll() throws Exception {
        ArrayList<Funcionario> lista = new ArrayList<>();
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        DAOFuncionario access = new DAOFuncionario();
        lista = access.getFuncionarios(conn);
        return lista;
    }
    
}
