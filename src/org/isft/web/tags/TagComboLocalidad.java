package org.isft.web.tags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.isft.logic.collection.CollectionLocalidad;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.Localidad;

public class TagComboLocalidad extends TagCombo {
    private String codigo;
    private String codigo_partido;
    private String descripcion;
    
    public int doStartTag() throws JspException {
        String selected="";
        try {
        		
            super.doStartTag();
            CollectionLocalidad collection=new CollectionLocalidad();
            HashMap param=new HashMap();
            if(this.getCodigo_partido()!=null && !this.getCodigo_partido().equals("")){
                param.put("codigo_partido", this.getCodigo_partido());
            }
            
            Vector<Localidad> vec=collection.select(param);

            for(int i=0; i<vec.size(); i++){
               Localidad value= vec.get(i);
               selected="";
                if(value.getCodigo().equals(getSelecto())){
                    selected="selected";
               }
               pageContext.getOut().print("<option "+ selected +" value=\""+value.getCodigo()+"\">"+value.getDescripcion()+"</option>\n");
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

    /**
     * @return the codigoPartido
     */
    
    /**
     * @return the codigo_partido
     */
    public String getCodigo_partido() {
        return codigo_partido;
    }

    /**
     * @param codigo_partido the codigo_partido to set
     */
    public void setCodigo_partido(String codigo_partido) {
        this.codigo_partido = codigo_partido;
    }
}