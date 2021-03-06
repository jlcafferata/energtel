package org.isft.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagCombo extends TagSupport {
    private boolean disabled;
    private String onChange="";
    private String obligatorio;
    private String onClick="";
    private String nombreCombo="";
    private String selecto;
    private String style;
    
    
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("<select id=\""+ getNombreCombo() + "\"  name=\""+getNombreCombo() + "\""  + (getDisabled()?"disabled":"") + " onClick='" + getOnClick() + "' onChange='" + getOnChange() + "' " + getStyle() + ">\n");
            if(getObligatorio().equals("N")){
              pageContext.getOut().print("<option value=\"\"></option>\n");
            }
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
	      try {
        	pageContext.getOut().print("</select>\n");
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return EVAL_PAGE;
    }

    public void setStyle(String style){
        this.style=style;
    }

    public String getStyle(){
 				String estilo="";
 				if(this.style!=null){
 					estilo="style='"+this.style+"'";
 				}
 				return estilo;
    }
    
    public void setDisabled(boolean disabled){
        this.disabled=disabled;
    }

    public void setOnChange(String onChange){
        this.onChange=onChange;
    }

    public void setOnClick(String onClick){
        this.onClick=onClick;
    }

    public void setObligatorio(String obligatorio) {
        this.obligatorio = obligatorio;
    }

    public String getObligatorio() {
       return (this.obligatorio==null?"N":this.obligatorio);
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public boolean getDisabled() {
        return this.disabled;
    }

    public String getOnChange() {
        return onChange;
    }

    public String getOnClick() {
        return onClick;
    }

    /**
     * @return the selecto
     */
    public String getSelecto() {
        return selecto;
    }

    /**
     * @param selecto the selecto to set
     */
    public void setSelecto(String selecto) {
        this.selecto = selecto;
    }
}
