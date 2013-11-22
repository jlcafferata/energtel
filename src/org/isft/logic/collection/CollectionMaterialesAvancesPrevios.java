/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.MaterialAvancePrevio;
import org.isft.logic.AccessInterface;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionMaterialesAvancesPrevios extends AccessManager implements AccessInterface{

    public Vector<MaterialAvancePrevio> select(HashMap param) throws Exception {
        Vector vec= new Vector();
        try{
            String sql="SELECT ma.cod_material, ma.descripcion, ma.stock_propio, ma.stock_provisto, mao.cantidad_provistos, mao.cantidad_propia from Material_avance_obra mao, Material ma where mao.poa is not null";
            if(param!=null){
                    if(param.get("poa")!=null && !param.get("poa").equals("")){
                            sql+=" and mao.poa='" + (String)param.get("poa")+"'";
                    }
                    if(param.get("fecha_certificada")!=null && !param.get("fecha_certificada").equals("")){
                            sql+=" and mao.fecha_certificacion=#" + (String)param.get("fecha_certificada")+"#";
                    }
                    if(param.get("hora_cargada")!=null && !param.get("hora_cargada").equals("")){
                            sql+=" and mao.hora_carga='" + (String)param.get("hora_cargada")+"'";
                    }
                    sql+=" and mao.cod_material=ma.cod_material";
            }

            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
               // System.out.println("EN EL WHILE");
                MaterialAvancePrevio value=new MaterialAvancePrevio();
                value.setCod_material(rst.getString("cod_material"));
                value.setNombre(rst.getString("descripcion"));
                value.setStock_propio(rst.getString("stock_propio"));
                value.setStock_provisto(rst.getString("stock_provisto"));
                value.setStock_provisto_usado(rst.getString("cantidad_provistos"));
                value.setStock_propio_usado(rst.getString("cantidad_propia"));
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
