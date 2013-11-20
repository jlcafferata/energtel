package org.isft.domain;

public class DetalleObra{
    private String poa;
    private String estado;
    private String cuit_cliente;
    private String fecha_certificacion;
    private String cod_zona;
    private String fecha_facturacion;
    private String cod_tipo_obra;
    private String medicion_estimada;
    private String nro_recibo;
    private String cod_especificacion;
    private String cod_forma_obra;
    private String fecha_inicio;
    private String fecha_cierre;
    private String razon_social;
    private String descripcion_zona;
    private String descripcion_tipo_obra;
    private String descripcion_forma_obra;
    private String orden_compra;
    private String valor_orden_compra;
    private String observaciones;
		private String descripcion_especificacion;

		public String getPoa(){
                    if(poa==null){
                        poa="";
                    }
		 	return this.poa;
		}
		 
		public String getRazon_social(){
                    if(razon_social==null){
                        razon_social="";
                    }
		 	return this.razon_social;
		}
		  
        public String getDescripcion_zona(){
                if(descripcion_zona==null){
                    descripcion_zona="";
                }
	 	return this.descripcion_zona;
	}
		 
	public String getDescripcion_tipo_obra(){
              if(descripcion_tipo_obra==null){
                  descripcion_tipo_obra="";
              }
	 	return this.descripcion_tipo_obra;
	}
	public String getDescripcion_forma_obra(){
            if(descripcion_forma_obra==null){
                descripcion_forma_obra="";
            }
	 	return this.descripcion_forma_obra;
	}
	public String getOrden_compra(){
             if(orden_compra==null){
                 orden_compra="";
             }
            return this.orden_compra;
	}
	public String getValor_orden_compra(){
              if(valor_orden_compra==null){
                  valor_orden_compra="";
              }
              return this.valor_orden_compra;
	}
	public String getObservaciones(){
            if(observaciones==null){
                observaciones="";
            }
		 	return this.observaciones;
		}
		
    public String getFecha_inicio(){
       if(fecha_inicio==null){
            fecha_inicio="";
        } 
       return this.fecha_inicio;
    } 
    public String getFecha_cierre(){
    	if(fecha_cierre==null){
            fecha_cierre="";
        }
        return this.fecha_cierre;
    }
    public String getDescripcion_especificacion(){
    	if(descripcion_especificacion==null){
            descripcion_especificacion="";
        }
        return this.descripcion_especificacion;
    }
    
    
    public void setPoa(String value) {
        this.poa = value;
    }    
    public void setRazon_social(String value) {
        this.razon_social = value;
    }    
    public void setDescripcion_zona(String value) {
        this.descripcion_zona = value;
    }    
    public void setDescripcion_tipo_obra(String value) {
        this.descripcion_tipo_obra = value;
    }    
    public void setDescripcion_forma_obra(String value) {
        this.descripcion_forma_obra = value;
    }    
    public void setOrden_compra(String value) {
        this.orden_compra = value;
    }    
    public void setValor_orden_compra(String value) {
        this.valor_orden_compra= value;
    }    
    public void setObservaciones(String value) {
        this.observaciones = value;
    }   
    
    public void setFecha_inicio(String fecha_inicio){
    	this.fecha_inicio=fecha_inicio;
    }
    
    public void setFecha_cierre(String fecha_cierre){
    	this.fecha_cierre=fecha_cierre;
    }
    
    public void setDescripcion_especificacion(String value){
    	this.descripcion_especificacion=value;
    }

    /**
     * @return the cuit_cliente
     */
    public String getCuit_cliente() {
        if(cuit_cliente==null){
            cuit_cliente="";
        }
        return cuit_cliente;
    }

    /**
     * @param cuit_cliente the cuit_cliente to set
     */
    public void setCuit_cliente(String cuit_cliente) {
        this.cuit_cliente = cuit_cliente;
    }

    /**
     * @return the fecha_certificacion
     */
    public String getFecha_certificacion() {
        if(fecha_certificacion==null){
            fecha_certificacion="";
        }
        return fecha_certificacion;
    }

    /**
     * @param fecha_certificacion the fecha_certificacion to set
     */
    public void setFecha_certificacion(String fecha_certificacion) {
        this.fecha_certificacion = fecha_certificacion;
    }

    /**
     * @return the cod_zona
     */
    public String getCod_zona() {
        if(cod_zona==null){
            cod_zona="";
        }
        return cod_zona;
    }

    /**
     * @param cod_zona the cod_zona to set
     */
    public void setCod_zona(String cod_zona) {
        this.cod_zona = cod_zona;
    }

    /**
     * @return the cod_tipo_obra
     */
    public String getCod_tipo_obra() {
        if(cod_tipo_obra==null){
            cod_tipo_obra="";
        }
        return cod_tipo_obra;
    }

    /**
     * @param cod_tipo_obra the cod_tipo_obra to set
     */
    public void setCod_tipo_obra(String cod_tipo_obra) {
        this.cod_tipo_obra = cod_tipo_obra;
    }

    /**
     * @return the medicion_estimada
     */
    public String getMedicion_estimada() {
        if(medicion_estimada==null){
            medicion_estimada="";
        }
        return medicion_estimada;
    }

    /**
     * @param medicion_estimada the medicion_estimada to set
     */
    public void setMedicion_estimada(String medicion_estimada) {
        this.medicion_estimada = medicion_estimada;
    }

    /**
     * @return the cod_especificacion
     */
    public String getCod_especificacion() {
        if(cod_especificacion==null){
            cod_especificacion="";
        }
        return cod_especificacion;
    }

    /**
     * @param cod_especificacion the cod_especificacion to set
     */
    public void setCod_especificacion(String cod_especificacion) {
        this.cod_especificacion = cod_especificacion;
    }

    /**
     * @return the cod_forma_obra
     */
    public String getCod_forma_obra() {
        if(cod_forma_obra==null){
            cod_forma_obra="";
        }
        return cod_forma_obra;
    }

    /**
     * @param cod_forma_obra the cod_forma_obra to set
     */
    public void setCod_forma_obra(String cod_forma_obra) {
        this.cod_forma_obra = cod_forma_obra;
    }

    /**
     * @return the fecha_pago
     */
    public String getFecha_facturacion() {
        if(fecha_facturacion==null){
            fecha_facturacion="";
        }
        return fecha_facturacion;
    }

    /**
     * @param fecha_pago the fecha_pago to set
     */
    public void setFecha_facturacion(String fecha_pago) {
        this.fecha_facturacion = fecha_pago;
    }

    /**
     * @return the nro_recibo
     */
    public String getNro_recibo() {
        if(nro_recibo==null){
            nro_recibo="";
        }
        return nro_recibo;
    }

    /**
     * @param nro_recibo the nro_recibo to set
     */
    public void setNro_recibo(String nro_recibo) {
        this.nro_recibo = nro_recibo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}