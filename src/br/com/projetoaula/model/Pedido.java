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
public class Pedido {
    
    private int id_pedido;
    private String data_pedido;
    private int cliente_pedido;
    private double valor_pedido;

    /**
     * @return the id_pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * @return the data_pedido
     */
    public String getData_pedido() {
        return data_pedido;
    }

    /**
     * @param data_pedido the data_pedido to set
     */
    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    /**
     * @return the cliente_pedido
     */
    public int getCliente_pedido() {
        return cliente_pedido;
    }

    /**
     * @param cliente_pedido the cliente_pedido to set
     */
    public void setCliente_pedido(int cliente_pedido) {
        this.cliente_pedido = cliente_pedido;
    }

    /**
     * @return the valor_pedido
     */
    public double getValor_pedido() {
        return valor_pedido;
    }

    /**
     * @param valor_pedido the valor_pedido to set
     */
    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }
    
}
