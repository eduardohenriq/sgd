/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import java.io.*;
import javax.swing.*;
/**
 *
 * @author Eduardo
 */
public class Servicos {
    
    
    public int flag = 0;
    
    // SERVIÇOS PARA O FRAME DISCOS
    
    
    //MÉTODO PARA SETAR AS INFORMAÇÕES DA LINHA SELECIONADA NA TABELA NOS CAMPOS
    public void setarCamposDisco(JTable tab, JTextField id, JTextField nome, JTextField ano,
            JTextField duracao, JTextField preco, JTextField faixas, JComboBox gen, JComboBox art, 
            JTextField capa){
        
        int setar = tab.getSelectedRow();
                
        id.setText(tab.getModel().getValueAt(setar, 0).toString());
        nome.setText(tab.getModel().getValueAt(setar, 1).toString());
        ano.setText(tab.getModel().getValueAt(setar, 2).toString());
        duracao.setText(tab.getModel().getValueAt(setar, 3).toString());
        preco.setText(tab.getModel().getValueAt(setar, 4).toString());
        faixas.setText(tab.getModel().getValueAt(setar, 5).toString());
        art.setSelectedIndex((int)tab.getModel().getValueAt(setar, 6)-1);
        gen.setSelectedIndex((int)tab.getModel().getValueAt(setar, 7)-1);
        capa.setText(tab.getModel().getValueAt(setar, 8).toString());
    }
    
    //MÉTODO PARA TRAVAR OS CAMPOS NO FRAME DISCOS
    public void travarDiscos(JTextField nome, JTextField ano, JTextField duracao,
            JTextField preco, JTextField faixas, JTextField capa, JComboBox gen, JComboBox art){
        
        nome.setEditable(false);
        ano.setEditable(false);
        duracao.setEditable(false);
        preco.setEditable(false);
        faixas.setEditable(false);
        capa.setEditable(false);
        gen.setEnabled(false);
        art.setEnabled(false);
        
    }
    
    //MÉTODO PARA DESTRAVAR OS CAMPOS NO FRAME DISCOS
    public void destravarDiscos(JTextField nome, JTextField ano, JTextField duracao,
            JTextField preco, JTextField faixas, JTextField capa, JComboBox gen, JComboBox art){
        
        nome.setEditable(true);
        ano.setEditable(true);
        duracao.setEditable(true);
        preco.setEditable(true);
        faixas.setEditable(true);
        capa.setEditable(true);
        gen.setEnabled(true);
        art.setEnabled(true);
        
    }
    
    //MÉTODO PARA LIMPAR OS CAMPOS NO FRAME DISCOS
    public void limparDiscos(JTextField id, JTextField nome, JTextField ano, JTextField duracao,
            JTextField preco, JTextField faixas, JTextField capa, JComboBox gen, JComboBox art){
        
        id.setText("");
        nome.setText("");
        ano.setText("");
        duracao.setText("");
        preco.setText("");
        faixas.setText("");
        capa.setText("");
        gen.setSelectedIndex(0);
        art.setSelectedIndex(0);
        
        
    }
    
    //SERVIÇO PARA SELECIONAR A IMAGEM AUTOMATICAMENTE CASO O CAMPO FIQUE EM BRANCO
    public void verificaCapa(JTextField capa){
        if(capa.getText().equals("")){
            capa.setText(System.getProperty("user.dir")+"/src/imagens/semcapa.jpg");
        }
    }
    
    //MÉTODO PARA TRANSFERIR IMAGEM PARA PASTA DO PROJETO
    public String transfereImg(String capa){
        try{
        String dst = "\\src\\capas";
        File f = new File(capa);
        
        FileInputStream in = new FileInputStream(capa);
        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+dst+f.getName());
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
        
        return System.getProperty("user.dir")+dst+f.getName();
        
        }catch(Exception e){
            System.out.println("Erro: "+e);
            return null;
        }
        
    }
        
    
    // SERVIÇOS PARA O FRAME USUÁRIOS
    
    //MÉTODO PARA SETAR AS INFORMAÇÕES DAS LINHAS SELECIONADAS NA TABELA NOS CAMPOS
    public void setarCamposUsuario(JTable tab, JTextField id, JTextField nome, JTextField login,
            JPasswordField senha, JComboBox tipo){
        
        int setar = tab.getSelectedRow();
        
        id.setText(tab.getModel().getValueAt(setar, 0).toString());
        nome.setText(tab.getModel().getValueAt(setar, 1).toString());
        login.setText(tab.getModel().getValueAt(setar, 2).toString());
        senha.setText(tab.getModel().getValueAt(setar, 3).toString());
        tipo.setSelectedIndex((int)tab.getModel().getValueAt(setar, 4)-1);
    }
    
    //MÉTODO PARA DESTRAVAR OS CAMPOS NO FRAME USUÁRIO
    public void destravarUsuario(JTextField nome, JTextField login, JPasswordField senha, 
            JComboBox tipo){
        
        nome.setEditable(true);
        login.setEditable(true);
        senha.setEditable(true);
        tipo.setEnabled(true);
    }
    
    //MÉTODO PARA TRAVAR OS CAMPOS NO FRAME USUÁRIO
    public void travarUsuario(JTextField nome, JTextField login, JPasswordField senha, 
            JComboBox tipo){
        
        nome.setEditable(false);
        login.setEditable(false);
        senha.setEditable(false);
        tipo.setEnabled(false);
    }
    
    //MÉTODO PARA LIMPAR OS CAMPOS NO FRAME USUÁRIO
        public void limparUsuario(JTextField id, JTextField nome, JTextField login,
                JPasswordField senha, JComboBox tipo){
        
        id.setText("");
        nome.setText("");
        login.setText("");
        senha.setText("");
        tipo.setSelectedIndex(0);
    }
        
        
    //SERVIÇOS PARA O FRAME ARTISTA
        
    //MÉTODO PARA SETAR AS INFORMAÇÕES DAS LINHAS SELECIONADAS NA TABELA NOS CAMPOS
    public void setarCamposArtista(JTable tab, JTextField id, JTextField nome){
        
        int setar = tab.getSelectedRow();
        
        id.setText(tab.getModel().getValueAt(setar, 0).toString());
        nome.setText(tab.getModel().getValueAt(setar, 1).toString());
    }
    
    //MÉTODO PARA DESTRAVAR OS CAMPOS NO FRAME ARTISTA
    public void destravarArtista(JTextField nome){
        nome.setEditable(true);
    }
    
    //MÉTODO PARA TRAVAR O CAMPO  NO FRAME ARTISTA
    public void travarArtista(JTextField nome){
        nome.setEditable(false);
    }
    
    //MÉTODO PARA LIMPAR O CAMPO NO FRAME ARTISTA
    public void limparArtista(JTextField id, JTextField nome){
        id.setText("");
        nome.setText("");
    }
    
    
    
    //MÉTODOS PARA TODAS AS FRAMES
    
    //MÉTODO PARA PADRONIZAR OS BOTÕES
    public void padraoBotoes(JButton inserir, JButton alterar, JButton remover, 
            JButton cancelar, JButton salvar){
        inserir.setEnabled(true);
        alterar.setEnabled(false);
        remover.setEnabled(false);
        cancelar.setEnabled(false);
        salvar.setEnabled(false);
    }
    
    //MÉTODO PARA HABILITAR/DESABILITAR BOTÕES AO CLICAR NO INSERIR
    public void clicarInserir(JButton inserir, JButton cancelar, JButton salvar){
        flag = 0;
        inserir.setEnabled(false);
        cancelar.setEnabled(true);
        salvar.setEnabled(true);
    }
    
    //MÉTODO PARA HABILITAR/DESABILITAR BOTÕES AO CLICAR NO ALTERAR
    public void clicarAlterar(JButton inserir, JButton alterar, JButton cancelar, JButton salvar){
        flag = 1;
        inserir.setEnabled(false);
        alterar.setEnabled(false);
        cancelar.setEnabled(true);
        salvar.setEnabled(true);
    }
    
    //MÉTODO PARA HABILITAR/DESABILITAR BOTÕES AO CLICAR EM UM ITEM NA TABELA
    public void clicarTabela(JButton inserir, JButton alterar, JButton remover, JButton cancelar, 
            JButton salvar){
        
        inserir.setEnabled(false);
        alterar.setEnabled(true);
        remover.setEnabled(true);
        
    }
    
    public void limparTabela(JTable tab){
        tab.clearSelection();
    }
    
}
