/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.validator;

import java.sql.ResultSet;
import java.util.HashMap;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class ChequearDatosObra extends AccessManager{

    public String validarDatos(HashMap param) throws Exception {
        String valido="";
        if((String)param.get("poa_alta")!=""){
            valido=esValidoParaAltaPoa((String)param.get("poa_alta"));
        }
        return valido;
    }

    public String esValidoParaAltaPoa(String poa) throws Exception {
        String valido="";
        String sql="select *" +
                " from Obra" +
                " where poa='"+poa+"'";
        ResultSet rst=execute(sql);
        if(rst.next()){
            valido="El poa ya esta en uso";
        }
        return valido;
    }
    
}
