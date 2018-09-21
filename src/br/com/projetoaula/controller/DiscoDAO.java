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
    
    public void alterarDisco(int id, String nome, int ano, int duracao, double preco, 
            int faixas, int artista, int genero, String capa){
        
        disco.setId_disco(id);
        disco.setNome_disco(nome);
        disco.setLancamento_disco(ano);
        disco.setDuracao_disco(duracao);
        disco.setPreco_disco(preco);
        disco.setFaixas_disco(faixas);
        disco.setArtista_disco(artista);
        disco.setGenero_disco(genero);
        disco.setCapa_disco(capa);
        
        String sql = "update disco set nome_disco=?, ano_disco=?, duracao_disco=?, preco_disco=?, "
                + "faixas_disco=?, artista_disco=?, genero_disco=?, capa_disco=? where id_disco=?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, disco.getNome_disco());
            pst.setInt(2, disco.getLancamento_disco());
            pst.setInt(3, disco.getDuracao_disco());
            pst.setDouble(4, disco.getPreco_disco());
            pst.setInt(5, disco.getFaixas_disco());
            pst.setInt(6, disco.getArtista_disco());
            pst.setInt(7, disco.getGenero_disco());
            pst.setString(8, disco.getCapa_disco());
            pst.setInt(9, disco.getId_disco());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Disco alterado com sucesso");
            con.desconector(conexao);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
    }
    
    public boolean deletaDisco(int id){
        disco.setId_disco(id);
        
        String sql = "delete from disco where id_disco = ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, disco.getId_disco());
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
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            return false;
        }
        
    }
    
    public void consultaIdDisco(JTable tabela, JTextField id){
        
        String sql = "select id_disco as ID, nome_disco as Nome, ano_disco as Ano, duracao_disco as Duração,"
                + " preco_disco as Preço, faixas_disco as Faixas, artista_disco as Artista, genero_disco as"
                + " Gênero, capa_disco as Capa from disco where id_disco like ?";
                
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
    
        public void consultaNomeDisco(String nome, JTable tab){
        disco.setNome_disco(nome);
        String sql = "select id_disco as ID, nome_disco as Nome, ano_disco as Ano, duracao_disco as Duração,"
                + " preco_disco as Preço, faixas_disco as Faixas, artista_disco as Artista, genero_disco as"
                + " Gênero, capa_disco as Capa from disco where nome_disco like ?";
                
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
