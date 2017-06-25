package br.ufg.empresa.dal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.ufg.empresa.dao.FuncionarioDAO;
import br.ufg.empresa.database.DatabaseConnection;
import br.ufg.empresa.exception.IdInexistenteException;
import br.ufg.empresa.model.Funcionario;

public class FuncionarioDAL {

	public List<Funcionario> getFuncionarios() throws Exception {
		List<Funcionario> lista = new ArrayList<>();
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		lista = dao.getFuncionarios(connection);
		return lista;
	}

	public Funcionario getFuncionario(int id) throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.getFuncionario(connection, id);
	}

	public Funcionario postFuncionario(Funcionario funcionario) throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.cadastrarFuncionario(connection, funcionario);
	}
}
