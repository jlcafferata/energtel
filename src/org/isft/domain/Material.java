package org.isft.domain;

public class Material{
    private String codigo;
    private String descripcion;
    private String stock;

    public String getCodigo() {
        return codigo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the stock
     */
    public String getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(String stock) {
        this.stock = stock;
    }
}