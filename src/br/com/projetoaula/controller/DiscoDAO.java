/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Disco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eduardo
 */
public class DiscoDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Disco disco = new Disco();
    

    
    public void InserirDisco(String nome, int ano, int duracao, double preco, 
            int faixas, int artista, int genero, String capa){
        
        String sql = "insert into disco (nome_disco, ano_disco, duracao_disco,"
                + "preco_disco,	faixas_disco, artista_disco, genero_disco, capa_disco)"
                + " values (?,?,?,?,?,?,?,?)";
        
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, nome);
            pst.setInt(2, ano);
            pst.setInt(3, duracao);
            pst.setDouble(4, preco);
            pst.setInt(5, faixas);
            pst.setInt(6, artista);
            pst.setInt(7, genero);
            pst.setString(8, capa);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Disco inserido com sucesso!");
            con.desconector(conexao);            
            
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }
    
    public void consultaIdDisco(JTable tabela, JTextField id){
        
        String sql = "select id_disco as ID, nome_disco as Nome, ano_disco as Ano, duracao_disco as Duração,"
                + " preco_disco as Preço, faixas_disco as Faixas, artista_disco as Artista, genero_disco as"
                + " Gênero from disco where id_disco like ?";
                
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id.getText());
            
            rs = pst.executeQuery();
            
            tabela.setModel(DbUtils.resultSetToTableModel(rs));
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:  "+e);
        }
        
    }






}
