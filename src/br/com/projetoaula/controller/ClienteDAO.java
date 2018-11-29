/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eduardo
 */
public class ClienteDAO {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    Conexao con = new Conexao();
    Cliente cli = new Cliente();
    
    
    public void inserirCliente(String nome, String endereco, String telefone, String cpf){
        cli.setNome_cliente(nome);
        cli.setEndereco_cliente(endereco);
        cli.setTelefone_cliente(telefone);
        cli.setCpf_cliente(cpf);
        
        String sql = "insert into cliente (nome_cliente, endereco_cliente, telefone_cliente,"
                + "cpf_cliente) values (?,?,?,?)";
        
        try{
            conexao  = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cli.getNome_cliente());
            pst.setString(2, cli.getEndereco_cliente());
            pst.setString(3, cli.getTelefone_cliente());
            pst.setString(4, cli.getCpf_cliente());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            con.desconector(conexao);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
            }
        
    }
    
    public void alterarCliente(int id, String nome, String endereco, String telefone, String cpf){
        cli.setId_cliente(id);
        cli.setNome_cliente(nome);
        cli.setEndereco_cliente(endereco);
        cli.setTelefone_cliente(telefone);
        cli.setCpf_cliente(cpf);
        
        String sql = "update cliente set nome_cliente = ?, endereco_cliente = ?, telefone_cliente = ?, "
                + "cpf_cliente = ? where id_cliente = ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cli.getNome_cliente());
            pst.setString(2, cli.getEndereco_cliente());
            pst.setString(3, cli.getTelefone_cliente());
            pst.setString(4, cli.getCpf_cliente());
            pst.setInt(5, cli.getId_cliente());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
            con.desconector(conexao);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
    }
    
    public boolean removerCliente(int id){
        cli.setId_cliente(id);
        
        String sql = "delete from cliente where id_cliente = ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, cli.getId_cliente());
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
            JOptionPane.showMessageDialog(null, "Erro ao deletar: "+e);
            return false;
        }
        
    }
    
    public void ConsultaIdCliente(JTextField consulta, JTable tabela){
        String sql = "select id_cliente as ID, nome_cliente as Nome, endereco_cliente as Endereço, "
                + "telefone_cliente as Telefone, cpf_cliente as Cpf from cliente where id_cliente like ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, consulta.getText());
            rs = pst.executeQuery();
            
            tabela.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
    }
    
    public void ConsultaNomeCliente(String nome, JTable tabela){
        cli.setNome_cliente(nome);
        
        String sql = "select id_cliente as ID, nome_cliente as Nome, endereco_cliente as Endereço, "
                + "telefone_cliente as Telefone, cpf_cliente as Cpf from cliente where nome_cliente like ?";
        
        try{
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, cli.getNome_cliente()+"%");
            rs = pst.executeQuery();
            
            tabela.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
        
    }
            
    
    
    
}
