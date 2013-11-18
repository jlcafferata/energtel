/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.isft.domain.Tarea;
import org.isft.logic.AccessInterface;
import org.isft.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionTarea extends AccessManager implements AccessInterface {

    public Vector select(HashMap param) throws Exception{
        Vector vec= new Vector();
        try{
            String sql="SELECT * from Tarea where cod_tarea is not null ";	
            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                Tarea value=new Tarea();
                value.setCod_tarea(rst.getString("cod_tarea"));
                value.setDescripcion(rst.getString("descripcion"));
                value.setPrecio(rst.getString("precio"));
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
