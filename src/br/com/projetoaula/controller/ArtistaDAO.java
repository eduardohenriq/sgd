/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author Eduardo
 */
public class ArtistaDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Artista art = new Artista();
    
    public void artistaComboBox(JComboBox art){
        
        String sql = "select * from artista";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                art.addItem(rs.getString("nome_artista"));
            }
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
        
    }
    
    
    
}
