/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.ufg.esp.serv.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author aluno
 */
public class DAOFuncionario {

    public ArrayList<Funcionario> getFuncionarios(Connection conn) throws SQLException {
        ArrayList<Funcionario> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM funcionarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setNome(rs.getString("nome"));
                obj.setId(rs.getInt("id"));
                lista.add(obj);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return lista;
    }

//    public Produto getProduto(Connection conn, String codigo) throws SQLException {
//        Produto produto = new Produto();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        if (codigo.equals("") || codigo == null)
//            throw new SQLException("Nenhum código de produto foi informado!");
//        try {
//            ps = conn.prepareStatement("SELECT * FROM produtos WHERE codigo=?");
//            ps.setString(1, codigo);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                produto.setNome(rs.getString("nome"));
//                produto.setCodigo(rs.getString("codigo"));
//                produto.setPreco(rs.getFloat("preco"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try { if (rs != null) rs.close(); } catch (Exception e) {}
//            try { if (ps != null) ps.close(); } catch (Exception e) {}
//            try { if (conn != null) conn.close(); } catch (Exception e) {}
//        }
//        return produto;
//    }

//    public boolean addProduto (Connection conn, Produto produto) throws SQLException{
//        PreparedStatement ps = null;
//        if (produto == null)
//            throw new SQLException("Nenhum produto foi informado!");
//        try {
//            String sql = "INSERT INTO produtos (nome, codigo, preco) " +
//                    "VALUES (?, ?, "+ "round (CAST (" + 
//                    "? AS numeric), 2) )";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, produto.getNome());
//            ps.setString(2, produto.getCodigo());
//            ps.setFloat(3, produto.getPreco());
//            ps.executeUpdate();
//        } catch (SQLException e){
//            e.printStackTrace();
//            return false;
//        } finally {
//            try { if (ps != null) ps.close(); } catch (Exception e) {}
//            try { if (conn != null) conn.close(); } catch (Exception e) {}
//        }
//        return true;
//    }

//    public boolean setProduto (Connection conn, Produto produto) throws SQLException {
//        PreparedStatement ps = null;
//        if (produto == null)
//            throw new SQLException("Nenhum produto foi informado!");
//        try {
//            String sql = "UPDATE produtos SET nome=?, preco=" + "round (CAST (" + 
//                    produto.getPreco() + " AS numeric), 2) WHERE codigo=?";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, produto.getNome());
//            ps.setString(2, produto.getCodigo());
//            ps.executeUpdate();
//        } catch (SQLException e){
//            e.printStackTrace();
//            return false;
//        } finally {
//            try { if (ps != null) ps.close(); } catch (Exception e) {}
//            try { if (conn != null) conn.close(); } catch (Exception e) {}
//
//        }
//        return true;
//    }

//    public String delProduto (Connection conn, String codigo) throws SQLException {
//        PreparedStatement ps = null;
//        if (codigo.equals("") || codigo == null)
//            throw new SQLException("Nenhum código de produto foi informado!");
//        try {
//            String sql = "DELETE FROM produtos WHERE codigo=?";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, codigo);
//            ps.executeUpdate();
//        } catch (SQLException e){
//            e.printStackTrace();
//            return "Erro ao excluir registro.";
//        } finally {
//            try { if (ps != null) ps.close(); } catch (Exception e) {}
//            try { if (conn != null) conn.close(); } catch (Exception e) {}
//        }
//        return "Registro excluído com sucesso!";
//    }    
}
