package org.isft.web.tags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.isft.logic.collection.CollectionEstadoCivil;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.EstadoCivil;

public class TagComboEstadoCivil extends TagCombo {
    private String codigo;
    private String descripcion;
    
    public int doStartTag() throws JspException {
        String selected="";
        try {
        		
            super.doStartTag();
            CollectionEstadoCivil collection=new CollectionEstadoCivil();
            HashMap param=new HashMap();
            Vector<EstadoCivil> vec=collection.select(param);

            for(int i=0; i<vec.size(); i++){
                EstadoCivil estadoCivil= vec.get(i);
                selected="";
                if(estadoCivil.getCodigo().equals(getSelecto())){
                    selected="selected";
               }
                pageContext.getOut().print("<option "+ selected +" value=\""+estadoCivil.getCodigo()+"\">"+estadoCivil.getDescripcion()+"</option>\n");
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
	  public void setCodigo(String codigo){
	  	this.codigo=codigo;
	  }
	  public String getCodigo(){
	  	return this.codigo;
	  }
	  public void setDescripcion(String descripcion){
	  	this.descripcion=descripcion;
	  }
	  public String getDescripcion(){
	  	return this.descripcion;
	  }
}