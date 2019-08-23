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
public class ClienteDAO {

    Cliente cliente = new Cliente();
    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listarCliente() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(Integer.parseInt(rs.getString("cep")));
                lista.add(cliente);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public String cadastrarCliente(Cliente cli) {
        String sql = "insert into cliente(nome,cpf,telefone,endereco,numero,cidade,bairro,cep) values(?,?,?,?,?,?,?,?)";
        String resposta;
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getCpf());
            ps.setString(3, cli.getTelefone());
            ps.setString(4, cli.getEndereco());
            ps.setString(5, cli.getNumero());
            ps.setString(6, cli.getCidade());
            ps.setString(7, cli.getBairro());
            ps.setString(8, Integer.toString(cli.getCep()));
            ps.executeUpdate();
            resposta = "cadastrado com sucesso";
        } catch (Exception e) {
            resposta = e.getMessage();
        }
        return resposta;
    }

    public Cliente listarClienteId(int id) {
        String sql = "select idcliente,nome,cpf,telefone,endereco,numero,cidade,bairro,cep from cliente where idcliente=" + id;
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(Integer.parseInt(rs.getString("cep")));

            }

        } catch (Exception e) {
        }

        return cliente;
    }

    public String editarCliente(Cliente cli) {
        String sql = "update cliente set nome=?,cpf=?,telefone=?,endereco=?,numero=?,cidade=?,bairro=?,cep=? where idcliente=?";
        String resposta;
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getCpf());
            ps.setString(3, cli.getTelefone());
            ps.setString(4, cli.getEndereco());
            ps.setString(5, cli.getNumero());
            ps.setString(6, cli.getCidade());
            ps.setString(7, cli.getBairro());
            ps.setInt(8, cli.getCep());
            ps.setInt(9,cli.getIdcliente());
            ps.executeUpdate();
            resposta = "alterado com sucesso";
        } catch (Exception e) {
            resposta = e.getMessage();
        }

        return resposta;
    }

    public String deleteCliente(int id) {
        String sql = "DELETE FROM cliente WHERE idcliente=" + id;
        String resposta = "";
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        return resposta;
    }
    
    public Cliente buscarCliente(String cpf){
    String sql ="select * from cliente where cpf="+cpf;
        try {
             con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                cliente.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
               cliente.setNumero(rs.getString("numero"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setBairro(rs.getString("bairro"));
               cliente.setCep(Integer.parseInt(rs.getString("cep")));
            
            
            }
            
        } catch (Exception e) {
        }
    
    return cliente;
    }

}
