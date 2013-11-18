/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isft.web.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.isft.logic.updater.AbmEmpleado;
import java.util.HashMap;
import java.util.Iterator;
import org.isft.domain.helper.FechaHora;
import org.isft.logic.updater.AbmObra;
import org.isft.logic.validator.ChequearDatosObra;


public class ControladorObra  extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String accion=request.getParameter("accion");
                String poa_alta = request.getParameter("poa_alta");
                String cuil = request.getParameter("cuil");
                String fecha_inicio = request.getParameter("fecha_inicio");
                String fecha_cierre = request.getParameter("fecha_cierre");
                String fecha_certificacion_presupuestada = request.getParameter("fecha_certificacion_presupuestada");
                String zona_obra_alta = request.getParameter("zona_obra_alta");
                String tipo_obra_alta = request.getParameter("tipo_obra_alta");
                String medicion_estimada_presupuestada = request.getParameter("medicion_estimada_presupuestada");
                String especificacion_obra = request.getParameter("especificacion_obra");
                String forma_obra = request.getParameter("forma_obra");
                String fecha_pago = request.getParameter("fecha_pago");
                String nro_recibo_presupuestada = request.getParameter("nro_recibo_presupuestada");
                String nro_orden_compra_presupuestada = request.getParameter("nro_orden_compra_presupuestada");
                String valor_orden_compra_presupuestada = request.getParameter("valor_orden_compra_presupuestada");
                String observacion_presupuestadas = request.getParameter("observacion_presupuestadas");
                String legajo_empleado = request.getParameter("legajo_empleado");
                String estado = request.getParameter("estado");
                String fecha_certificacion_avance = request.getParameter("fecha_certificacion_avance");
                String empleados = request.getParameter("empleados");
                String materiales = request.getParameter("materiales");
                String txt_pendiente = request.getParameter("txt_pendiente");
                String txt_zanjeo = request.getParameter("txt_zanjeo");
                String txt_rotura = request.getParameter("txt_rotura");
                String txt_cruce = request.getParameter("txt_cruce");
                String txt_pozo_maq = request.getParameter("txt_pozo_maq");
                String txt_pozo_rec = request.getParameter("txt_pozo_rec");
                String txt_pozo_emp = request.getParameter("txt_pozo_emp");
                String txt_pozo_rulo = request.getParameter("txt_pozo_rulo");
                String txt_jornal = request.getParameter("txt_jornal");
                String txt_observacion = request.getParameter("txt_observacion");
                String tareas = request.getParameter("tareas");
                
                if(accion==null){accion="";}                  
                if(poa_alta==null){poa_alta="";}                  
                if(cuil==null){cuil="";}                  
                if(fecha_inicio==null){fecha_inicio="";}                  
                if(fecha_cierre==null){fecha_cierre="";}                  
                if(fecha_certificacion_presupuestada==null){fecha_certificacion_presupuestada="";}                  
                if(zona_obra_alta==null){zona_obra_alta="";}                  
                if(tipo_obra_alta==null){tipo_obra_alta="";}                  
                if(medicion_estimada_presupuestada==null){medicion_estimada_presupuestada="";}                  
                if(especificacion_obra==null){especificacion_obra="";}                  
                if(forma_obra==null){forma_obra="";}                  
                if(fecha_pago==null){fecha_pago="";}                  
                if(nro_recibo_presupuestada==null){nro_recibo_presupuestada="";}                  
                if(nro_orden_compra_presupuestada==null){nro_orden_compra_presupuestada="";}                  
                if(valor_orden_compra_presupuestada==null){valor_orden_compra_presupuestada="";}                  
                if(observacion_presupuestadas==null){observacion_presupuestadas="";}                                   
                if(legajo_empleado==null){legajo_empleado="";}                                   
                if(fecha_certificacion_avance==null){fecha_certificacion_avance="";}
                if(empleados==null){empleados="";}
                if(materiales==null){materiales="";}
                if(txt_pendiente==null){txt_pendiente="";}
                if(txt_zanjeo==null){txt_zanjeo="";}
                if(txt_rotura==null){txt_rotura="";}
                if(txt_cruce==null){txt_cruce="";}
                if(txt_pozo_maq==null){txt_pozo_maq="";}
                if(txt_pozo_rec==null){txt_pozo_rec="";}
                if(txt_pozo_emp==null){txt_pozo_emp="";}
                if(txt_pozo_rulo==null){txt_pozo_rulo="";}
                if(txt_jornal==null){txt_jornal="";}
                if(txt_observacion==null){txt_observacion="";}
                if(tareas==null){tareas="";}
                
                HashMap param=new HashMap();
                
                FechaHora fa=new FechaHora();
                String fecha_actual=fa.getFecha()+" "+fa.getHora();
                String hora_carga=fa.getHora();
                
 		param.put("accion",accion);
                param.put("poa_alta",poa_alta);
                param.put("cuil",cuil);
                param.put("fecha_inicio",fecha_inicio);
                param.put("fecha_cierre",fecha_cierre);
                param.put("fecha_certificacion_presupuestada",fecha_certificacion_presupuestada);
                param.put("zona_obra_alta",zona_obra_alta);
                param.put("tipo_obra_alta",tipo_obra_alta);
                param.put("medicion_estimada_presupuestada",medicion_estimada_presupuestada);
                param.put("especificacion_obra",especificacion_obra);
                param.put("forma_obra",forma_obra);
                param.put("fecha_pago",fecha_pago);
                param.put("nro_recibo_presupuestada",nro_recibo_presupuestada);
                param.put("nro_orden_compra_presupuestada",nro_orden_compra_presupuestada);
                param.put("valor_orden_compra_presupuestada",valor_orden_compra_presupuestada);
                param.put("observacion_presupuestadas",observacion_presupuestadas);
                param.put("estado",estado);
                param.put("legajo_empleado","legajo_empleado");
                param.put("fecha_certificacion_avance",fecha_certificacion_avance);
                param.put("empleados",empleados);
                param.put("materiales",materiales);
                param.put("pendiente",txt_pendiente);
                param.put("zanjeo",txt_zanjeo);
                param.put("rotura",txt_rotura);
                param.put("cruce",txt_cruce);
                param.put("pozo_maq",txt_pozo_maq);
                param.put("pozo_rec",txt_pozo_rec);
                param.put("pozo_emp",txt_pozo_emp);
                param.put("pozo_rulo",txt_pozo_rulo);
                param.put("jornal",txt_jornal);
                param.put("observacion",txt_observacion);
                param.put("fecha_actual",fecha_actual);
                param.put("hora_carga",hora_carga);
                param.put("tareas",tareas);
                
                response.setContentType("html/text");
                ChequearDatosObra cdo=new ChequearDatosObra();
                
                
        AbmObra abm=new AbmObra();
        
	try{
            if(accion.equals("A")){
                    String validos=cdo.esValidoParaAltaPoa((String)param.get("poa_alta"));
                    if(validos.equals("")){
                        abm.insert(param);
                    }else{
                        response.getWriter().write("ERROR:"+validos);
                        return;
                    }
                    
            } else if(accion.equals("IE")){
                    abm.iniciarEjecucion(param);
            } else {
                    abm.update(param);
            }
        } 
        catch(ServletException exc){
                throw new ServletException(exc.getMessage());
        }
        catch(Exception exc){
                throw new ServletException(exc.getMessage());
        }
  }
}
