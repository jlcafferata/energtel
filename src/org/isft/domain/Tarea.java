/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.domain;

/**
 *
 * @author Administrador
 */
public class Tarea {
    private String cod_tarea;
    private String descripcion;
    private String precio;

    /**
     * @return the cod_tarea
     */
    public String getCod_tarea() {
        return cod_tarea;
    }

    /**
     * @param cod_tarea the cod_tarea to set
     */
    public void setCod_tarea(String cod_tarea) {
        this.cod_tarea = cod_tarea;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
