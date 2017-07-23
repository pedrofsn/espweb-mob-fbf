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
					obj.setId(resultSet.getInt("id"));
					obj.setNome(resultSet.getString("nome"));
					obj.setEmail(resultSet.getString("email"));
					obj.setCpf(resultSet.getString("cpf"));
					obj.setTelefone(resultSet.getString("telefone"));
					obj.setNascimento(resultSet.getDate("nascimento"));
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
			obj.setId(resultSet.getInt("id"));
			obj.setNome(resultSet.getString("nome"));
			obj.setEmail(resultSet.getString("email"));
			obj.setCpf(resultSet.getString("cpf"));
			obj.setTelefone(resultSet.getString("telefone"));
			obj.setNascimento(resultSet.getDate("nascimento"));
		}

		return obj;
	}

	public Funcionario cadastrarFuncionario(Connection conn,
			Funcionario funcionario) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(
				"INSERT INTO funcionarios (nome, email, cpf, nascimento, telefone) VALUES (? , ? , ? , ?, ?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, funcionario.getNome());
		preparedStatement.setString(2, funcionario.getEmail());
		preparedStatement.setString(3, funcionario.getCpf());
		preparedStatement.setDate(4, funcionario.getNascimento());
		preparedStatement.setString(5, funcionario.getTelefone());
		preparedStatement.executeUpdate();

		ResultSet rs = preparedStatement.getGeneratedKeys();

		if (rs.next()) {
			funcionario.setId(rs.getInt(1));
		}

		return funcionario;
	}

	public Funcionario atualizarFuncionario(Connection conn,
			Funcionario funcionario) throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement("UPDATE funcionarios SET nome = ?, email = ?, cpf = ?, nascimento = ?, telefone = ? where id = ?");
		preparedStatement.setString(1, funcionario.getNome());
		preparedStatement.setString(2, funcionario.getEmail());
		preparedStatement.setString(3, funcionario.getCpf());
		preparedStatement.setDate(4, funcionario.getNascimento());
		preparedStatement.setString(5, funcionario.getTelefone());
		preparedStatement.setInt(6, funcionario.getId());
		int caso = preparedStatement.executeUpdate();

		return (caso == 1) ? funcionario : new Funcionario();
	}

	public boolean deletarFuncionario(Connection conn, int id)
			throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement("delete from funcionarios where id = ?");
		preparedStatement.setInt(1, id);
		int caso = preparedStatement.executeUpdate();

		return caso == 1;
	}

}
