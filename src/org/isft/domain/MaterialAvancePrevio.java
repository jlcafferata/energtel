/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.domain;

/**
 *
 * @author Administrador
 */
public class MaterialAvancePrevio {
    private String cod_material;
    private String nombre;
    private String stock_propio_restante;
    private String stock_provisto_restante;
    private String stock_propio_usado;
    private String stock_provisto_usado;


    /**
     * @return the cod_material
     */
    public String getCod_material() {
        return cod_material;
    }

    /**
     * @param cod_material the cod_material to set
     */
    public void setCod_material(String cod_material) {
        this.cod_material = cod_material;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the stock_propio
     */
    public String getStock_propio() {
        return stock_propio_restante;
    }

    /**
     * @param stock_propio the stock_propio to set
     */
    public void setStock_propio(String stock_propio) {
        this.stock_propio_restante = stock_propio;
    }

    /**
     * @return the stock_provisto
     */
    public String getStock_provisto() {
        return stock_provisto_restante;
    }

    /**
     * @param stock_provisto the stock_provisto to set
     */
    public void setStock_provisto(String stock_provisto) {
        this.stock_provisto_restante = stock_provisto;
    }

    /**
     * @return the stock_propio_usado
     */
    public String getStock_propio_usado() {
        return stock_propio_usado;
    }

    /**
     * @param stock_propio_usado the stock_propio_usado to set
     */
    public void setStock_propio_usado(String stock_propio_usado) {
        this.stock_propio_usado = stock_propio_usado;
    }

    /**
     * @return the stock_provisto_usado
     */
    public String getStock_provisto_usado() {
        return stock_provisto_usado;
    }

    /**
     * @param stock_provisto_usado the stock_provisto_usado to set
     */
    public void setStock_provisto_usado(String stock_provisto_usado) {
        this.stock_provisto_usado = stock_provisto_usado;
    }

}
