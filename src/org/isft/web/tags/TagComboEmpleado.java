/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.tags;

/**
 *
 * @author Administrador
 */
import javax.servlet.jsp.JspException;
import java.util.HashMap;
import java.util.Vector;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import org.isft.domain.Empleado;
import org.isft.logic.collection.CollectionEmpleado;

public class TagComboEmpleado extends TagCombo {
    
    public int doStartTag() throws JspException {
        try {
            super.doStartTag();
            String empleados="";
            CollectionEmpleado collection_empleado=new CollectionEmpleado();
            HashMap param=new HashMap();
            Vector<Empleado> vec=collection_empleado.select(param);
            for(int i=0; i<vec.size(); i++){
                empleados+="<option value='"+vec.elementAt(i).getLegajo()+"'>";
                empleados+=vec.elementAt(i).getApellido()+", "+vec.elementAt(i).getNombre();
                empleados+="</option>";	  
            }
            pageContext.getOut().print(empleados);
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