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
            //ESTO ES LO DE CAMBIO DE PRESUPUESTADA A EJECUCION
            String sql_update="UPDATE OBRA SET";
            String cambios="";
            cambios+=" estado= '"+(String)param.get("estado")+"'";
            if((String)param.get("zona_obra_alta")!=""){
                cambios+=", cod_zona= "+(String)param.get("zona_obra_alta");
            }
            if((String)param.get("tipo_obra_alta")!=""){
                cambios+=", cod_tipo_obra= "+(String)param.get("tipo_obra_alta");
            }
            if((String)param.get("fecha_actual")!=""){
                cambios+=", fecha_inicio= '"+(String)param.get("fecha_actual")+"'";
            }
            sql_update+=cambios;
            sql_update+=" where poa='"+(String)param.get("poa_alta")+"'";
            
            //ACA EMPIEZA LO DE AVANCE
            boolean realizar_avance=false;
            if((String)param.get("fecha_certificacion_avance")!=""){
                realizar_avance=true;
            }
            String campos_avance_obra="",datos_avance_obra="";
            if((String)param.get("poa_alta")!=""){
                  campos_avance_obra+="poa";
            	  datos_avance_obra+=(String)param.get("poa_alta"); 
            }
            if((String)param.get("fecha_certificacion_avance")!=""){
                campos_avance_obra+=", fecha_certificacion";
                datos_avance_obra+=", '"+(String)param.get("fecha_certificacion_avance")+"'";
            }
            if((String)param.get("hora_carga")!=""){
                campos_avance_obra+=", hora_carga";
                datos_avance_obra+=", '"+(String)param.get("hora_carga")+"'";
            }
            if((String)param.get("pendiente")!=""){
                campos_avance_obra+=", tareas_pendientes";
                datos_avance_obra+=", '"+(String)param.get("pendiente")+"'";
            }
            
            String sql_avance="insert into Avance_obra ("+campos_avance_obra+") values ("+datos_avance_obra+")";
            System.out.println("Los legajos de empleados son: "+ (String)param.get("empleados"));
            System.out.println("Cadena de update: " + sql_update);
            if(realizar_avance){
                System.out.println("Cadena de avance de obra: "+ sql_avance);
                execute(sql_avance);
            }
            execute(sql_update);
            
            //AGREGAR AVANCE EMPLEADO
            if((String)param.get("empleados")!=""){
                String aux=(String)param.get("empleados");
                String[] empleado=aux.split("@");
                for(int i=0;i<empleado.length;i++){
                    String campos_avance_empleado="",datos_avance_empleado="";
                    campos_avance_empleado+="legajo";                    
                    datos_avance_empleado+=empleado[i];
                    if((String)param.get("poa_alta")!=""){
                        campos_avance_empleado+=", poa";
                        datos_avance_empleado+=", "+(String)param.get("poa_alta"); 
                    }
                    if((String)param.get("fecha_certificacion_avance")!=""){
                        campos_avance_empleado+=", fecha_certificacion";
                        datos_avance_empleado+=", '"+(String)param.get("fecha_certificacion_avance")+"'";
                    }
                    if((String)param.get("hora_carga")!=""){
                        campos_avance_empleado+=", hora_carga";
                        datos_avance_empleado+=", '"+(String)param.get("hora_carga")+"'";
                    }
                    String sql_avance_empleado="insert into Empleado_avance_obra ("+campos_avance_empleado+") values ("+datos_avance_empleado+")";
                    System.out.println("Cadena de empleados insertada en avance empleado: " + sql_avance_empleado);
                    execute(sql_avance_empleado);
                }
            }
            
            //AGREGAR MATERIALES AVANCE OBRA
            if((String)param.get("materiales")!=""){
                String aux=(String)param.get("materiales");
                String[] materiales=aux.split("@");
                for(int i=0;i<materiales.length;i++){
                    String campos_avance_materiales="",datos_avance_materiales="";
                    campos_avance_materiales+="cod_material";                    
                    datos_avance_materiales+=materiales[i];
                    if((String)param.get("poa_alta")!=""){
                        campos_avance_materiales+=", poa";
                        datos_avance_materiales+=", "+(String)param.get("poa_alta"); 
                    }
                    if((String)param.get("fecha_certificacion_avance")!=""){
                        campos_avance_materiales+=", fecha_certificacion";
                        datos_avance_materiales+=", '"+(String)param.get("fecha_certificacion_avance")+"'";
                    }
                    if((String)param.get("hora_carga")!=""){
                        campos_avance_materiales+=", hora_carga";
                        datos_avance_materiales+=", '"+(String)param.get("hora_carga")+"'";
                    }
                    String sql_avance_materiales_obra="insert into Material_avance_obra ("+campos_avance_materiales+") values ("+datos_avance_materiales+")";
                    System.out.println("Cadena de materiales insertada en avance materiales: " + sql_avance_materiales_obra);
                    execute(sql_avance_materiales_obra);
                }
            }
            
            
        } catch(Exception exc){
           throw new Exception(exc.getMessage());
        }

    }
    
    
}
