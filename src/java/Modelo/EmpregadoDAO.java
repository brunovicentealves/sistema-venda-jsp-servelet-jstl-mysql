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
public class EmpregadoDAO {

    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String resposta;

    Empregado empregado = new Empregado();

    public Empregado listarid(int id) {
        String sql = "select * from empregado where idempregado="+id;
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             while (rs.next()) {
                empregado.setIdempregado(Integer.parseInt(rs.getString("idempregado")));
                empregado.setCpf(rs.getString("cpf"));
                empregado.setNome(rs.getString("nome"));
                empregado.setTelefone(rs.getString("telefone"));
                empregado.setStatus(rs.getString("status"));
                empregado.setUsuario(rs.getString("usuario"));
             }
            
        } catch (Exception e) {
        }
        return empregado;
    }

    public List listar() {
        String sql = "select * from empregado";
        List<Empregado> lista = new ArrayList<Empregado>();
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empregado empregado = new Empregado();
                empregado.setIdempregado(Integer.parseInt(rs.getString("idempregado")));
                empregado.setCpf(rs.getString("cpf"));
                empregado.setNome(rs.getString("nome"));
                empregado.setTelefone(rs.getString("telefone"));
                empregado.setStatus(rs.getString("status"));
                empregado.setUsuario(rs.getString("usuario"));
                lista.add(empregado);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public String cadastrar(Empregado em) {
        String sql = "insert into empregado(nome,cpf,telefone,status,usuario) values(?,?,?,?,?)";
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNome());
            ps.setString(2, em.getCpf());
            ps.setString(3, em.getTelefone());
            ps.setString(4, em.getStatus());
            ps.setString(5, em.getUsuario());
            ps.executeUpdate();
            resposta = "cadastrado com sucesso";
        } catch (Exception e) {
            resposta =e.getMessage();
        }

        return resposta;
    }

    public String editar(Empregado em) {
        String sql = "update empregado set cpf='" + em.getCpf() + "',nome='" + em.getNome() + "',telefone='" + em.getTelefone() + "',status='" + em.getStatus() + "' ,usuario='" + em.getUsuario() + "'where idempregado=" + em.getIdempregado();
        try {
             con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            resposta="Alterado com sucesso!";
        } catch (Exception e) {
            String resposta=e.getMessage();
        }
        
        return resposta;
    }

    public String delete(int id) {
        String sql = "DELETE FROM empregado WHERE idempregado=" + id;
        String resposta = "";
        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        return resposta;
    }

}
