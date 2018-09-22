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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eduardo
 */
public class ArtistaDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Artista ar = new Artista();
    
    public void artistaComboBox(JComboBox art){
        
        String sql = "select * from artista";
        
        try{
            art.removeAllItems();
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                art.addItem(rs.getString("nome_artista"));
            }
            con.desconector(conexao);
            art.addItem("Adicionar...");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
        
    }
    
    public void insereArtista(String nome){
        
        ar.setNome_artista(nome);
        
        String sql = "insert into artista (nome_artista) values (?)";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, ar.getNome_artista());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Artista inserido com sucesso!");
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
    }
    
    public void alterarArtista(int id, String nome){
        ar.setId_artista(id);
        ar.setNome_artista(nome);
        
        String sql = "update artista set nome_artista = ? where id_artista = ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, ar.getNome_artista());
            pst.setInt(2, ar.getId_artista());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Artista alterado com sucesso!");
            con.desconector(conexao);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao alterar artista: "+e);
        }
        
    }
    
    public boolean removeArtista(int id){
        ar.setId_artista(id);
        
        String sql = "delete from artista where id_artista = ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ar.getId_artista());
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar?", "ATENÇÃO", JOptionPane.YES_NO_CANCEL_OPTION)==0){
               pst.execute();
               JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
               con.desconector(conexao);
               return true;
            }else{
                con.desconector(conexao);
                return false;
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao remover artista: "+e);
            return false;
        }
        
    }
    
    public void ConsultaIdArtista(int id, JTable tab){
        ar.setId_artista(id);
        String sql = "select id_artista as ID, nome_artista as Nome from artista where id_artista like ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ar.getId_artista());
            rs = pst.executeQuery();
            
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
        }
    
    }
    
    public void ConsultaNomeArtista(String nome, JTable tab){
        ar.setNome_artista(nome);
        String sql = "select id_artista as ID, nome_artista as Nome where nome_artista like ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ar.getNome_artista()+"%");
            rs = pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
        }
        
    }
    
    
    
}
