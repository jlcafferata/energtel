package org.isft.domain;

public class Material{
    private String codigo;
    private String descripcion;
    private String stock_propio;
    private String stock_provisto;

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
     * @return the stock_propio
     */
    public String getStock_propio() {
        return stock_propio;
    }

    /**
     * @param stock_propio the stock_propio to set
     */
    public void setStock_propio(String stock_propio) {
        this.stock_propio = stock_propio;
    }

    /**
     * @return the stock_provisto
     */
    public String getStock_provisto() {
        return stock_provisto;
    }

    /**
     * @param stock_provisto the stock_provisto to set
     */
    public void setStock_provisto(String stock_provisto) {
        this.stock_provisto = stock_provisto;
    }

}