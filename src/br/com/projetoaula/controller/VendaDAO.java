/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import br.com.projetoaula.model.Pedido;
import br.com.projetoaula.model.Carrinho;

/**
 *
 * @author Eduardo
 */
public class VendaDAO {

    Connection conexao = null;
    PreparedStatement pst, pst2 = null;
    ResultSet rs, rs2 = null;

    Conexao con = new Conexao();

    //Método para deletar Pedido
    public void deletarPed(Pedido pedido, JFrame jfvenda) {

        String sql = " ";
        String sql2 = " ";

        try {
            conexao = con.conector();
            pst2 = conexao.prepareStatement(sql2);
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, pedido.getId_pedido());

            if (JOptionPane.showConfirmDialog(jfvenda, "Deseja deletar?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
                pst2.execute();
                pst.execute();
                JOptionPane.showMessageDialog(jfvenda, "Deletado com sucesso!");
                con.desconector(conexao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfvenda, "Erro ao deletar: " + e);

        }

    }

    //Método para inserir Pedido
    public void inserirPed(Pedido pedido, JFrame jfvenda) {

        String sql = "insert into pedido (data_pedido, cliente_pedido, valor_pedido) values (?,?,?) ";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pedido.getData_pedido());
            pst.setInt(2, pedido.getCliente_pedido());
            pst.setDouble(3, pedido.getValor_pedido());

            pst.execute();

            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, "Erro ao inserir: " + ex);

        }

    }

    //Método para deletar Item pedido
    public void deletarItem(Carrinho car, JFrame jfvenda) {

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

    //Método para inserir Item Pedido
    public void inserirItem(JFrame jfvenda, int codpedido) {

        String sql = "select * from carrinho";
        String sql2 = "insert into item_pedido (disco_item_pedido, pedido_item_pedido) values (?,?) ";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
           
              while (rs.next()) {

                pst2 = conexao.prepareStatement(sql2);
                pst2.setInt(1, rs.getInt("car_iddisco"));
                pst2.setInt(2, codpedido);
                pst2.execute();

            }   
            

           

            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, "Erro ao inserir: " + ex);

        }

    }

    public void consultarItensVenda(JTable tbItens, JFrame jfvenda) {

        String sql = "Select id_carrinho as ID, car_iddisco as Codigo, car_nomedisco as Nome, car_precodisco as Preco from Carrinho";

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

    public int consultarPedido(JFrame jfvenda) {

        String sql = "Select * from pedido";
        int codped=0;
        
        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                
                rs.last();
                codped = (rs.getInt("id_pedido"))+1;

            }else{
                codped = 1;
            }

            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, ex);
        }
         return codped;
    }

    public void limparCarrinho(JFrame jfvenda) {

        String sql = "Truncate table carrinho";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.execute();

            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, ex);
        }

    }
    
    public void consultarPedidoFinal(JTable tbConsultaPed, JFrame jfvenda, int codped) {

        String sql = "select id_item_pedido as ID, nome_disco as Nome, preco_disco as Preco, nome_cliente as Cliente from vw_consulta where id_pedido = ?";

        try {
            conexao = con.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, codped);
            rs = pst.executeQuery();

            tbConsultaPed.setModel(DbUtils.resultSetToTableModel(rs));
            con.desconector(conexao);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jfvenda, ex);
        }

    }

}
