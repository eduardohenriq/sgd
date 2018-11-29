/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Disco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eduardo
 */
public class CarrinhoDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Disco disco = new Disco();
    
    public void consultaNomeDisco(String nome, JTable tab){
        disco.setNome_disco(nome);
        String sql = "select id_disco as ID, nome_disco as Nome, preco_disco as Preço,"
                + " from disco where nome_disco like ?";
                
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, disco.getNome_disco()+"%");
            
            rs = pst.executeQuery();
            
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:  "+e);
        }
        
    }
    
}
