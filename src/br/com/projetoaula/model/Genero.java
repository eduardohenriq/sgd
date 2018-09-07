/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.model;

/**
 *
 * @author Eduardo
 */
public class Genero {

    /**
     * @return the id_genero
     */
    public int getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    /**
     * @return the nome_genero
     */
    public String getNome_genero() {
        return nome_genero;
    }

    /**
     * @param nome_genero the nome_genero to set
     */
    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
    
    private int id_genero;
    private String nome_genero;
    
}
