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
import org.isft.domain.Herramienta;

public class CollectionHerramienta extends AccessManager implements AccessInterface {
       public Vector select(HashMap param) throws Exception{
        Vector vec= new Vector();
        try{
        		String sql="SELECT * from herramienta where cod_herramienta as codigo is not null ";
        		
		     		
        		System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                Herramienta value=new Herramienta();
                value.setCodigo(rst.getString("codigo"));
                value.setDescripcion(rst.getString("descripcion"));
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