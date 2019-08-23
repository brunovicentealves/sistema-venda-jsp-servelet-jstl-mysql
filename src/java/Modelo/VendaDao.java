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
public class VendaDao {
    
     Cliente cliente = new Cliente();
    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public String generarSerie(){
    String numeroSerie ="" ; 
    
    String sql = "select max(numeroserie) from venda";
        try {
            con=cn.conexao();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                numeroSerie = rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return numeroSerie;
    }
    
}
