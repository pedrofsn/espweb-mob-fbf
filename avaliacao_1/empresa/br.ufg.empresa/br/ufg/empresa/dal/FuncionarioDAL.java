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
		Funcionario funcionario = dao.getFuncionario(connection, id);

		if (funcionario != null) {
			return funcionario;
		} else {
			throw new IdInexistenteException(String.valueOf(id));
		}
	}
}
