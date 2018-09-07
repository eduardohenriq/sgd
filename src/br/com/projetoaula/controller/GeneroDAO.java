/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Genero;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Eduardo
 */
public class GeneroDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Genero gen = new Genero();
    
    public void generoComboBox(JComboBox genero){
        String sql = "select * from genero";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                genero.addItem(rs.getString("nome_genero"));
            }
            
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
    }
    
    
}
