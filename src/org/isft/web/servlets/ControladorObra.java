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
import org.isft.logic.updater.AbmObra;


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
                               
                HashMap param=new HashMap();
                
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
               
        AbmObra abm=new AbmObra();
        
	try{
            if(accion.equals("A")){
                    abm.insert(param);
            } else if(accion.equals("B")){
                    abm.delete(param);
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
