package org.isft.web.tags;
import javax.servlet.jsp.JspException;
import org.isft.logic.collection.CollectionTipoObra;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.TipoObra;

public class TagComboTipoObra extends TagCombo {
    private String codigo;
    private String descripcion;
    
    public int doStartTag() throws JspException {
       String selected="";
        try {
        		
            super.doStartTag();
            CollectionTipoObra collection=new CollectionTipoObra();
            HashMap param=new HashMap();
            Vector<TipoObra> vec=collection.select(param);

            for(int i=0; i<vec.size(); i++){
                TipoObra tipoObra= vec.get(i);
                selected="";
                if(tipoObra.getCodigo().equals(getSelecto())){
                    selected="selected";
               }
                pageContext.getOut().print("<option "+ selected +" value=\""+tipoObra.getCodigo()+"\">"+tipoObra.getDescripcion()+"</option>\n");
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
