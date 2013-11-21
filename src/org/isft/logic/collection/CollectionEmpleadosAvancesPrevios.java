/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.EmpleadoAvancePrevio;
import org.isft.logic.AccessInterface;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionEmpleadosAvancesPrevios extends AccessManager implements AccessInterface {

    public Vector<EmpleadoAvancePrevio> select(HashMap param) throws Exception {
        Vector vec= new Vector();
        try{
            String sql="SELECT emp.legajo, emp.apellido, emp.nombre from Empleado_avance_obra eao, Empleado emp where eao.poa is not null";
            if(param!=null){
                    if(param.get("poa")!=null && !param.get("poa").equals("")){
                            sql+=" and eao.poa='" + (String)param.get("poa")+"'";
                    }
                    if(param.get("fecha_certificada")!=null && !param.get("fecha_certificada").equals("")){
                            sql+=" and eao.fecha_certificacion=#" + (String)param.get("fecha_certificada")+"#";
                    }
                    if(param.get("hora_cargada")!=null && !param.get("hora_cargada").equals("")){
                            sql+=" and eao.hora_carga='" + (String)param.get("hora_cargada")+"'";
                    }
                    sql+=" and eao.legajo=emp.legajo";
            }

            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
               // System.out.println("EN EL WHILE");
                EmpleadoAvancePrevio value=new EmpleadoAvancePrevio();
                value.setLegajo(rst.getString("legajo"));
                value.setApellido(rst.getString("apellido"));
                value.setNombre(rst.getString("nombre"));
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
