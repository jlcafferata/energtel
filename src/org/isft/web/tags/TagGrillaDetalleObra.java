/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import org.isft.logic.collection.CollectionDetalleObra;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.DetalleObra;

public class TagGrillaDetalleObra extends TagGrilla {
    private String pagina;
    private String poa;
    private String tipo_obra;
    private String zona;
    private String fecha_desde;
    private String fecha_hasta;
    
    public int doStartTag() throws JspException {
       super.doStartTag();
       String table="<thead><tr><th >POA/OT</th><th >Cliente</th><th >Fecha inicio</th><th >Zona</th><th >Tipo obra</th><th >Forma obra</th><th >Nro. OC</th><th >Valor OC</th><th >Especificaci&oacute;n</th><th >Observacion</th><th >Acciones</th></tr></thead>";
			
		 	 table+="<tbody>";
			
			 CollectionDetalleObra collection = new CollectionDetalleObra();
			 try {
			 			HashMap param=new HashMap();
                                                if(this.getZona()!=null && !this.getZona().equals("")){
                                                    param.put("cod_zona", this.getZona());
                                                }
                                                if(this.getTipo_obra()!=null && !this.getTipo_obra().equals("")){
                                                    param.put("tipo_obra", this.getTipo_obra());
                                                }
                                                if(this.getPoa()!=null && !this.getPoa().equals("")){
                                                    param.put("poa", this.getPoa());
                                                }
                                                if(this.getPagina()!=null && !this.getPagina().equals("")){
                                                    param.put("pagina", this.getPagina());
                                                }
                                                if(this.getFecha_desde()!=null && !this.getFecha_desde().equals("")){
                                                    param.put("fecha_desde", this.getFecha_desde());
                                                }
                                                if(this.getFecha_hasta()!=null && !this.getFecha_hasta().equals("")){
                                                    param.put("fecha_hasta", this.getFecha_hasta());
                                                }
						Vector <DetalleObra> vec= collection.select(param);
						String clase="";
						if(vec.size()==0){
							table+="<tr class=\"warning\"><td colspan=\"10\" align=\"center\"> No hay obras que visualizar de acuerdo a los filtros establecidos</td></tr>";
						}
						for (int i=0; i<vec.size(); i++){ 
							 if(vec.get(i).getFecha_cierre()== null || vec.get(i).getFecha_cierre().equals("")){
							 	clase="success";
							 } else{
							 	clase="error";
							 }
							 table+="<tr class=\""+clase+"\"><td>"+vec.get(i).getPoa()+"</td>";
							 table+="<td>"+vec.get(i).getRazon_social()+"</td>";
							 table+="<td>"+vec.get(i).getFecha_inicio_view()+"</td>";
               table+="<td>"+vec.get(i).getDescripcion_zona()+"</td>";
		           table+="<td>"+vec.get(i).getDescripcion_tipo_obra()+"</td>";
		           table+="<td>"+vec.get(i).getDescripcion_forma_obra()+"</td>";
		           table+="<td>"+(vec.get(i).getOrden_compra()==null?"&nbsp;":vec.get(i).getOrden_compra())+"</td>";
		           table+="<td>"+(vec.get(i).getValor_orden_compra()==null?"&nbsp;":vec.get(i).getValor_orden_compra())+"</td>";
		           table+="<td>"+(vec.get(i).getDescripcion_especificacion()==null?"&nbsp;":vec.get(i).getDescripcion_especificacion())+"</td>";
		           table+="<td>"+(vec.get(i).getObservaciones()==null?"&nbsp;":vec.get(i).getObservaciones())+"</td>";
		           if(this.getPagina().equals("PRE")){
		           		table+="<td><a href=\"javascript: modi("+vec.get(i).getPoa()+")\">Editar</a>&nbsp;";
									table+="<a href=\"javascript: iniciar_ejecucion("+vec.get(i).getPoa()+")\">Iniciar ejecuci&oacute;n</a></td>";	
		           }else if(this.getPagina().equals("EJE")){
		           		table+="<td><a href=\"javascript: anticipo_obra("+vec.get(i).getPoa()+")\">Anticipo obra</a>&nbsp;<a href=\"javascript: registro_avance("+vec.get(i).getPoa()+","+vec.get(i).getCod_zona()+","+vec.get(i).getCod_tipo_obra()+")\">Avance obra</a>&nbsp;<a href=\"javascript: certificar("+vec.get(i).getPoa()+")\">Certificar</a></td>";	
		           }else if(this.getPagina().equals("CER")){
		           		table+="<td><a href=\"javascript: pasar_a_en_ejecucion("+vec.get(i).getPoa()+")\">Volver En Ejecuci&oacute;n</a>&nbsp;<a href=\"javascript: facturar("+vec.get(i).getPoa()+")\">Pasar a facturada</a></td>";	
		           }else if(this.getPagina().equals("FAC")){
		           		table+="<td><a href=\"javascript: pasar_a_certificada("+vec.get(i).getPoa()+")\">Volver a Certificada</a>&nbsp;<a href=\"javascript: cobrar("+vec.get(i).getPoa()+")\">Pasar a Cobrada</a></td>";	
		           }else if(this.getPagina().equals("COB")){
		           		table+="<td><a href=\"javascript: pasar_a_facturada("+vec.get(i).getPoa()+")\">Volver a Facturada</a></td>";	
		           }
		           table+="</tr>";		           
            }					
						
       
            pageContext.getOut().print(table);
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
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
    
    public void setPagina(String value){
    	this.pagina=value;
    }
    public void setPoa(String value){
    	this.poa=value;
    }
    
    public void setTipo_obra(String value){
     	this.tipo_obra=value;
    }
    public void setZona(String value){
    	this.zona=value;
    }
    public void setFecha_desde(String value){
    	this.fecha_desde=value;
    }
    public void setFecha_hasta(String value){
    	this.fecha_hasta=value;
    }
    
    public String getPagina(){
    	return this.pagina;
    }
    public String getPoa(){
    	return this.poa;
    }
    public String getTipo_obra(){
    	return this.tipo_obra;
    }
    public String getZona(){
    	return this.zona;
    }
    public String getFecha_desde(){
    	return this.fecha_desde;
    }
    public String getFecha_hasta(){
    	return this.fecha_hasta;
    }
}
