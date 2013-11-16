
package org.isft.logic.collection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import org.isft.jdbc.DataBase;
import org.isft.logic.AccessManager;
import org.isft.logic.AccessInterface;
import org.isft.domain.TipoObra;

public class CollectionTipoObra extends AccessManager implements AccessInterface {
       public Vector select(HashMap param) throws Exception{
        Vector vec= new Vector();
        try{
        		String sql="SELECT * from tipo_obra where cod_tipo_obra is not null ";
        		
		     		
        		System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                TipoObra tipoObra=new TipoObra();
                tipoObra.setCodigo(rst.getString("cod_tipo_obra"));
                tipoObra.setDescripcion(rst.getString("descripcion"));
                vec.add(tipoObra);
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