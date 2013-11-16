
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
import org.isft.domain.Empleado;
import org.isft.domain.helper.FechaHora;

public class CollectionEmpleado extends AccessManager implements AccessInterface {
       public int getUltimoLegajo() throws Exception{
        int ultimoLegajo=1;
            try{
            String sql="SELECT max(legajo) as max_legajo FROM Empleado where legajo < 900000";
            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                ultimoLegajo=rst.getInt("max_legajo") +1;
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
        return ultimoLegajo;
       }
 
       public int getUltimoLegajoStandBy() throws Exception{
        int ultimoLegajo=900000;
            try{
            String sql="SELECT max(legajo) as max_legajo FROM Empleado where legajo > 899000";
            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                ultimoLegajo=rst.getInt("max_legajo") +1;
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
        return ultimoLegajo;
       }
       
       public Empleado getEmpleado(String legajo) throws Exception {
           try{
               HashMap param=new HashMap();
               param.put("legajo", legajo);
               Vector<Empleado> vec=select(param);
               return vec.get(0);
           } catch(Exception exc){
               throw new Exception (exc.getMessage());
           }
       }
       
       public Vector select(HashMap param) throws Exception{
        String fecha="", anio="", mes="", dia="";   
        Vector<Empleado> vec= new Vector();
        try{
            String sql="SELECT emp.*, cat.descripcion as desc_categoria, sit.descripcion as desc_situacion from Empleado emp, Situacion_empleado sit, Categoria cat where legajo is not null ";

            if(param!=null){
                    if(param.get("legajo")!=null && !param.get("legajo").equals("")){
                            sql+=" and emp.legajo=" + (String)param.get("legajo");
                    } 
                    if(param.get("apellido")!=null && !param.get("apellido").equals("")){
                            sql+=" and emp.apellido='" + ((String)param.get("apellido")).toUpperCase()+"'";
                    } 
                    if(param.get("nombre")!=null && !param.get("nombre").equals("")){
                            sql+=" and emp.nombre=" + ((String)param.get("nombre")).toUpperCase() +"'";
                    } 
                    if(param.get("dni")!=null && !param.get("dni").equals("")){
                            sql+=" and emp.numero_documento=" + (String)param.get("dni");
                    } 
                    if(param.get("incluir_lista_espera")!=null && !param.get("incluir_lista_espera").equals("")){
                        sql+=" and ( emp.fecha_alta <> ''";
                        if(param.get("incluir_lista_espera").equals("S")){
                            sql+=" or emp.fecha_alta = ''"; 
                        } 
                        sql+=")";
                    }
                    if(param.get("fecha_desde_alta")!=null && !param.get("fecha_desde_alta").equals("")){
                            fecha=(String)param.get("fecha_desde_alta");
                            dia=fecha.substring(0, 2);
                            mes=fecha.substring(3, 5); 
                            anio=fecha.substring(6,10);
                            sql+=" and format(emp.fecha_alta,'dd/mm/yyyy') >='" + dia + "/" + mes +"/" + anio+"'";
                    }
                    if(param.get("fecha_hasta_alta")!=null && !param.get("fecha_hasta_alta").equals("")){
                            fecha=(String)param.get("fecha_hasta_alta");
                            dia=fecha.substring(0, 2);
                            mes=fecha.substring(3, 5); 
                            anio=fecha.substring(6,10);
                            sql+=" and format(emp.fecha_alta,'dd/mm/yyyy') <='" + dia + "/" + mes +"/" + anio+"'";
                    }
                     if(param.get("fecha_desde_baja")!=null && !param.get("fecha_desde_baja").equals("")){
                            fecha=(String)param.get("fecha_desde_baja");
                            dia=fecha.substring(0, 2);
                            mes=fecha.substring(3, 5); 
                            anio=fecha.substring(6,10);
                            sql+=" and format(emp.fecha_baja,'dd/mm/yyyy') >='" + dia + "/" + mes +"/" + anio+"'";
                    }
                    if(param.get("fecha_hasta_baja")!=null && !param.get("fecha_hasta_baja").equals("")){
                            fecha=(String)param.get("fecha_hasta_baja");
                            dia=fecha.substring(0, 2);
                            mes=fecha.substring(3, 5); 
                            anio=fecha.substring(6,10);
                            sql+=" and format(emp.fecha_baja,'dd/mm/yyyy') <='" + dia + "/" + mes +"/" + anio+"'";
                    }
            }
            
            sql+=" and (emp.cod_categoria is null or emp.cod_categoria=cat.cod_categoria) and (emp.cod_situacion is null or emp.cod_situacion=sit.cod_situacion) ORDER BY emp.legajo";

            System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                Empleado obj=new Empleado();
                obj.setApellido(rst.getString("apellido"));
                obj.setCalzado(rst.getString("calzado"));
                obj.setCantidad_hijos(rst.getString("cantidad_hijos"));
                obj.setCelular(rst.getString("celular"));
                obj.setCod_categoria(rst.getString("cod_categoria"));
                obj.setDesc_categoria(rst.getString("desc_categoria"));
                obj.setCod_estado_civil(rst.getString("cod_estado_civil"));
                obj.setCod_estudio(rst.getString("cod_estudio"));
                obj.setCod_situacion(rst.getString("cod_situacion"));
                obj.setDesc_situacion(rst.getString("desc_situacion"));
                obj.setCp_legal(rst.getString("cp_legal"));
                obj.setCuil(rst.getString("cuil"));
                obj.setDomicilio_legal(rst.getString("domicilio_legal"));
                obj.setDomicilio_real(rst.getString("domicilio_real"));
                obj.setE_mail(rst.getString("e_mail"));
                obj.setFecha_alta(rst.getString("fecha_alta"));
                obj.setFecha_baja(rst.getString("fecha_baja"));
                obj.setFecha_nacimiento(rst.getString("fecha_nacimiento"));
                obj.setLegajo(rst.getString("legajo"));
                obj.setLocalidad_legal(rst.getString("localidad_legal"));
                obj.setLocalidad_real(rst.getString("localidad_real"));
                obj.setNacionalidad(rst.getString("nacionalidad"));
                obj.setNombre(rst.getString("nombre"));
                obj.setNro_cta_cese_laboral(rst.getString("nro_cta_cese_laboral"));
                obj.setNro_legal(rst.getString("nro_legal"));
                obj.setNro_libreta_cese(rst.getString("nro_libreta_cese"));
                obj.setNro_real(rst.getString("nro_real"));
                obj.setNumero_documento(rst.getString("numero_documento"));
                obj.setPartido_legal(rst.getString("partido_legal"));
                obj.setPartido_real(rst.getString("partido_real"));
                obj.setProvincia_legal(rst.getString("provincia_legal"));
                obj.setProvincia_real(rst.getString("provincia_real"));
                obj.setTalle_camisa(rst.getString("talle_camisa"));
                obj.setTalle_pantalon(rst.getString("talle_pantalon"));
                obj.setTelefono(rst.getString("telefono"));
                obj.setTipo_documento(rst.getString("tipo_documento"));
                vec.add(obj);
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