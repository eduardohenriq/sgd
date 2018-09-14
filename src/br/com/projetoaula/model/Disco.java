/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoaula.model;

import java.sql.Date;

/**
 *
 * @author Eduardo
 */
public class Disco {

    /**
     * @return the id_disco
     */
    public int getId_disco() {
        return id_disco;
    }

    /**
     * @param id_disco the id_disco to set
     */
    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    /**
     * @return the nome_disco
     */
    public String getNome_disco() {
        return nome_disco;
    }

    /**
     * @param nome_disco the nome_disco to set
     */
    public void setNome_disco(String nome_disco) {
        this.nome_disco = nome_disco;
    }

    /**
     * @return the lancamento_disco
     */
    public int getLancamento_disco() {
        return lancamento_disco;
    }

    /**
     * @param lancamento_disco the lancamento_disco to set
     */
    public void setLancamento_disco(int lancamento_disco) {
        this.lancamento_disco = lancamento_disco;
    }

    /**
     * @return the duracao_disco
     */
    public int getDuracao_disco() {
        return duracao_disco;
    }

    /**
     * @param duracao_disco the duracao_disco to set
     */
    public void setDuracao_disco(int duracao_disco) {
        this.duracao_disco = duracao_disco;
    }

    /**
     * @return the preco_disco
     */
    public double getPreco_disco() {
        return preco_disco;
    }

    /**
     * @param preco_disco the preco_disco to set
     */
    public void setPreco_disco(double preco_disco) {
        this.preco_disco = preco_disco;
    }

    /**
     * @return the faixas_disco
     */
    public int getFaixas_disco() {
        return faixas_disco;
    }

    /**
     * @param faixas_disco the faixas_disco to set
     */
    public void setFaixas_disco(int faixas_disco) {
        this.faixas_disco = faixas_disco;
    }

    /**
     * @return the artista_disco
     */
    public int getArtista_disco() {
        return artista_disco;
    }

    /**
     * @param artista_disco the artista_disco to set
     */
    public void setArtista_disco(int artista_disco) {
        this.artista_disco = artista_disco;
    }

    /**
     * @return the genero_disco
     */
    public int getGenero_disco() {
        return genero_disco;
    }

    /**
     * @param genero_disco the genero_disco to set
     */
    public void setGenero_disco(int genero_disco) {
        this.genero_disco = genero_disco;
    }

    /**
     * @return the capa_disco
     */
    public String getCapa_disco() {
        return capa_disco;
    }

    /**
     * @param capa_disco the capa_disco to set
     */
    public void setCapa_disco(String capa_disco) {
        this.capa_disco = capa_disco;
    }
    
    private int id_disco;
    private String nome_disco;
    private int lancamento_disco;
    private int duracao_disco;
    private double preco_disco;
    private int faixas_disco;
    private int artista_disco;
    private int genero_disco;
    private String capa_disco;
    
}
