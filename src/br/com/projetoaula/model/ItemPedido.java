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
public class ItemPedido {
    
    private int disco_item_pedido;
    private int pedido_item_pedido;


    /**
     * @return the disco_item_pedido
     */
    public int getDisco_item_pedido() {
        return disco_item_pedido;
    }

    /**
     * @param disco_item_pedido the disco_item_pedido to set
     */
    public void setDisco_item_pedido(int disco_item_pedido) {
        this.disco_item_pedido = disco_item_pedido;
    }

    /**
     * @return the pedido_item_pedido
     */
    public int getPedido_item_pedido() {
        return pedido_item_pedido;
    }

    /**
     * @param pedido_item_pedido the pedido_item_pedido to set
     */
    public void setPedido_item_pedido(int pedido_item_pedido) {
        this.pedido_item_pedido = pedido_item_pedido;
    }
    
}
