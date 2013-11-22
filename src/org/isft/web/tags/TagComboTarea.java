/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

import java.util.HashMap;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import org.isft.domain.Tarea;
import org.isft.logic.collection.CollectionTarea;

/**
 *
 * @author Administrador
 */
public class TagComboTarea extends TagCombo{
    public int doStartTag() throws JspException {
        try {
            String selected="";
            super.doStartTag();
            CollectionTarea ct=new CollectionTarea();
            HashMap param=new HashMap();
            Vector<Tarea> vec=ct.select(param);

            for(int i=0; i<vec.size(); i++){
                selected="";
                Tarea value= vec.get(i);	
                pageContext.getOut().print("<option value=\""+value.getCod_tarea()+"_"+value.getPrecio()+"\">"+value.getDescripcion()+"</option>\n");
            }
 		} catch(Exception exc){
            exc.printStackTrace();
            throw new JspException("Exception en TagCombo " + exc.getMessage());
        }
        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
        try{
        	super.doEndTag();
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }return EVAL_PAGE;
    }
}
