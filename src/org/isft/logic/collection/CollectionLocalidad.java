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
import org.isft.domain.Localidad;

public class CollectionLocalidad extends AccessManager implements AccessInterface {
       public Vector select(HashMap param) throws Exception{
        Vector vec= new Vector();
        try{
            String sql="SELECT * from localidad where codigo is not null ";
            if(param!=null && !param.isEmpty()){
                if(param.get("codigo_partido")!=null){
                    sql+=" and codigo_partido =" +(String)param.get("codigo_partido");
                }
            }
            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                Localidad localidad=new Localidad();
                localidad.setCodigo(rst.getString("codigo"));
                localidad.setDescripcion(rst.getString("descripcion"));
                vec.add(localidad);
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