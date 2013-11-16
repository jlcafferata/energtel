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

public class ControladorEmpleado  extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String accion=request.getParameter("accion");
                String txt_legajo_alta = request.getParameter("txt_legajo_alta");
                String txt_apellido_alta = request.getParameter("txt_apellido_alta");
                String txt_nombre_alta = request.getParameter("txt_nombre_alta");
                String cbo_estudio = request.getParameter("cbo_estudio");
                String txt_fecha_alta_alta = request.getParameter("txt_fecha_alta_alta");
                String txt_fecha_baja_alta = request.getParameter("txt_fecha_baja_alta");
                String txt_dni_alta = request.getParameter("txt_dni_alta");
                String txt_cuil_alta = request.getParameter("txt_cuil_alta");
                String txt_nacionalidad_alta = request.getParameter("txt_nacionalidad_alta");
                String txt_fecha_nac_alta = request.getParameter("txt_fecha_nac_alta");
                String cbo_estado_civil = request.getParameter("cbo_estado_civil");
                String txt_hijos_alta = request.getParameter("txt_hijos_alta");
                String txt_calle_legal_alta = request.getParameter("txt_calle_legal_alta");
                String txt_nro_legal_alta = request.getParameter("txt_nro_legal_alta");
                String cbo_provincia_legal = request.getParameter("cbo_provincia_legal");
                String cbo_partido_legal = request.getParameter("cbo_partido_legal");
                String cbo_localidad_legal = request.getParameter("cbo_localidad_legal");
                String txt_cp_legal_alta = request.getParameter("txt_cp_legal_alta");
                String txt_calle_real_alta = request.getParameter("txt_calle_real_alta");
                String txt_nro_real_alta = request.getParameter("txt_nro_real_alta");
                String cbo_provincia_real = request.getParameter("cbo_provincia_real");
                String cbo_partido_real = request.getParameter("cbo_partido_real");
                String cbo_localidad_real = request.getParameter("cbo_localidad_real");
                String txt_cp_real_alta = request.getParameter("txt_cp_real_alta");
                String txt_pantalon_alta = request.getParameter("txt_pantalon_alta");
                String txt_camisa_alta = request.getParameter("txt_camisa_alta");
                String txt_calzado_alta = request.getParameter("txt_calzado_alta");
                String txt_libreta_alta = request.getParameter("txt_libreta_alta");
                String txt_cta_cese_alta = request.getParameter("txt_cta_cese_alta");
                String cbo_situacion_empleado=request.getParameter("cbo_situacion_empleado");
                String txt_telefono_alta=request.getParameter("txt_telefono_alta");
                String cbo_tipo_documento=request.getParameter("cbo_tipo_documento");
                String txt_celular_alta=request.getParameter("txt_celular_alta");
                String txt_email_alta=request.getParameter("txt_email_alta");
                String cbo_categoria=request.getParameter("cbo_categoria");
                if(accion==null){accion="";}
                if(txt_legajo_alta==null){txt_legajo_alta="";}                  
                if(txt_apellido_alta==null){txt_apellido_alta="";}                  
                if(txt_nombre_alta==null){txt_nombre_alta="";}                  
                if(cbo_estudio==null){cbo_estudio="";}                  
                if(txt_fecha_alta_alta==null){txt_fecha_alta_alta="";}                  
                else{
                    System.out.println("FEHCA ALTA: " + txt_fecha_alta_alta);
                    if(txt_fecha_alta_alta.length()>4){
                        String anio_alta=txt_fecha_alta_alta.substring(0,4);
                        String mes_alta="";
                        String guion_mes_corto_alta="";
                        String dia_alta="";
                        if(txt_fecha_alta_alta.length()==8){
                            mes_alta="0"+txt_fecha_alta_alta.substring(5,6);
                            dia_alta="0"+txt_fecha_alta_alta.substring(7,8);
                        } else if(txt_fecha_alta_alta.length()==9){
                            guion_mes_corto_alta=txt_fecha_alta_alta.substring(6,7);
                            if(guion_mes_corto_alta.equals("-")){
                                mes_alta="0"+txt_fecha_alta_alta.substring(5,6);
                                dia_alta=txt_fecha_alta_alta.substring(7,9);
                            } else{
                                mes_alta=txt_fecha_alta_alta.substring(5,7);
                                dia_alta="0"+txt_fecha_alta_alta.substring(8,9);
                            }                    
                        } else{
                            mes_alta=txt_fecha_alta_alta.substring(5,7);
                            dia_alta=txt_fecha_alta_alta.substring(8,10);
                        }
                        txt_fecha_alta_alta=dia_alta+"/"+mes_alta+"/"+anio_alta;
                    }
                }
                if(txt_fecha_baja_alta==null){/*txt_fecha_baja_alta="";*/}                  
                else{
                    if(txt_fecha_baja_alta.length()>4){
                        String anio_baja=txt_fecha_baja_alta.substring(0,4);
                        String mes_baja="";
                        String guion_mes_corto_baja="";
                        String dia_baja="";
                        if(txt_fecha_baja_alta.length()==8){
                            mes_baja="0"+txt_fecha_baja_alta.substring(5,6);
                            dia_baja="0"+txt_fecha_baja_alta.substring(7,8);
                        } else if(txt_fecha_baja_alta.length()==9){
                            guion_mes_corto_baja=txt_fecha_baja_alta.substring(6,7);
                            if(guion_mes_corto_baja.equals("-")){
                                mes_baja="0"+txt_fecha_baja_alta.substring(5,6);
                                dia_baja=txt_fecha_baja_alta.substring(7,9);
                            } else{
                                mes_baja=txt_fecha_baja_alta.substring(5,7);
                                dia_baja="0"+txt_fecha_baja_alta.substring(8,9);
                            }                    
                        } else{
                            mes_baja=txt_fecha_baja_alta.substring(5,7);
                            dia_baja=txt_fecha_baja_alta.substring(8,10);
                        }
                        txt_fecha_baja_alta=dia_baja+"/"+mes_baja+"/"+anio_baja;
                    }                    
                }
                if(txt_dni_alta==null){txt_dni_alta="";}                  
                if(txt_cuil_alta==null){txt_cuil_alta="";}                  
                if(txt_nacionalidad_alta==null){txt_nacionalidad_alta="";}                  
                if(txt_fecha_nac_alta==null){/*txt_fecha_nac_alta="";*/}
                else{
                    if(txt_fecha_nac_alta.length()>4){
                        String anio_nac=txt_fecha_nac_alta.substring(0,4);
                        String mes_nac="";
                        String guion_mes_corto_nac="";
                        String dia_nac="";
                        if(txt_fecha_nac_alta.length()==8){
                            mes_nac="0"+txt_fecha_nac_alta.substring(5,6);
                            dia_nac="0"+txt_fecha_nac_alta.substring(7,8);
                        } else if(txt_fecha_nac_alta.length()==9){
                            guion_mes_corto_nac=txt_fecha_nac_alta.substring(6,7);
                            if(guion_mes_corto_nac.equals("-")){
                                mes_nac="0"+txt_fecha_nac_alta.substring(5,6);
                                dia_nac=txt_fecha_nac_alta.substring(7,9);
                            } else{
                                mes_nac=txt_fecha_nac_alta.substring(5,7);
                                dia_nac="0"+txt_fecha_nac_alta.substring(8,9);
                            }                    
                        } else{
                            mes_nac=txt_fecha_nac_alta.substring(5,7);
                            dia_nac=txt_fecha_nac_alta.substring(8,10);
                        }
                        txt_fecha_nac_alta=dia_nac+"/"+mes_nac+"/"+anio_nac;
                    } else{
                        txt_fecha_nac_alta=null;
                    }
                }
                if(cbo_estado_civil==null){cbo_estado_civil="";}                  
                if(txt_hijos_alta==null){txt_hijos_alta="0";}                  
                if(txt_calle_legal_alta==null){txt_calle_legal_alta="";}                  
                if(txt_nro_legal_alta==null){txt_nro_legal_alta="";}                  
                if(cbo_provincia_legal==null){cbo_provincia_legal="";}                  
                if(cbo_partido_legal==null){cbo_partido_legal="";}                  
                if(cbo_localidad_legal==null){cbo_localidad_legal="";}                  
                if(txt_cp_legal_alta==null){txt_cp_legal_alta="";}                  
                if(txt_calle_real_alta==null){txt_calle_real_alta="";}                  
                if(txt_nro_real_alta==null){txt_nro_real_alta="";}                  
                if(cbo_provincia_real==null){cbo_provincia_real="";}                  
                if(cbo_partido_real==null){cbo_partido_real="";}                  
                if(cbo_localidad_real==null){cbo_localidad_real="";}                  
                if(txt_cp_real_alta==null){txt_cp_real_alta="";}                  
                if(txt_pantalon_alta==null){txt_pantalon_alta="";}                  
                if(txt_camisa_alta==null){txt_camisa_alta="";}                  
                if(txt_calzado_alta==null){txt_calzado_alta="";}                  
                //if(txt_libreta_alta==null){txt_libreta_alta="";}                  
                //if(txt_cta_cese_alta==null){txt_cta_cese_alta="";}  
                if(cbo_situacion_empleado==null){cbo_situacion_empleado="";}
                if(txt_telefono_alta==null){txt_telefono_alta="";}
                if(cbo_tipo_documento==null){cbo_tipo_documento="";}
                if(txt_celular_alta==null){txt_celular_alta="";}
                if(txt_email_alta==null){txt_email_alta="";}
 		if(cbo_categoria==null){cbo_categoria="";}
                
                HashMap param=new HashMap();
 		param.put("txt_legajo_alta",txt_legajo_alta);
                param.put("txt_apellido_alta",txt_apellido_alta);
                param.put("txt_nombre_alta",txt_nombre_alta);
                param.put("cbo_estudio",cbo_estudio);
                param.put("txt_fecha_alta_alta",txt_fecha_alta_alta);
                param.put("txt_fecha_baja_alta",txt_fecha_baja_alta);
                param.put("txt_dni_alta",txt_dni_alta);
                param.put("txt_cuil_alta",txt_cuil_alta);
                param.put("txt_nacionalidad_alta",txt_nacionalidad_alta);
                param.put("txt_fecha_nac_alta",txt_fecha_nac_alta);
                param.put("cbo_estado_civil",cbo_estado_civil);
                param.put("txt_hijos_alta",txt_hijos_alta);
                param.put("txt_calle_legal_alta",txt_calle_legal_alta);
                param.put("txt_nro_legal_alta",txt_nro_legal_alta);
                param.put("cbo_provincia_legal",cbo_provincia_legal);
                param.put("cbo_partido_legal",cbo_partido_legal);
                param.put("cbo_localidad_legal",cbo_localidad_legal);
                param.put("txt_cp_legal_alta",txt_cp_legal_alta);
                param.put("txt_calle_real_alta",txt_calle_real_alta);
                param.put("txt_nro_real_alta",txt_nro_real_alta);
                param.put("cbo_provincia_real",cbo_provincia_real);
                param.put("cbo_partido_real",cbo_partido_real);
                param.put("cbo_localidad_real",cbo_localidad_real);
                param.put("txt_cp_real_alta",txt_cp_real_alta);
                param.put("txt_pantalon_alta",txt_pantalon_alta);
                param.put("txt_camisa_alta",txt_camisa_alta);
                param.put("txt_calzado_alta",txt_calzado_alta);
                param.put("txt_libreta_alta",txt_libreta_alta);
                param.put("txt_cta_cese_alta",txt_cta_cese_alta);
                param.put("cbo_situacion_empleado",cbo_situacion_empleado);
                param.put("txt_telefono_alta",txt_telefono_alta);
                param.put("cbo_tipo_documento",cbo_tipo_documento);
                param.put("txt_celular_alta",txt_celular_alta);
                param.put("txt_email_alta",txt_email_alta);
                param.put("cbo_categoria", cbo_categoria);
 		AbmEmpleado abm=new AbmEmpleado();
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
