/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.alves
 */
public class ProdutoDAO {

    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Produto produto = new Produto();
    String resposta;

    public List listarProduto() {
        String sql = "select * from produto";
        List<Produto> lista = new ArrayList<Produto>();
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdproduto(Integer.parseInt(rs.getString("idproduto")));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(Double.parseDouble(rs.getString("preco")));
                produto.setEstoque(Integer.parseInt(rs.getString("estoque")));
                produto.setStatus(rs.getString("status"));
                lista.add(produto);

            }

        } catch (Exception e) {
        }

        return lista;

    }

    public String CadastrarProduto(Produto produto) {
        String resposta;
        String Sql = "insert into produto(nome,preco,estoque,status) values(?,?,?,?)";
        try {
            con = cn.conexao();
            ps = con.prepareStatement(Sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, Double.toString(produto.getPreco()));
            ps.setString(3, Integer.toString(produto.getEstoque()));
            ps.setString(4, produto.getStatus());
            ps.executeUpdate();

            resposta = "Cadastrado com Sucesso!!";
        } catch (Exception e) {
            resposta = e.getMessage();
        }

        return resposta;

    }

    public String deletarProduto(int idproduto) {

        String sql = "DELETE FROM produto WHERE idproduto= " + idproduto;
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            resposta = "Deletado com sucesso !";
        } catch (Exception e) {
            resposta = e.getMessage();
        }

        return resposta;

    }

    public Produto listarProdutoId(int id) {
        String sql =" select * from produto where idproduto="+id;
        try {
             con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                produto.setIdproduto(Integer.parseInt(rs.getString("idproduto")));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(Double.parseDouble(rs.getString("preco")));
                produto.setEstoque(Integer.parseInt(rs.getString("estoque")));
                produto.setStatus(rs.getString("status"));

            }
        } catch (Exception e) {
        }
        return produto;
    }
    
    public String editarProduto(Produto pro){
    String sql="update produto set nome=?,preco=?,estoque=?,status=? where idproduto=?";
        try {
            con=cn.conexao();
           ps= con.prepareStatement(sql);
           ps.setString(1,pro.getNome() );
           ps.setString(2, String.valueOf(pro.getPreco()));
           ps.setString(3, String.valueOf(pro.getEstoque()));
           ps.setString(4, pro.getStatus());
           ps.setString(5, String.valueOf(pro.getIdproduto()));
           ps.executeUpdate();
            resposta = "Alterado com sucesso";
        } catch (Exception e) {
            resposta= e.getMessage();
        }
    return resposta;
    
    }
    
    

}
