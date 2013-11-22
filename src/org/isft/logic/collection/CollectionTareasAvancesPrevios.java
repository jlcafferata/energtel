/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.TareaAvancePrevio;
import org.isft.logic.AccessInterface;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionTareasAvancesPrevios extends AccessManager implements AccessInterface {

    public Vector<TareaAvancePrevio> select(HashMap param) throws Exception {
        Vector vec= new Vector();
        try{
            String sql="SELECT ta.cod_tarea, ta.descripcion, ta.precio, tao.valor from Tarea_avance_obra tao, Tarea ta where tao.poa is not null";
            if(param!=null){
                    if(param.get("poa")!=null && !param.get("poa").equals("")){
                            sql+=" and tao.poa='" + (String)param.get("poa")+"'";
                    }
                    if(param.get("fecha_certificada")!=null && !param.get("fecha_certificada").equals("")){
                            sql+=" and tao.fecha_certificacion=#" + (String)param.get("fecha_certificada")+"#";
                    }
                    if(param.get("hora_cargada")!=null && !param.get("hora_cargada").equals("")){
                            sql+=" and tao.hora_carga='" + (String)param.get("hora_cargada")+"'";
                    }
                    sql+=" and tao.cod_tarea=ta.cod_tarea";
            }

            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
               // System.out.println("EN EL WHILE");
                TareaAvancePrevio value=new TareaAvancePrevio();
                value.setCod_tarea(rst.getString("cod_tarea"));
                value.setDescripcion(rst.getString("descripcion"));
                value.setPrecio(rst.getString("precio"));
                value.setValor(rst.getString("valor"));
                
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
