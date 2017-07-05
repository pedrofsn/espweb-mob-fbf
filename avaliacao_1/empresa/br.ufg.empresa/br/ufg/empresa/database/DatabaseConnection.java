package br.ufg.empresa.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection getConnection() throws Exception{
        try{
            String url = "jdbc:mysql://localhost/empresa";
            String usr = "root";
            String pswrd = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
            return DriverManager.getConnection(url, usr, pswrd);
        } catch (Exception e){
        	e.printStackTrace();
            throw e;
        }
    }
	
}
