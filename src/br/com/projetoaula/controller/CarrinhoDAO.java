/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import br.com.projetoaula.model.Carrinho;
import br.com.projetoaula.model.Disco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
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
    
    public void inserir(Disco disco, JFrame jfvenda) {

        String sql = "insert into carrinho (car_iddisco, car_nomedisco, car_precodisco) values (?,?,?) ";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, disco.getId_disco());
            pst.setString(2, disco.getNome_disco());
            pst.setDouble(3, disco.getPreco_disco());

            pst.execute();

            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, "Erro ao inserir: " + ex);

        }

    }
    
    public void deletar(Carrinho car, JFrame jfvenda) {

        String sql = "delete from carrinho where id_carrinho = ?";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, car.getId_carrinho());

            if (JOptionPane.showConfirmDialog(jfvenda, "Deseja deletar?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
                pst.execute();
                JOptionPane.showMessageDialog(jfvenda, "Deletado com sucesso!");
                con.desconector(conexao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfvenda, "Erro ao deletar: " + e);

        }

    }
    
    public void consultaNomeDisco(String nome, JTable tab){
        disco.setNome_disco(nome);
        String sql = "select id_disco as ID, nome_disco as Nome, preco_disco as Preço"
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
    
    public void consultarCliente(String pesquisa, JTable tbCliente, JFrame jfvenda) {

        String sql = "Select id_cliente as ID, nome_cliente as Nome, cpf_cliente as CPF from cliente where nome_cliente like ?";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pesquisa + "%");
            rs = pst.executeQuery();

            tbCliente.setModel(DbUtils.resultSetToTableModel(rs));
            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, ex);
        }

    }
    
    public void consultarItensVenda(JTable tbItens, JFrame jfvenda) {

        String sql = "Select id_carrinho as ID, car_iddisco as Codigo, car_nomedisco as Nome, car_precodisco as Preco from carrinho";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            tbItens.setModel(DbUtils.resultSetToTableModel(rs));
            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, ex);
        }

    }
    
}
