/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;




/**
 *
 * @author bruno.alves
 */
public class Conexao {
    Connection  con ; 
    String url = "jdbc:mysql://localhost:3306/bd_sistema_venda";
    String user="root";
    String pass="";
    
    public Connection conexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
        }
    
    
    return con;
    }
    
    
}
