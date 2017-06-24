package br.ufg.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufg.empresa.model.Funcionario;

public class FuncionarioDAO {

	public List<Funcionario> getFuncionarios(Connection conn)
			throws SQLException {
		List<Funcionario> lista = new ArrayList<Funcionario>();

		if (conn != null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = conn
						.prepareStatement("SELECT * FROM funcionarios");
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Funcionario obj = new Funcionario();
					obj.setNome(resultSet.getString("nome"));
					obj.setId(resultSet.getInt("id"));
					obj.setCargo(resultSet.getString("cargo"));
					lista.add(obj);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				resultSet.close();
				preparedStatement.close();
				conn.close();
			}
		}

		return lista;
	}

	public Funcionario getFuncionario(Connection conn, int id)
			throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT * FROM funcionarios where id = ?");
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		Funcionario obj = null;
		
		while (resultSet.next()) {
			obj = new Funcionario();
			obj.setNome(resultSet.getString("nome"));
			obj.setId(resultSet.getInt("id"));
			obj.setCargo(resultSet.getString("cargo"));
		}

		return obj;
	}

}
