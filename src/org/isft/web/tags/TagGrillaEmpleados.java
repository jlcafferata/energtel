/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import org.isft.logic.collection.CollectionEmpleado;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.helper.FechaHora;
import org.isft.domain.Empleado;

public class TagGrillaEmpleados extends TagGrilla {
    private String legajo;
    private String apellido;
    private String nombre;
    private String dni;
    private String fecha_desde_alta;
    private String fecha_hasta_alta;
    private String fecha_desde_baja;
    private String fecha_hasta_baja;
    private String incluir_lista_espera;
    private String accion="";
    
    public int doStartTag() throws JspException {
     if(getAccion().equals("")){
       super.doStartTag();
       String table="<thead><tr><th >Nro Legajo</th><th >Empleado</th><th >CUIL</th><th >Fecha Nacimiento</th><th >Fecha Alta</th><th >Fecha Baja</th><th >Situaci&oacute;n</th><th >Categoria</th><th >Acciones</th></tr></thead>";
			
       table+="<tbody>";

       CollectionEmpleado collection = new CollectionEmpleado();
       try {
       HashMap param=new HashMap();
           if(this.getLegajo()!=null && !this.getLegajo().equals("")){
               param.put("legajo", this.getLegajo());
           } 
           if(this.getApellido()!=null && !this.getApellido().equals("")){
               param.put("apellido", this.getApellido());
           } 
           if(this.getNombre()!=null && !this.getNombre().equals("")){
               param.put("nombre", this.getNombre());
           } 
           if(this.getDni()!=null && !this.getDni().equals("")){
               param.put("dni", this.getDni());
           } 
           if(this.getIncluir_lista_espera()!=null && !this.getIncluir_lista_espera().equals("")){
               param.put("incluir_lista_espera", this.getIncluir_lista_espera());
           }
           if(this.getFecha_desde_alta()!=null && !this.getFecha_desde_alta().equals("")){
               param.put("fecha_desde_alta", FechaHora.getFechaWithBarras(this.getFecha_desde_alta()));
           }
           if(this.getFecha_hasta_alta()!=null && !this.getFecha_hasta_alta().equals("")){
               param.put("fecha_hasta_alta", FechaHora.getFechaWithBarras(this.getFecha_hasta_alta()));
           }
           if(this.getFecha_desde_baja()!=null && !this.getFecha_desde_baja().equals("")){
               param.put("fecha_desde_baja", FechaHora.getFechaWithBarras(this.getFecha_desde_baja()));
           }
           if(this.getFecha_hasta_baja()!=null && !this.getFecha_hasta_baja().equals("")){
               param.put("fecha_hasta_baja", FechaHora.getFechaWithBarras(this.getFecha_hasta_baja()));
           }
        Vector <Empleado> vec= collection.select(param);
        String clase="";
        if(vec.size()==0){
                table+="<tr class=\"warning\"><td colspan=\"10\" align=\"center\"> No hay obras que visualizar de acuerdo a los filtros establecidos</td></tr>";
        }
        String baja="";
        for (int i=0; i<vec.size(); i++){ 
                 if(vec.get(i).getFecha_alta()== null || vec.get(i).getFecha_alta().equals("")){
                        clase="warning";
                 } else if(vec.get(i).getFecha_baja()== null || vec.get(i).getFecha_baja().equals("")){
                        clase="success";
                 } else{
                        clase="error";
                 }
                 table+="<tr class=\""+clase+"\"><td>"+vec.get(i).getLegajo()+"</td>";
                 table+="<td>"+vec.get(i).getApellido() + ", " +vec.get(i).getNombre()+"</td>";
                 table+="<td>"+vec.get(i).getCuil()+"</td>";
                 table+="<td>"+vec.get(i).getFecha_nacimiento()+"</td>";
                 table+="<td>"+(vec.get(i).getFecha_alta()==null || vec.get(i).getFecha_alta().equals("")?"&nbsp;":vec.get(i).getFecha_alta())+"</td>";
                 table+="<td>"+(vec.get(i).getFecha_baja()==null || vec.get(i).getFecha_baja().equals("")?"&nbsp;":vec.get(i).getFecha_baja())+"</td>";
                 table+="<td>"+(vec.get(i).getCod_situacion()==null?"&nbsp;":vec.get(i).getDesc_situacion())+"</td>";
                 table+="<td>"+(vec.get(i).getCod_categoria()==null?"&nbsp;":vec.get(i).getDesc_categoria())+"</td>";
                 baja=((vec.get(i).getFecha_alta()==null || vec.get(i).getFecha_alta().equals("")) || (vec.get(i).getFecha_baja()!=null && !vec.get(i).getFecha_baja().equals(""))?"":"<a href=\"javascript: baja("+vec.get(i).getLegajo()+")\">Baja</a>");
                 table+="<td><a href=\"javascript: modi("+vec.get(i).getLegajo()+")\">Editar</a>&nbsp;"+baja+"</td>";
                 table+="</tr>";		           
            }					
	    pageContext.getOut().print(table);

        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
       }else{// ACA EMPIEZA SI AGREGAREMPLEADO ES TRUE OSEA GENERA UNA TABLA GRILLA QUE MUESTRA LOS EMPLEADOS SEGUN UN POA Y TE PERMITE AGREGAR MAS POR MEDIO DE UNA BOTON
           try{
               String table="";
               table+="<tr><td>Diaz</td><td>Nicolas</td>";
               table+="<td><a href=\"javascript:\" onclick=\"quitarEmpleado(210, this);\">Quitar</a></td>";											
               table+="</tr>";
               table+="<tr><td>Diaz</td><td>Juan</td><td>";
               table+="<a href=\"javascript:\" onclick=\"quitarEmpleado(210, this);\">Quitar</a></td>";											
               
                pageContext.getOut().print(table);                          
           }catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
               
       }
       
    }

    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().print("<tbody>");
            super.doEndTag();
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }       
        return EVAL_PAGE;
    }
    
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
        return apellido;
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
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the fecha_desde_alta
     */
    public String getFecha_desde_alta() {
        return fecha_desde_alta;
    }

    /**
     * @param fecha_desde_alta the fecha_desde_alta to set
     */
    public void setFecha_desde_alta(String fecha_desde_alta) {
        this.fecha_desde_alta = fecha_desde_alta;
    }

    /**
     * @return the fecha_hasta_alta
     */
    public String getFecha_hasta_alta() {
        return fecha_hasta_alta;
    }

    /**
     * @param fecha_hasta_alta the fecha_hasta_alta to set
     */
    public void setFecha_hasta_alta(String fecha_hasta_alta) {
        this.fecha_hasta_alta = fecha_hasta_alta;
    }

    /**
     * @return the fecha_desde_baja
     */
    public String getFecha_desde_baja() {
        return fecha_desde_baja;
    }

    /**
     * @param fecha_desde_baja the fecha_desde_baja to set
     */
    public void setFecha_desde_baja(String fecha_desde_baja) {
        this.fecha_desde_baja = fecha_desde_baja;
    }

    /**
     * @return the fecha_hasta_baja
     */
    public String getFecha_hasta_baja() {
        return fecha_hasta_baja;
    }

    /**
     * @param fecha_hasta_baja the fecha_hasta_baja to set
     */
    public void setFecha_hasta_baja(String fecha_hasta_baja) {
        this.fecha_hasta_baja = fecha_hasta_baja;
    }

    /**
     * @return the incluir_lista_espera
     */
    public String getIncluir_lista_espera() {
        return incluir_lista_espera;
    }

    /**
     * @param incluir_lista_espera the incluir_lista_espera to set
     */
    public void setIncluir_lista_espera(String incluir_lista_espera) {
        this.incluir_lista_espera = incluir_lista_espera;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }


}
