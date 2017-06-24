/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class DBConn {
    
    public Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/empresa";
            String usr = "postgres";
            String pswrd = "aula321";
            return DriverManager.getConnection(url, usr, pswrd);
        } catch (Exception e){
            throw e;
        }
    }
    
}
