package org.isft.logic.collection;
import org.isft.domain.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import org.isft.jdbc.DataBase;

public class EjemploConexion {
 
   
    public Usuario usuarioValido(HashMap param){
        //Vector vec = new Vector();
        Usuario usuario=null;
        try{
            DataBase db = new DataBase(new HashMap());
            ResultSet rst = null;
            Connection cn = db.getConnection();
            Statement s = cn.createStatement();
            rst = s.executeQuery("SELECT * FROM usuario WHERE usr='"+(String)param.get("usr")+"' AND pwd='"+(String)param.get("pwd")+"'");
            while(rst.next()){
                usuario=new Usuario();
                usuario.setApellido(rst.getString("apellido"));
                usuario.setNombre(rst.getString("nombre"));
                usuario.setUsr(rst.getString("usr"));
                usuario.setRol(rst.getInt("rol"));
            }
        }catch(Exception exc){
            System.out.println("EXCEPCION AL INTENTAR CONECTAR CON LA BASE DE DATOS x: " + exc.getMessage());
        }
        return usuario;
    }
   
}
