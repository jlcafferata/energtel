/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.logic.updater;

import java.util.HashMap;

/**
 *
 * @author Administrador
 */
public class AbmObra extends UpdaterManager implements UpdaterInterface{

    public void insert(HashMap param) throws Exception {
        try{
            String campos="";
            String datos="";
            if((String)param.get("poa_alta")!=""){
                campos+="poa";
                datos+="'"+(String)param.get("poa_alta")+"'";
            }
            if((String)param.get("cuil")!=""){
                campos+=", cuit_cliente";
                datos+=", '"+(String)param.get("cuil")+"'";
            }
            if((String)param.get("fecha_inicio")!=""){
                campos+=", fecha_inicio";
                datos+=", '"+(String)param.get("fecha_inicio")+"'";
            }
            if((String)param.get("fecha_cierre")!=""){
                campos+=", fecha_cierre";
                datos+=", '"+(String)param.get("fecha_cierre")+"'";
            }
            if((String)param.get("fecha_certificacion_presupuestada")!=""){
                campos+=", fecha_certificacion";
                datos+=", '"+(String)param.get("fecha_certificacion_presupuestada")+"'";
            }
            if((String)param.get("zona_obra_alta")!=""){
                campos+=", cod_zona";
                datos+=", "+(String)param.get("zona_obra_alta");
            }
            if((String)param.get("tipo_obra_alta")!=""){
                campos+=", cod_tipo_obra";
                datos+=", "+(String)param.get("tipo_obra_alta");
            }
            if((String)param.get("medicion_estimada_presupuestada")!=""){
                campos+=", medicion_estimada";
                datos+=", "+(String)param.get("medicion_estimada_presupuestada");
            }
            if((String)param.get("especificacion_obra")!=""){
                campos+=", cod_especificacion";
                datos+=", "+(String)param.get("especificacion_obra");
            }
            if((String)param.get("forma_obra")!=""){
                campos+=", cod_forma_obra";
                datos+=", "+(String)param.get("forma_obra");
            }
            if((String)param.get("observacion_presupuestadas")!=""){
                campos+=", observaciones";
                datos+=", '"+(String)param.get("observacion_presupuestadas")+"'";
            }
            if((String)param.get("valor_orden_compra_presupuestada")!=""){
                campos+=", valor_estimado";
                datos+=", "+(String)param.get("valor_orden_compra_presupuestada");
            }
            if((String)param.get("fecha_pago")!=""){
                campos+=", fecha_facturacion";
                datos+=", '"+(String)param.get("fecha_pago")+"'";
            }
            if((String)param.get("nro_orden_compra_presupuestada")!=""){
                campos+=", orden_compra";
                datos+=", "+(String)param.get("nro_orden_compra_presupuestada");
            }
            if((String)param.get("valor_orden_compra_presupuestada")!=""){
                campos+=", valor_orden_compra";
                datos+=", "+(String)param.get("valor_orden_compra_presupuestada");
            }
            if((String)param.get("nro_recibo_presupuestada")!=""){
                campos+=", nro_recibo";
                datos+=", "+(String)param.get("nro_recibo_presupuestada");
            }
            if((String)param.get("estado")!=""){
                campos+=", estado";
                datos+=", '"+(String)param.get("estado")+"'";
            }
            String sql_insert="insert into Obra ("+campos+") values("+datos+")";
            System.out.println(sql_insert);
            execute(sql_insert);
        } catch(Exception exc){
           throw new Exception(exc.getMessage());
        } 
    }

    @Override
    public void delete(HashMap parameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(HashMap param) throws Exception {
        try{
            String where="";
            String campos="";
            String datos="";
            if((String)param.get("poa_alta")!=""){
                where +=" where poa='"+(String)param.get("poa_alta")+"'";
            	  campos=" set poa='"+(String)param.get("poa_alta")+"'"; 
            }
            if((String)param.get("cuil")!=""){
                campos+=", cuit_cliente = '"+(String)param.get("cuil")+"'";
            }
            if((String)param.get("fecha_inicio")!=""){
                campos+=", fecha_inicio = '"+(String)param.get("fecha_inicio")+"'";
            }
            if((String)param.get("fecha_cierre")!=""){
                campos+=", fecha_cierre= '"+(String)param.get("fecha_cierre")+"'";
            }
            if((String)param.get("fecha_certificacion_presupuestada")!=""){
                campos+=", fecha_certificacion= '"+(String)param.get("fecha_certificacion_presupuestada")+"'";
            }
            if((String)param.get("zona_obra_alta")!=""){
                campos+=", cod_zona= "+(String)param.get("zona_obra_alta");
            }
            if((String)param.get("tipo_obra_alta")!=""){
                campos+=", cod_tipo_obra= "+(String)param.get("tipo_obra_alta");
            }
            if((String)param.get("medicion_estimada_presupuestada")!=""){
                campos+=", medicion_estimada= "+(String)param.get("medicion_estimada_presupuestada");
            }
            if((String)param.get("especificacion_obra")!=""){
                campos+=", cod_especificacion= "+(String)param.get("especificacion_obra");
            }
            if((String)param.get("forma_obra")!=""){
                campos+=", cod_forma_obra= "+(String)param.get("forma_obra");
            }
            if((String)param.get("observacion_presupuestadas")!=""){
                campos+=", observaciones= '"+(String)param.get("observacion_presupuestadas")+"'";
            }
            if((String)param.get("valor_orden_compra_presupuestada")!=""){
                campos+=", valor_estimado= "+(String)param.get("valor_orden_compra_presupuestada");
            }
            if((String)param.get("fecha_pago")!=""){
                campos+=", fecha_facturacion= '"+(String)param.get("fecha_pago")+"'";
            }
            if((String)param.get("nro_orden_compra_presupuestada")!=""){
                campos+=", orden_compra= "+(String)param.get("nro_orden_compra_presupuestada");
            }
            if((String)param.get("valor_orden_compra_presupuestada")!=""){
                campos+=", valor_orden_compra= "+(String)param.get("valor_orden_compra_presupuestada");
            }
            if((String)param.get("nro_recibo_presupuestada")!=""){
                campos+=", nro_recibo= "+(String)param.get("nro_recibo_presupuestada");
            }
            if((String)param.get("estado")!=""){
                campos+=", estado= '"+(String)param.get("estado")+"'";
            }
            String sql_update="update Obra "+campos+ where;
            System.out.println(sql_update);
            execute(sql_update);
        } catch(Exception exc){
           throw new Exception(exc.getMessage());
        } 
     }

    public void iniciarEjecucion(HashMap param) throws Exception {
        try{
            String sql_update="UPDATE OBRA SET";
            String cambios="";
            cambios+=" estado= '"+(String)param.get("estado")+"'";
            if((String)param.get("zona_obra_alta")!=""){
                cambios+=", cod_zona= "+(String)param.get("zona_obra_alta");
            }
            if((String)param.get("tipo_obra_alta")!=""){
                cambios+=", cod_tipo_obra= "+(String)param.get("tipo_obra_alta");
            }
            sql_update+=cambios;
            sql_update+=" where poa='"+(String)param.get("poa_alta")+"'";
            System.out.println("Cadena de update: " + sql_update);
            execute(sql_update);
            
        } catch(Exception exc){
           throw new Exception(exc.getMessage());
        }

    }
    
    
}
