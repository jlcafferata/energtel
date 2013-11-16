package org.isft.domain;

public class Empleado{
    private String legajo;	
    private String apellido;	
    private String nombre;	
    private String tipo_documento;	
    private String numero_documento;	
    private String cod_categoria;
    private String desc_categoria;
    private String desc_situacion;
    private String cuil;
    private String fecha_nacimiento;	
    private String nacionalidad;	
    private String cod_estado_civil;	
    private String cantidad_hijos;	
    private String cod_estudio;	
    private String telefono;	
    private String celular;	
    private String e_mail;	
    private String talle_pantalon;	
    private String talle_camisa;	
    private String calzado;	
    private String nro_libreta_cese;	
    private String nro_cta_cese_laboral;	
    private String fecha_alta;	
    private String fecha_baja;	
    private String cod_situacion;	
    private String domicilio_real;	
    private String nro_real;	
    private String partido_real;	
    private String localidad_real;	
    private String provincia_real;	
    private String cp_real;	
    private String domicilio_legal;	
    private String nro_legal;	
    private String partido_legal;	
    private String localidad_legal;	
    private String provincia_legal;	
    private String cp_legal;

    /**
     * @return the legajo
     */
    public String getLegajo() {
        return legajo;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return (apellido==null?"":apellido);
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return (nombre==null?"":nombre);
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo_documento
     */
    public String getTipo_documento() {
        return (tipo_documento==null?"":tipo_documento);
    }

    /**
     * @param tipo_documento the tipo_documento to set
     */
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    /**
     * @return the numero_documento
     */
    public String getNumero_documento() {
        return (numero_documento==null?"":numero_documento);
    }

    /**
     * @param numero_documento the numero_documento to set
     */
    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    /**
     * @return the cod_categoria
     */
    public String getCod_categoria() {
        return (cod_categoria==null?"":cod_categoria);
    }

    /**
     * @param cod_categoria the cod_categoria to set
     */
    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    /**
     * @return the cuil
     */
    public String getCuil() {
        return (cuil==null?"":cuil);
    }

    /**
     * @param cuil the cuil to set
     */
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return (fecha_nacimiento==null?"":fecha_nacimiento);
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return (nacionalidad==null?"ARGENTINO":nacionalidad);
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the cod_estado_civil
     */
    public String getCod_estado_civil() {
        return (cod_estado_civil==null?"":cod_estado_civil);
    }

    /**
     * @param cod_estado_civil the cod_estado_civil to set
     */
    public void setCod_estado_civil(String cod_estado_civil) {
        this.cod_estado_civil = cod_estado_civil;
    }

    /**
     * @return the cantidad_hijos
     */
    public String getCantidad_hijos() {
        return (cantidad_hijos==null?"0":cantidad_hijos);
    }

    /**
     * @param cantidad_hijos the cantidad_hijos to set
     */
    public void setCantidad_hijos(String cantidad_hijos) {
        this.cantidad_hijos = cantidad_hijos;
    }

    /**
     * @return the cod_estudio
     */
    public String getCod_estudio() {
        return (cod_estudio==null?"":cod_estudio);
    }

    /**
     * @param cod_estudio the cod_estudio to set
     */
    public void setCod_estudio(String cod_estudio) {
        this.cod_estudio = cod_estudio;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return (telefono==null?"":telefono);
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return (celular==null?"":celular);
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the e_mail
     */
    public String getE_mail() {
        return (e_mail==null?"":e_mail);
    }

    /**
     * @param e_mail the e_mail to set
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
     * @return the talle_pantalon
     */
    public String getTalle_pantalon() {
        return (talle_pantalon==null?"":talle_pantalon);
    }

    /**
     * @param talle_pantalon the talle_pantalon to set
     */
    public void setTalle_pantalon(String talle_pantalon) {
        this.talle_pantalon = talle_pantalon;
    }

    /**
     * @return the talle_camisa
     */
    public String getTalle_camisa() {
        return (talle_camisa==null?"":talle_camisa);
    }

    /**
     * @param talle_camisa the talle_camisa to set
     */
    public void setTalle_camisa(String talle_camisa) {
        this.talle_camisa = talle_camisa;
    }

    /**
     * @return the calzado
     */
    public String getCalzado() {
        return (calzado==null?"":calzado);
    }

    /**
     * @param calzado the calzado to set
     */
    public void setCalzado(String calzado) {
        this.calzado = calzado;
    }

    /**
     * @return the nro_libreta_cese
     */
    public String getNro_libreta_cese() {
        return (nro_libreta_cese==null?"":nro_libreta_cese);
    }

    /**
     * @param nro_libreta_cese the nro_libreta_cese to set
     */
    public void setNro_libreta_cese(String nro_libreta_cese) {
        this.nro_libreta_cese = nro_libreta_cese;
    }

    /**
     * @return the nro_cta_cese_laboral
     */
    public String getNro_cta_cese_laboral() {
        return (nro_cta_cese_laboral==null?"":nro_cta_cese_laboral);
    }

    /**
     * @param nro_cta_cese_laboral the nro_cta_cese_laboral to set
     */
    public void setNro_cta_cese_laboral(String nro_cta_cese_laboral) {
        this.nro_cta_cese_laboral = nro_cta_cese_laboral;
    }

    /**
     * @return the fecha_alta
     */
    public String getFecha_alta() {
        return (fecha_alta==null?"":fecha_alta);
    }

    /**
     * @param fecha_alta the fecha_alta to set
     */
    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * @return the fecha_baja
     */
    
    public String getFecha_baja() {
        return (fecha_baja==null?"":fecha_baja);
    }

    /**
     * @param fecha_baja the fecha_baja to set
     */
    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    /**
     * @return the cod_situacion
     */
    public String getCod_situacion() {
        return (cod_situacion==null?"":cod_situacion);
    }

    /**
     * @param cod_situacion the cod_situacion to set
     */
    public void setCod_situacion(String cod_situacion) {
        this.cod_situacion = cod_situacion;
    }

    /**
     * @return the cod_domicilio
     */

    /**
     * @return the domicilio_real
     */
    public String getDomicilio_real() {
        return (domicilio_real==null?"":domicilio_real);
    }

    /**
     * @param domicilio_real the domicilio_real to set
     */
    public void setDomicilio_real(String domicilio_real) {
        this.domicilio_real = domicilio_real;
    }

    /**
     * @return the nro_real
     */
    public String getNro_real() {
        return (nro_real==null?"":nro_real);
    }

    /**
     * @param nro_real the nro_real to set
     */
    public void setNro_real(String nro_real) {
        this.nro_real = nro_real;
    }

    /**
     * @return the partido_real
     */
    public String getPartido_real() {
        return (partido_real==null?"":partido_real);
    }

    /**
     * @param partido_real the partido_real to set
     */
    public void setPartido_real(String partido_real) {
        this.partido_real = partido_real;
    }

    /**
     * @return the localidad_real
     */
    public String getLocalidad_real() {
        return (localidad_real==null?"":localidad_real);
    }

    /**
     * @param localidad_real the localidad_real to set
     */
    public void setLocalidad_real(String localidad_real) {
        this.localidad_real = localidad_real;
    }

    /**
     * @return the provincia_real
     */
    public String getProvincia_real() {
        return (provincia_real==null?"":provincia_real);
    }

    /**
     * @param provincia_real the provincia_real to set
     */
    public void setProvincia_real(String provincia_real) {
        this.provincia_real = provincia_real;
    }

    /**
     * @return the cp_real
     */
    public String getCp_real() {
        return (cp_real==null?"":cp_real);
    }

    /**
     * @param cp_real the cp_real to set
     */
    public void setCp_real(String cp_real) {
        this.cp_real = cp_real;
    }

    /**
     * @return the domicilio_legal
     */
    public String getDomicilio_legal() {
        return (domicilio_legal==null?"":domicilio_legal);
    }

    /**
     * @param domicilio_legal the domicilio_legal to set
     */
    public void setDomicilio_legal(String domicilio_legal) {
        this.domicilio_legal = domicilio_legal;
    }

    /**
     * @return the nro_legal
     */
    public String getNro_legal() {
        return (nro_legal==null?"":nro_legal);
    }

    /**
     * @param nro_legal the nro_legal to set
     */
    public void setNro_legal(String nro_legal) {
        this.nro_legal = nro_legal;
    }

    /**
     * @return the partido_legal
     */
    public String getPartido_legal() {
        return (partido_legal==null?"":partido_legal);
    }

    /**
     * @param partido_legal the partido_legal to set
     */
    public void setPartido_legal(String partido_legal) {
        this.partido_legal = partido_legal;
    }

    /**
     * @return the localidad_legal
     */
    public String getLocalidad_legal() {
        return (localidad_legal==null?"":localidad_legal);
    }

    /**
     * @param localidad_legal the localidad_legal to set
     */
    public void setLocalidad_legal(String localidad_legal) {
        this.localidad_legal = localidad_legal;
    }

    /**
     * @return the provincia_legal
     */
    public String getProvincia_legal() {
        return (provincia_legal==null?"":provincia_legal);
    }

    /**
     * @param provincia_legal the provincia_legal to set
     */
    public void setProvincia_legal(String provincia_legal) {
        this.provincia_legal = provincia_legal;
    }

    /**
     * @return the cp_legal
     */
    public String getCp_legal() {
        return (cp_legal==null?"":cp_legal);
    }

    /**
     * @param cp_legal the cp_legal to set
     */
    public void setCp_legal(String cp_legal) {
        this.cp_legal = cp_legal;
    }

    /**
     * @return the desc_categoria
     */
    public String getDesc_categoria() {
        return desc_categoria;
    }

    /**
     * @param desc_categoria the desc_categoria to set
     */
    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }

    /**
     * @return the desc_situacion
     */
    public String getDesc_situacion() {
        return desc_situacion;
    }

    /**
     * @param desc_situacion the desc_situacion to set
     */
    public void setDesc_situacion(String desc_situacion) {
        this.desc_situacion = desc_situacion;
    }

}