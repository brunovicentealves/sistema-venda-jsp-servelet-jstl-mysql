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

/**
 *
 * @author bruno.alves
 */
public class LoginDAO {
        
    Empregado em = new Empregado();
    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empregado Valida(String usuario, String password) {
       
        String sql = "select * from empregado where usuario=? and cpf=?";

        try {
            con = cn.conexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                em.setUsuario(rs.getString("usuario"));
                em.setCpf(rs.getString("cpf"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return em;
    }

}
