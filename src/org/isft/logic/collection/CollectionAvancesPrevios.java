/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.AvancePrevio;
import org.isft.logic.AccessInterface;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionAvancesPrevios extends AccessManager implements AccessInterface {

    public Vector select(HashMap param) throws Exception {
        Vector vec= new Vector();
        try{
            String sql="SELECT * from Avance_obra where poa is not null";
            if(param!=null){
                    if(param.get("poa")!=null && !param.get("poa").equals("")){
                            sql+=" and poa='" + (String)param.get("poa")+"'";
                    }
            }
            if(param!=null){
                    if(param.get("fecha")!=null && !param.get("fecha").equals("")){
                            /*String aux_fecha=(String)param.get("fecha");
                            String[] fecha_split=aux_fecha.split("-");
                            String fecha=fecha_split[2]+"/"+fecha_split[1]+"/"+fecha_split[0];*/
                            sql+=" and fecha_certificacion='" + (String)param.get("fecha") +"'";
                    }
            }
            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
               // System.out.println("EN EL WHILE");
                AvancePrevio value=new AvancePrevio();
                value.setFecha(rst.getString("fecha_certificacion"));
                value.setHora(rst.getString("hora_carga"));
                value.setPoa(rst.getString("poa"));
                vec.add(value);
            }             
        }catch(Exception exc){
            throw new Exception(exc);
        }
        finally{
            try{
                close_connection();
            }
            catch(Exception exc){
                throw new Exception(exc.getMessage());
            }
        }   
        return vec;
    }
    
}
