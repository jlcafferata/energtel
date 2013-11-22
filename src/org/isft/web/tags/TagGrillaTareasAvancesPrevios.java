/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

import java.util.HashMap;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.isft.domain.TareaAvancePrevio;
import org.isft.logic.collection.CollectionTareasAvancesPrevios;

/**
 *
 * @author Administrador
 */
public class TagGrillaTareasAvancesPrevios extends TagSupport{
    private String poa;
    private String fecha_certificada;
    private String hora_cargada;
    
    public int doStartTag() throws JspException {
        try {
            String tabla="";
            if(!poa.equals("")&&!fecha_certificada.equals("")&&!hora_cargada.equals("")){
                HashMap param=new HashMap();
                CollectionTareasAvancesPrevios cap= new CollectionTareasAvancesPrevios();
                param.put("poa", poa);
                param.put("fecha_certificada", fecha_certificada);
                param.put("hora_cargada", hora_cargada);
                Vector<TareaAvancePrevio> vec=cap.select(param);
                if(vec.size()==0){
                    tabla+="<tr class=\"warning\"><td colspan=\"3\" align=\"center\">No se encontraron tareas realizadas</td></tr>";
                }
                for(int i=0;i<vec.size();i++){
                    tabla+="<tr id='tarea_"+vec.get(i).getCod_tarea()+"'><td>"+vec.get(i).getDescripcion()+"</td><td><input name='txt_"+vec.get(i).getDescripcion()+"' id='txt_"+vec.get(i).getDescripcion()+"' style='width:70px' type='text' value='"+vec.get(i).getValor()+"' disabled></td><td> "+/*<a href=\"javascript:\" onclick=\"quitarTarea(tarea_"+vec.get(i).getCod_tarea()+");\">Quitar</a>*/"</td></tr>";
                } 
            }
            pageContext.getOut().print(tabla);
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
	
        try {
        	pageContext.getOut().print("");
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return EVAL_PAGE;
    }
    
    
    
    
    
    
    
    
    
    /**
     * @return the poa
     */
    public String getPoa() {
        return poa;
    }

    /**
     * @param poa the poa to set
     */
    public void setPoa(String poa) {
        this.poa = poa;
    }

    /**
     * @return the fecha_certificada
     */
    public String getFecha_certificada() {
        return fecha_certificada;
    }

    /**
     * @param fecha_certificada the fecha_certificada to set
     */
    public void setFecha_certificada(String fecha_certificada) {
        this.fecha_certificada = fecha_certificada;
    }

    /**
     * @return the hora_cargada
     */
    public String getHora_cargada() {
        return hora_cargada;
    }

    /**
     * @param hora_cargada the hora_cargada to set
     */
    public void setHora_cargada(String hora_cargada) {
        this.hora_cargada = hora_cargada;
    }
}
