/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.controller;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Eduardo
 */
public class Servicos {
    
    
    public int flag = 0;
    private int xMouse;
    private int yMouse;
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
            JTextField preco, JTextField faixas, JTextField capa, JComboBox gen, JComboBox art, JTable tab){
        
        id.setText("");
        nome.setText("");
        ano.setText("");
        duracao.setText("");
        preco.setText("");
        faixas.setText("");
        capa.setText("");
        gen.setSelectedIndex(0);
        art.setSelectedIndex(0);
        ((DefaultTableModel)tab.getModel()).setRowCount(0);
        
        
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
        String dst = "\\src\\capas\\";
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
    
    //MÉTODO PARA VALIDAS OS CAMPOS NA FRAME DISCO
    public boolean validaDisco(JTextField nome, JTextField ano, JTextField duracao, JTextField faixas, 
            JTextField preco){
        if(nome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo nome está vazio!");
            nome.requestFocus();
            return false;
        }else if(ano.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo ano está vazio!");
            ano.requestFocus();
            return false;
        }else if(duracao.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo duração está vazio!");
            duracao.requestFocus();
            return false;
        }else if(faixas.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo faixas está vazio!");
            faixas.requestFocus();
            return false;
        }else if(preco.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo preço está vazio!");
            preco.requestFocus();
            return false;
        }else{
            return true;
        }
    }
    
    public void mudaCorDiscos(JTextField titulo, JTextField ano,
                JTextField duracao, JTextField faixas, JTextField preco, JTextField capa){
        if(titulo.isEditable()){
            titulo.setBackground(new java.awt.Color(108,122,137));
        }else{
            titulo.setBackground(new java.awt.Color(36, 37, 42));
        }
        if(ano.isEditable()){
            ano.setBackground(new java.awt.Color(108,122,137));
        }else{
            ano.setBackground(new java.awt.Color(36, 37, 42));
        }
        if(duracao.isEditable()){
            duracao.setBackground(new java.awt.Color(108,122,137));
        }else{
            duracao.setBackground(new java.awt.Color(36, 37, 42));
        }
        if(faixas.isEditable()){
            faixas.setBackground(new java.awt.Color(108,122,137));
        }else{
            faixas.setBackground(new java.awt.Color(36, 37, 42));
        }
        if(preco.isEditable()){
            preco.setBackground(new java.awt.Color(108,122,137));
        }else{
            preco.setBackground(new java.awt.Color(36, 37, 42));
        }
        if(capa.isEditable()){
            capa.setBackground(new java.awt.Color(108,122,137));
        }else{
            capa.setBackground(new java.awt.Color(36, 37, 42));
        }
        }
    
    public void travaBotaoCapa(JButton carregar, JButton usar){
        carregar.setEnabled(false);
        usar.setEnabled(false);
    }
    
    public void destravaBotaoCapa(JButton carregar, JButton usar){
        carregar.setEnabled(true);
        usar.setEnabled(true);
    }
        
    
    // SERVIÇOS PARA O FRAME USUÁRIOS
    
    //MÉTODO PARA SETAR AS INFORMAÇÕES DAS LINHAS SELECIONADAS NA TABELA NOS CAMPOS
    public void setarCamposUsuario(JTable tab, JTextField id, JTextField nome, JTextField login,
            JPasswordField senha, JComboBox tipo){
        
        int setar = tab.getSelectedRow();
        
        id.setText(tab.getModel().getValueAt(setar, 0).toString());
        nome.setText(tab.getModel().getValueAt(setar, 1).toString());
        login.setText(tab.getModel().getValueAt(setar, 2).toString());
        tipo.setSelectedItem(tab.getModel().getValueAt(setar,3));
    }
    
    //MÉTODO PARA DESTRAVAR OS CAMPOS NO FRAME USUÁRIO
    public void destravarUsuario(JTextField nome, JTextField login, JPasswordField senha, 
            JPasswordField senhaConfirm, JComboBox tipo){
        
        nome.setEditable(true);
        login.setEditable(true);
        senha.setEditable(true);
        senhaConfirm.setEditable(true);
        tipo.setEnabled(true);
    }
    
    //MÉTODO PARA TRAVAR OS CAMPOS NO FRAME USUÁRIO
    public void travarUsuario(JTextField nome, JTextField login, JPasswordField senha, 
            JPasswordField senhaConfirm, JComboBox tipo){
        
        nome.setEditable(false);
        login.setEditable(false);
        senha.setEditable(false);
        senhaConfirm.setEditable(false);
        tipo.setEnabled(false);
    }
    
    //MÉTODO PARA LIMPAR OS CAMPOS NO FRAME USUÁRIO
        public void limparUsuario(JTextField id, JTextField nome, JTextField login,
                JPasswordField senha, JPasswordField senhaConfirm, JComboBox tipo, JTable tab){
        
        id.setText("");
        nome.setText("");
        login.setText("");
        senha.setText("");
        senhaConfirm.setText("");
        tipo.setSelectedIndex(0);
        ((DefaultTableModel)tab.getModel()).setRowCount(0);
    }
        
    //MÉTODO PARA CONFIRMAR SENHA
        public boolean confirmarSenha(String senha, String senhaConfirm){
            if(senha.equals(senhaConfirm)){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "As senhas não conferem!");
                return false;
            }
        }
        
    //MÉTODO PARA VALIDAR OS CAMPOS
        public boolean validaUsuario(JTextField nome, JTextField login, JPasswordField senha, 
                JPasswordField senhaConfirm){
            if(nome.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo nome está vazio!");
                nome.requestFocus();
                return false;
            }else if(login.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo login está vazio!");
                login.requestFocus();
                return false;
            }else if(senha.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo senha está vazio!");
                senha.requestFocus();
                return false;
            }else if(senhaConfirm.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Confirme sua senha!");
                senhaConfirm.requestFocus();
                return false;
            }else{
                return true;
            }
        }
        
        public void mudaCorUsuario(JTextField nome, JTextField login, JPasswordField senha,
                JPasswordField confirmSenha){
            if(nome.isEditable()){
                nome.setBackground(new java.awt.Color(108,122,137));
            }else{
                nome.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(login.isEditable()){
                login.setBackground(new java.awt.Color(108,122,137));
            }else{
                login.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(senha.isEditable()){
                senha.setBackground(new java.awt.Color(108,122,137));
            }else{
                senha.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(confirmSenha.isEditable()){
                confirmSenha.setBackground(new java.awt.Color(108,122,137));
            }else{
                confirmSenha.setBackground(new java.awt.Color(36, 37, 42));
            }
        }
        
    //SERVIÇOS PARA FRAME CLIENTE
        
    //MÉTODO PARA SETAR AS INFORMAÇÕES DAS LINHAS SELECIONADAS NA TABELA NOS CAMPOS
    public void setarCamposCliente(JTable tab, JTextField id, JTextField nome, JTextField endereco,
            JTextField telefone, JTextField cpf){
        
        int setar = tab.getSelectedRow();
        
        id.setText(tab.getModel().getValueAt(setar, 0).toString());
        nome.setText(tab.getModel().getValueAt(setar, 1).toString());
        endereco.setText(tab.getModel().getValueAt(setar, 2).toString());
        telefone.setText(tab.getModel().getValueAt(setar, 3).toString());
        cpf.setText(tab.getModel().getValueAt(setar, 4).toString());
    }
    
    //MÉTODO PARA DESTRAVAR OS CAMPOS NO FRAME USUÁRIO
    public void destravarCliente(JTextField nome, JTextField endereco, JTextField telefone, 
            JTextField cpf){
        
        nome.setEditable(true);
        endereco.setEditable(true);
        telefone.setEditable(true);
        cpf.setEditable(true);
    }
    
    //MÉTODO PARA TRAVAR OS CAMPOS NO FRAME CLIENTE
    public void travarCliente(JTextField nome, JTextField endereco, JTextField telefone, 
            JTextField cpf){
        
        nome.setEditable(false);
        endereco.setEditable(false);
        telefone.setEditable(false);
        cpf.setEditable(false);
    }
    
    //MÉTODO PARA LIMPAR OS CAMPOS NO FRAME CLIENTE
        public void limparCliente(JTextField id, JTextField nome, JTextField endereco,
                JTextField telefone, JTextField cpf, JTable tab){
        
        id.setText("");
        nome.setText("");
        endereco.setText("");
        telefone.setText("");
        cpf.setText("");
        ((DefaultTableModel)tab.getModel()).setRowCount(0);
    }
        
    //MÉTODO PARA VALIDAR OS CAMPOS
        public boolean validaCliente(JTextField nome, JTextField endereco, JTextField telefone, 
                JTextField cpf){
            if(nome.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo nome está vazio!");
                nome.requestFocus();
                return false;
            }else if(endereco.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo endereço está vazio!");
                endereco.requestFocus();
                return false;
            }else if(telefone.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo telefone está vazio!");
                telefone.requestFocus();
                return false;
            }else if(cpf.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo cpf está vazio!");
                cpf.requestFocus();
                return false;
            }else{
                return true;
            }
        }
        
        public void mudaCorCliente(JTextField nome, JTextField endereco, JTextField telefone,
                JTextField cpf){
            if(nome.isEditable()){
                nome.setBackground(new java.awt.Color(108,122,137));
            }else{
                nome.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(endereco.isEditable()){
                endereco.setBackground(new java.awt.Color(108,122,137));
            }else{
                endereco.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(telefone.isEditable()){
                telefone.setBackground(new java.awt.Color(108,122,137));
            }else{
                telefone.setBackground(new java.awt.Color(36, 37, 42));
            }
            if(cpf.isEditable()){
                cpf.setBackground(new java.awt.Color(108,122,137));
            }else{
                cpf.setBackground(new java.awt.Color(36, 37, 42));
            }
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
    public void limparArtista(JTextField id, JTextField nome, JTable tab){
        id.setText("");
        nome.setText("");
        ((DefaultTableModel)tab.getModel()).setRowCount(0);
    }
    
    //MÉTODO PARA VALIDAR OS CAMPOS NO FRAME ARTISTA
    public boolean validaArtista(JTextField nome){
        if(nome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira um nome!");
            nome.requestFocus();
            return false;
        }else{
            return true;
        }
    }
    
    //MÉTODO PARA MUDAR COR DO TEXTBOX NA FRAME ARTISTA
    public void mudaCorArtista(JTextField nome){
        if(nome.isEditable()){
            nome.setBackground(new java.awt.Color(108,122,137));
        }else{
            nome.setBackground(new java.awt.Color(36, 37, 42));
        }
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
        
        inserir.setEnabled(true);
        alterar.setEnabled(true);
        remover.setEnabled(true);
        
    }
    
    public void limparTabela(JTable tab){
        tab.clearSelection();
    }
    
    //
    public void clicarMouse(java.awt.event.MouseEvent evt){
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    public void arrastarMouse(java.awt.event.MouseEvent evt, JFrame f){
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        f.setLocation(x - xMouse, y - yMouse);
    }
}
