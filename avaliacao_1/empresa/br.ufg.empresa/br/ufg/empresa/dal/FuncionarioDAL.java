package br.ufg.empresa.dal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.ufg.empresa.dao.FuncionarioDAO;
import br.ufg.empresa.database.DatabaseConnection;
import br.ufg.empresa.domain.Integravel;
import br.ufg.empresa.model.Funcionario;

public class FuncionarioDAL implements Integravel<Funcionario> {

	@Override
	public List<Funcionario> readAll() throws Exception {
		List<Funcionario> lista = new ArrayList<>();
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		lista = dao.getFuncionarios(connection);
		return lista;
	}

	@Override
	public Funcionario read(int id) throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.getFuncionario(connection, id);
	}

	@Override
	public Funcionario create(Funcionario funcionario)
			throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.cadastrarFuncionario(connection, funcionario);
	}

	@Override
	public Funcionario update(Funcionario funcionario) throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.atualizarFuncionario(connection, funcionario);
	}

	@Override
	public boolean delete(int id) throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.deletarFuncionario(connection, id);		
	}
}
