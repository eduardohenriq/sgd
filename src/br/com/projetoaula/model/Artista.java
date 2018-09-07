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
public class Artista {

    /**
     * @return the id_artista
     */
    public int getId_artista() {
        return id_artista;
    }

    /**
     * @param id_artista the id_artista to set
     */
    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    /**
     * @return the nome_artista
     */
    public String getNome_artista() {
        return nome_artista;
    }

    /**
     * @param nome_artista the nome_artista to set
     */
    public void setNome_artista(String nome_artista) {
        this.nome_artista = nome_artista;
    }
    
    private int id_artista;
    private String nome_artista;
    
}
