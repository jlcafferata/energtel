package org.isft.web.tags;
import javax.servlet.jsp.JspException;
import org.isft.logic.collection.CollectionFormaObra;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.FormaObra;

public class TagComboFormaObra extends TagCombo {
    private String codigo;
    private String descripcion;
    
    public int doStartTag() throws JspException {
        String selected="";
        try {
        		
            super.doStartTag();
            CollectionFormaObra collection=new CollectionFormaObra();
            HashMap param=new HashMap();
            Vector<FormaObra> vec=collection.select(param);

            for(int i=0; i<vec.size(); i++){
                FormaObra value= vec.get(i);
                selected="";
                if(value.getCodigo().equals(getSelecto())){
                    selected="selected";
               }
               pageContext.getOut().print("<option "+ selected+" value=\""+value.getCodigo()+"\">"+value.getDescripcion()+"</option>\n");
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