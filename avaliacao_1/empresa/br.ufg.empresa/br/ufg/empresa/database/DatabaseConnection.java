package br.ufg.empresa.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/empresa";
            String usr = "postgres";
            String pswrd = "pedrofsn";
            return DriverManager.getConnection(url, usr, pswrd);
        } catch (Exception e){
        	e.printStackTrace();
            throw e;
        }
    }
	
}
