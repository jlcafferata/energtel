
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
import org.isft.domain.DetalleObra;

public class CollectionDetalleObra extends AccessManager implements AccessInterface {
       public Vector select(HashMap param) throws Exception{
        Vector vec= new Vector();
        try{
        		String sql="SELECT Obra.poa, Obra.cuit_cliente, Obra.fecha_certificacion, Obra.nro_recibo, "
                                + "Obra.fecha_facturacion, Obra.cod_zona, Obra.cod_tipo_obra, Obra.cod_especificacion, "
                                + "Obra.cod_forma_obra, Obra.medicion_estimada, Obra.fecha_inicio, Obra.fecha_cierre, "
                                + "Cliente.razon_social, Zona.descripcion as descripcion_zona, Tipo_obra.descripcion as "
                                + "descripcion_tipo_obra, Forma_obra.descripcion as descripcion_forma_obra, "
                                + "Obra.orden_compra, Obra.valor_orden_compra, Obra.observaciones, "
                                + "Especificacion_obra.descripcion as descripcion_especificacion  "
                                + "FROM Zona, Tipo_obra, Forma_obra , Cliente,  Obra, "
                                + "Especificacion_obra "
                                + "WHERE  Cliente.cuit = Obra.cuit_cliente "
                                + "AND Forma_obra.cod_forma_obra = Obra.cod_forma_obra "
                                + "AND Tipo_obra.cod_tipo_obra = Obra.cod_tipo_obra "
                                + "AND Zona.cod_zona = Obra.cod_zona "
                                + "and Obra.cod_especificacion=Especificacion_obra.cod_especificacion_obra";
        		
        		if(param!=null){
        			if(param.get("cod_zona")!=null && !param.get("cod_zona").equals("")){
        				sql+=" and obra.cod_zona=" + (String)param.get("cod_zona");
        			}
                                if(param.get("tipo_obra")!=null && !param.get("tipo_obra").equals("")){
        				sql+=" and obra.cod_tipo_obra=" + (String)param.get("tipo_obra");
        			}
                                if(param.get("poa")!=null && !param.get("poa").equals("")){
        				sql+=" and obra.poa='" + (String)param.get("poa")+"'";
        			}
                                if(param.get("pagina")!=null && !param.get("pagina").equals("")){
        				sql+=" and obra.estado='" + (String)param.get("pagina")+"'";
        			}
        		}
        		
		     		System.out.println("CONSULTA A EJECUTAR: " + sql);
            ResultSet rst = execute(sql);   
            System.out.println("EJECUTO CONSULTA");
            while(rst.next()){
                //System.out.println("EN EL WHILE");
                DetalleObra obj=new DetalleObra();
                obj.setCuit_cliente(rst.getString("cuit_cliente"));
                obj.setPoa(rst.getString("poa"));
                obj.setFecha_inicio(rst.getString("fecha_inicio"));
                obj.setFecha_cierre(rst.getString("fecha_cierre"));
                obj.setFecha_certificacion(rst.getString("fecha_certificacion"));
                obj.setFecha_facturacion(rst.getString("fecha_facturacion"));
                obj.setCod_zona(rst.getString("cod_zona"));
                obj.setCod_tipo_obra(rst.getString("cod_tipo_obra")); 
                obj.setCod_especificacion(rst.getString("cod_especificacion"));
                obj.setCod_forma_obra(rst.getString("cod_forma_obra"));         
                obj.setMedicion_estimada(rst.getString("medicion_estimada"));                        
                obj.setNro_recibo(rst.getString("nro_recibo"));
                obj.setRazon_social(rst.getString("razon_social"));
                obj.setDescripcion_zona(rst.getString("descripcion_zona"));
                obj.setDescripcion_tipo_obra(rst.getString("descripcion_tipo_obra"));
                obj.setDescripcion_forma_obra(rst.getString("descripcion_forma_obra"));
                obj.setOrden_compra(rst.getString("orden_compra"));
                obj.setValor_orden_compra(rst.getString("valor_orden_compra"));
                obj.setDescripcion_especificacion(rst.getString("descripcion_especificacion"));
                obj.setObservaciones(rst.getString("observaciones"));                
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