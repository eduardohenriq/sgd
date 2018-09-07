/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class Conexao {
   
    public static Connection conector(){
        Connection conexao;
        String driver = "com.mysql.jdbc.Driver";
        
        try{
            
            Class.forName(driver);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sgd","root","");
            System.out.println("Conectado com sucesso");
            return conexao;
            
        }catch(Exception e){
            System.out.println("Erro ao conectar: " +e);
            return null;
        }
        
    }
    
    public void desconector(Connection con){
        try{
            con.close();
            System.out.println("Desconectado com sucesso");
        }catch(Exception e){
            System.out.println("Erro ao desconectar: " +e);
        }
    }
    
}
