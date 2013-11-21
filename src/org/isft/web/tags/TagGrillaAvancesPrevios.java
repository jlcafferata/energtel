/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

import java.util.HashMap;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import org.isft.domain.AvancePrevio;
import org.isft.logic.collection.CollectionAvancesPrevios;
import org.isft.domain.helper.FechaHora;
/**
 *
 * @author Administrador
 */
public class TagGrillaAvancesPrevios extends TagGrilla {
    private String poa;
    private String fecha;
    public int doStartTag() throws JspException {
        super.doStartTag();
        String table="<thead><tr><th >POA/OT</th><th >Fecha certificacion</th><th>Hora Carga</th><th>Acciones</th></tr></thead>";
        table+="<tbody>";
        try{
            HashMap param=new HashMap();
            CollectionAvancesPrevios cap= new CollectionAvancesPrevios();
            param.put("poa", poa);
            if(!fecha.equals("")){
                System.out.println("LA FECHA EN EL TAG ES "+ fecha);
                param.put("fecha", fecha);
            }
            Vector<AvancePrevio> vec=cap.select(param);
            if(vec.size()==0){
                    table+="<tr class=\"warning\"><td colspan=\"4\" align=\"center\"><td>No hay avances cargados</td></tr>";
            }
            for(int i=0;i<vec.size();i++){
                table+="<tr>";
                table+="<th>"+vec.elementAt(i).getPoa()+"</th>";
                String[] fecha=vec.elementAt(i).getFecha().split(" ");
                String fecha_mostrada=fecha[0];
                String hora_mostrada=vec.elementAt(i).getHora();
                table+="<th>"+fecha_mostrada+"</th>";
                table+="<th>"+hora_mostrada+"</th>";
                table+="<th><a href=\"javascript: modificarAvancePrevio('"+fecha_mostrada+ "','"+ hora_mostrada+"')\">Modificar</a></th>";
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
