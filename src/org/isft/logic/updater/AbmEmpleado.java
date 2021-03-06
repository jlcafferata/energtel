package org.isft.logic.updater;

import java.util.HashMap;
import org.isft.logic.collection.CollectionEmpleado;

/**
 *
 * @author jcafferata
 */
public class AbmEmpleado extends UpdaterManager implements UpdaterInterface{

    @Override
    public void insert(HashMap param) throws Exception {
        System.out.println("PARAM:" + param.toString());
        try{
            String legajo=(String)param.get("txt_legajo_alta");
            String fecha_alta=(String)param.get("txt_fecha_alta_alta");
            if(fecha_alta.equals("")){
                CollectionEmpleado collection=new CollectionEmpleado();
                legajo=String.valueOf(collection.getUltimoLegajoStandBy());
            }
            String sql_insert="INSERT INTO EMPLEADO (legajo, apellido, nombre, tipo_documento, numero_documento, cod_categoria, cuil, fecha_nacimiento, nacionalidad, cod_estado_civil, cantidad_hijos, cod_estudio, telefono, celular, e_mail, talle_pantalon, talle_camisa, calzado, nro_libreta_cese, nro_cta_cese_laboral, fecha_alta, fecha_baja, cod_situacion, domicilio_real, nro_real, partido_real, localidad_real, provincia_real, cp_real, domicilio_legal, nro_legal, partido_legal, localidad_legal, provincia_legal, cp_legal) values("+legajo+",'"+ (String)param.get("txt_apellido_alta")+"','"+(String)param.get("txt_nombre_alta")+"','"+ (String)param.get("cbo_tipo_documento")+"',"+ (String)param.get("txt_dni_alta")+","+ (String)param.get("cbo_categoria")+",'"+ (String)param.get("txt_cuil_alta")+"','"+ (String)param.get("txt_fecha_nac_alta")+"','"+ (String)param.get("txt_nacionalidad_alta")+"',"+ (String)param.get("cbo_estado_civil")+","+ (String)param.get("txt_hijos_alta")+","+ (String)param.get("cbo_estudio")+",'"+ (String)param.get("txt_telefono_alta")+"','"+ (String)param.get("txt_celular_alta")+"','"+ (String)param.get("txt_email_alta")+"','"+ (String)param.get("txt_pantalon_alta")+"','"+ (String)param.get("txt_camisa_alta")+"','"+ (String)param.get("txt_calzado_alta")+"','"+ (String)param.get("txt_libreta_alta")+"','"+ (String)param.get("txt_cta_cese_alta")+"','"+ (String)param.get("txt_fecha_alta_alta")+"','"+ (String)param.get("txt_fecha_baja_alta")+"',"+ (String)param.get("cbo_situacion_empleado")+",'"+(String)param.get("txt_calle_real_alta")+"','"+ (String)param.get("txt_nro_real_alta")+"','"+ (String)param.get("cbo_partido_real")+"','"+ (String)param.get("cbo_localidad_real")+"','"+ (String)param.get("cbo_provincia_real")+"','"+ (String)param.get("txt_cp_real_alta")+"','"+ (String)param.get("txt_calle_legal_alta")+"','"+ (String)param.get("txt_nro_legal_alta")+"','"+ (String)param.get("cbo_partido_legal")+"','"+ (String)param.get("cbo_localidad_legal")+"','"+ (String)param.get("cbo_provincia_legal")+"','"+ (String)param.get("txt_cp_legal_alta")+"')";
            System.out.println("Cadena de insercion: " + sql_insert);
            execute(sql_insert.toUpperCase());
        }
        catch(Exception exc){
           throw new Exception(exc.getMessage());
        }       
    }

    @Override
    public void delete(HashMap param) throws Exception {
        try{
            java.util.Date dia=new java.util.Date();
            String sql_delete="UPDATE EMPLEADO SET FECHA_BAJA='"+dia.getDate()+"/"+(dia.getMonth()+1)+"/"+(1900+dia.getYear())+"' WHERE LEGAJO="+(String)param.get("txt_legajo_alta");
            System.out.println("Cadena de delete: " + sql_delete);
            execute(sql_delete);
        }
        catch(Exception exc){
        		throw new Exception(exc.getMessage());
        }        
    }

    @Override
    public void update(HashMap param) throws Exception {
        try{
            String legajo=(String)param.get("txt_legajo_alta");
            String fecha_alta=(String)param.get("txt_fecha_alta_alta");
            String sql_update="UPDATE EMPLEADO set apellido='"+(String)param.get("txt_apellido_alta")+"', nombre='"+(String)param.get("txt_nombre_alta")+"', tipo_documento='"+(String)param.get("cbo_tipo_documento")+"', numero_documento="+(String)param.get("txt_dni_alta")+", cod_categoria="+(String)param.get("cbo_categoria")+", cuil='"+(String)param.get("txt_cuil_alta")+"', fecha_nacimiento='"+(String)param.get("txt_fecha_nac_alta")+"', nacionalidad='"+(String)param.get("txt_nacionalidad_alta")+"', cod_estado_civil="+(String)param.get("cbo_estado_civil")+", cantidad_hijos="+(String)param.get("txt_hijos_alta")+", cod_estudio="+(String)param.get("cbo_estudio") +", telefono='"+(String)param.get("txt_telefono_alta")+"', celular='"+(String)param.get("txt_celular_alta") +"', e_mail='"+(String)param.get("txt_email_alta")+"', talle_pantalon='"+(String)param.get("txt_pantalon_alta")+ "', talle_camisa='"+(String)param.get("txt_camisa_alta")+"', calzado='"+(String)param.get("txt_calzado_alta")+ "', nro_libreta_cese='"+(String)param.get("txt_libreta_alta")+"', nro_cta_cese_laboral='"+(String)param.get("txt_cta_cese_alta")+ "', fecha_alta='"+(String)param.get("txt_fecha_alta_alta")+"', fecha_baja='"+(String)param.get("txt_fecha_baja_alta")+ "', cod_situacion="+(String)param.get("cbo_situacion_empleado")+", domicilio_real='" +(String)param.get("txt_calle_real_alta")+"', nro_real='"+(String)param.get("txt_nro_real_alta")+ "', partido_real='"+(String)param.get("cbo_partido_real")+"', localidad_real='"+(String)param.get("cbo_localidad_real") +"', provincia_real='"+(String)param.get("cbo_provincia_real")+"', cp_real='"+(String)param.get("txt_cp_real_alta")+ "', domicilio_legal='"+(String)param.get("txt_calle_legal_alta")+"', nro_legal='"+(String)param.get("txt_nro_legal_alta")+ "', partido_legal='"+(String)param.get("cbo_partido_legal")+"', localidad_legal='"+(String)param.get("cbo_localidad_legal")+ "', provincia_legal='"+(String)param.get("cbo_provincia_legal")+"', cp_legal='"+(String)param.get("txt_cp_legal_alta")+"'";
            CollectionEmpleado collection=new CollectionEmpleado();
            if(!fecha_alta.equals("")){
                legajo=String.valueOf(collection.getUltimoLegajo());
                sql_update+= ", legajo=" +legajo;
            } else{
                if(Integer.parseInt(legajo)<900000){
                legajo=String.valueOf(collection.getUltimoLegajoStandBy());
                sql_update+= ", legajo=" +legajo;
                }
            }
            sql_update+=" where legajo="+(String)param.get("txt_legajo_alta");
            System.out.println("Cadena de update: " + sql_update);
            execute(sql_update.toUpperCase());
        }
        catch(Exception exc){
        		throw new Exception(exc.getMessage());
        }       
    }

}
