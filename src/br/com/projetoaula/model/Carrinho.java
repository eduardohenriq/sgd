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
public class Carrinho {
    
    private int id_carrinho;
    private int car_iddisco;
    private String car_nomedisco;
    private double car_precodisco;

    /**
     * @return the id_carrinho
     */
    public int getId_carrinho() {
        return id_carrinho;
    }

    /**
     * @param id_carrinho the id_carrinho to set
     */
    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    /**
     * @return the car_iddisco
     */
    public int getCar_iddisco() {
        return car_iddisco;
    }

    /**
     * @param car_iddisco the car_iddisco to set
     */
    public void setCar_iddisco(int car_iddisco) {
        this.car_iddisco = car_iddisco;
    }

    /**
     * @return the car_nomedisco
     */
    public String getCar_nomedisco() {
        return car_nomedisco;
    }

    /**
     * @param car_nomedisco the car_nomedisco to set
     */
    public void setCar_nomedisco(String car_nomedisco) {
        this.car_nomedisco = car_nomedisco;
    }

    /**
     * @return the car_precodisco
     */
    public double getCar_precodisco() {
        return car_precodisco;
    }

    /**
     * @param car_precodisco the car_precodisco to set
     */
    public void setCar_precodisco(double car_precodisco) {
        this.car_precodisco = car_precodisco;
    }
    
}
