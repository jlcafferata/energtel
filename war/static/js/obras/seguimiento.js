function onload(){
	ng.ready( function() {
	    var cal_fecha_inicio = new ng.Calendar({
   	 	input: 'txt_fecha_alta_presupuestada', // the input field id
		start_date: 'last year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	    var cal_fecha_cierre = new ng.Calendar({
   	 	input: 'txt_fecha_cierre_presupuestada', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_certificacion = new ng.Calendar({
   	 	input: 'txt_fecha_certificacion_presupuestada', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_pago = new ng.Calendar({
   	 	input: 'txt_fecha_pago', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});	
	$("#txt_poa_alta").focus();
}

function guardar(accion, modalidad){
		var estado='';
		if(accion=='alta'){
				estado='PRE';
		}else if(accion=='certificar'){
				estado='CER';
		}else if(accion=='facturar'){
				estado='FAC';
		}else if(accion=='cobrar'){
				estado='COB';
		}else if(accion='iniciar'){
				estado='EJE';
		}
		    
	  if(modalidad=='A'){//alta
			confirmar_alta(estado);
	  } else if(modalidad=='M'){ //modificacion
	  	confirmar_modificacion(estado);
	  }	

		
}


function validar_datos(){
    var mensaje='';
    var txt_poa=         				$("#txt_poa_alta").val(),          
        txt_cuil=        				$("#txt_cuil").val(),
        txt_fecha_inicio=    	  $("#txt_fecha_alta_presupuestada").val(),       
        txt_fecha_cierre=     	$("#txt_fecha_cierre_presupuestada").val(),     
        txt_fecha_certificacion=$("#txt_fecha_certificacion_presupuestada").val(),       
        cbo_zona_obra_alta=     $("#cbo_zona_obra_alta").val(),        
        cbo_tipo_obra_alta=    	$("#cbo_tipo_obra_alta").val(),        
        txt_medicion_estimada=  $("#txt_medicion_estimada_presupuestada").val(),
        cbo_especificacion_obra=$("#cbo_especificacion_obra").val(),   
        cbo_forma_obra=  				$("#cbo_forma_obra").val(),
        txt_fecha_pago=					$("#txt_fecha_pago").val(),
        txt_nro_recibo=					$("#txt_nro_recibo_presupuestada").val(),
        txt_nro_orden_compra=		$("#txt_nro_orden_compra_presupuestada").val(),
        txt_orden_compra=				$("#txt_valor_orden_compra_presupuestada").val(),
        txt_observacion=				$("#txt_observacion_presupuestadas").val();
    
    
    if(typeof(txt_fecha_inicio)=='undefined'){
    	txt_fecha_inicio='';
    }
    if(typeof(txt_fecha_certificacion)=='undefined'){
    	txt_fecha_certificacion='';
    }
    if(typeof(txt_fecha_cierre)=='undefined'){
    	txt_fecha_cierre='';
    }
    if(typeof(txt_fecha_pago)=='undefined'){
    	txt_fecha_pago='';
    }
    
    
    txt_fecha_inicio=fecha_formateada(txt_fecha_inicio);
    txt_fecha_certificacion=fecha_formateada(txt_fecha_certificacion);
    txt_fecha_cierre=fecha_formateada(txt_fecha_cierre);
    txt_fecha_pago=fecha_formateada(txt_fecha_pago);
    
    if((txt_fecha_cierre!='' || txt_fecha_certificacion!='' || txt_fecha_pago!='') && txt_fecha_inicio==''){
    	mensaje+='* No puede ingresar fecha de cierre, de certificacion o de pago sin haber ingresado fecha de inicio \n';	
    }
    
    if(txt_fecha_cierre!='' && txt_fecha_inicio!='' && (txt_fecha_cierre-txt_fecha_inicio)<0){
    	mensaje+='* La fecha de cierre no puede ser menor a la fecha de inicio \n';	
    }
    
    if(txt_fecha_certificacion!='' && txt_fecha_inicio!='' && (txt_fecha_certificacion-txt_fecha_inicio)<0){
    	mensaje+='* La fecha de certificacion no puede ser menor a la fecha de inicio \n';	
    }

    if(txt_fecha_pago!='' && txt_fecha_inicio!='' && (txt_fecha_pago-txt_fecha_inicio)<0){
    	mensaje+='* La fecha de pago no puede ser menor a la fecha de inicio \n';	
    }

		if(txt_poa==''){
        mensaje+='* Debe ingresar POA \n';
    }     
    if(txt_cuil!='' && txt_cuil.length<13){
        mensaje+='* Debe ingresar un cuil valido \n';
    }
    if(cbo_tipo_obra_alta==''){
        mensaje+='* Debe ingresar Tipo Obra \n';
    }
    if(cbo_zona_obra_alta==''){
        mensaje+='* Debe ingresar Zona \n';
    }
    
    if(txt_medicion_estimada==''){
        mensaje+='* Debe ingresar medicion estimada \n';
    }
    
    if(cbo_especificacion_obra==''){
        mensaje+='* Debe ingresar especificacion de obra \n';
    }
    
    if(cbo_forma_obra==''){
        mensaje+='* Debe ingresar forma de obra \n';
    }        
    if(txt_nro_recibo!='' && txt_nro_recibo<'0'){
        mensaje+='* El nro de recibo debe ser mayor a 0 \n';
    }    
    
    if(txt_nro_orden_compra!='' && txt_nro_orden_compra<'0'){
        mensaje+='* El nro de orden de compra debe ser mayor a 0 \n';
    } 
    
    if(txt_orden_compra!='' && txt_orden_compra<'0'){
        mensaje+='* El valor de la orden de compra debe ser mayor a 0 \n';
    }
    
    
    if(mensaje!=''){
        alert(mensaje);
        return false;
    } else{
    		return true;
    }
    
    
}

function evaluar_pasaje_por_fecha(estado){
	  var txt_fecha_inicio=    	  $("#txt_fecha_alta_presupuestada").val(),       
        txt_fecha_cierre=     	$("#txt_fecha_cierre_presupuestada").val(),     
        txt_fecha_certificacion=$("#txt_fecha_certificacion_presupuestada").val(),       
        txt_fecha_pago=					$("#txt_fecha_pago").val();
    
    if(typeof(txt_fecha_inicio)=='undefined'){
    	txt_fecha_inicio='';
    }
    if(typeof(txt_fecha_certificacion)=='undefined'){
    	txt_fecha_certificacion='';
    }
    if(typeof(txt_fecha_cierre)=='undefined'){
    	txt_fecha_cierre='';
    }
    if(typeof(txt_fecha_pago)=='undefined'){
    	txt_fecha_pago='';
    }
    
    var pasar_a=estado;
     
	  if(txt_fecha_pago!=''){
			if(confirm('Ha ingresado fecha de PAGO. La obra va a moverse a FACTURADA. Desea continuar?')){
				pasar_a='FAC';
			}else{
				pasar_a='';
			}
	  } else{
		  if(txt_fecha_certificacion!=''){
						if(confirm('Ha ingresado fecha de CERTIFICACION. La obra va a moverse  a CERTIFICADA. Desea continuar?')){
							pasar_a='CER';				
						}else{
							pasar_a='';
						}
			} else{ 
					if(txt_fecha_cierre!=''){
						if(!confirm('Ha ingresado fecha de CIERRE. Confirma establecerla en este momento?')){
							pasar_a='';
						}
					} else{
						   if(txt_fecha_inicio!=''){
								if(confirm('Ha ingresado fecha de INICIO. La obra va a moverse a EN EJECUCION. Desea continuar?')){
									pasar_a='EJE';				
								} else{
										pasar_a='';
								}
						   }
					}
		   }
	  }
  	
  	return pasar_a;
}

function validar_fechas_por_estado(estado){
	var txt_fecha_inicio=    	  $("#txt_fecha_alta_presupuestada").val(),       
        txt_fecha_cierre=     	$("#txt_fecha_cierre_presupuestada").val(),     
        txt_fecha_certificacion=$("#txt_fecha_certificacion_presupuestada").val(),       
        txt_fecha_pago=					$("#txt_fecha_pago").val();
    
    if(typeof(txt_fecha_inicio)=='undefined'){
    	txt_fecha_inicio='';
    }
    if(typeof(txt_fecha_certificacion)=='undefined'){
    	txt_fecha_certificacion='';
    }
    if(typeof(txt_fecha_cierre)=='undefined'){
    	txt_fecha_cierre='';
    }
    if(typeof(txt_fecha_pago)=='undefined'){
    	txt_fecha_pago='';
    }
	
	if(estado=='FAC' && txt_fecha_pago==''){
		alert('Debe ingresar fecha de pago para cambiar a estado FACTURADO');
		return false;
	}
	if(estado=='CER' && txt_fecha_certificacion==''){
		alert('Debe ingresar fecha de certificacion para cambiar a estado CERTICADO');
		return false;
	}
	
	return true;
	
}

function confirmar_modificacion(estado){
	if(!validar_datos()){
       return false;
    }    
    if(!validar_fechas_por_estado(estado)){
		return false;
	}
	  
	estado=evaluar_pasaje_por_fecha(estado);
		
	if(estado==''){
		return false;
	}
		
    var parametros={
        accion: 'M',
        poa_alta:                       $("#txt_poa_alta").val(), 
        cuil:                           $("#txt_cuil").val(),   
        fecha_inicio:                   $("#txt_fecha_alta_presupuestada").val(),    
        fecha_cierre:                   $("#txt_fecha_cierre_presupuestada").val(), 
        fecha_certificacion_presupuestada:  $("#txt_fecha_certificacion_presupuestada").val(), 
        zona_obra_alta:                 $("#cbo_zona_obra_alta").val(), 
        tipo_obra_alta:                 $("#cbo_tipo_obra_alta").val(),         
        medicion_estimada_presupuestada:$("#txt_medicion_estimada_presupuestada").val(),         
        especificacion_obra:            $("#cbo_especificacion_obra").val(),           
        forma_obra:                     $("#cbo_forma_obra").val(),         
        fecha_pago:                     $("#txt_fecha_pago").val(),            
        nro_recibo_presupuestada:       $("#txt_nro_recibo_presupuestada").val(),  
        nro_orden_compra_presupuestada: $("#txt_nro_orden_compra_presupuestada").val(),     
        valor_orden_compra_presupuestada: $("#txt_valor_orden_compra_presupuestada").val(), 
        observacion_presupuestadas:     $("#txt_observacion_presupuestadas").val(),
        estado:                         estado  
    };
    console.log(parametros);
    grabar(parametros);
}

function confirmar_alta(estado){
    if(!validar_datos()){
        return false;
    }    
 	if(!validar_fechas_por_estado(estado)){
		return false;
	}
    var parametros={
        accion: 'A',
        poa_alta:                       $("#txt_poa_alta").val(), 
        cuil:                           $("#txt_cuil").val(),   
        fecha_inicio:                   $("#txt_fecha_alta_presupuestada").val(),    
        fecha_cierre:                   $("#txt_fecha_cierre_presupuestada").val(), 
        fecha_certificacion_presupuestada:  $("#txt_fecha_certificacion_presupuestada").val(), 
        zona_obra_alta:                 $("#cbo_zona_obra_alta").val(), 
        tipo_obra_alta:                 $("#cbo_tipo_obra_alta").val(),         
        medicion_estimada_presupuestada:$("#txt_medicion_estimada_presupuestada").val(),         
        especificacion_obra:            $("#cbo_especificacion_obra").val(),           
        forma_obra:                     $("#cbo_forma_obra").val(),         
        fecha_pago:                     $("#txt_fecha_pago").val(),            
        nro_recibo_presupuestada:       $("#txt_nro_recibo_presupuestada").val(),  
        nro_orden_compra_presupuestada: $("#txt_nro_orden_compra_presupuestada").val(),     
        valor_orden_compra_presupuestada: $("#txt_valor_orden_compra_presupuestada").val(), 
        observacion_presupuestadas:     $("#txt_observacion_presupuestadas").val(),
        estado:							estado  
    };
    console.log(parametros);
    grabar(parametros);    		
}


function grabar(parametros){
    console.log(parametros);
    $.ajax({
      type: 'POST',
      url: 'manager.obra',
      data: parametros,
      success: function(response){
           if(response.substring(0,5)=='ERROR' && (parametros.accion=="A" || parametros.accion=="M")){
                Notifier.warning(response.substring(6));
           }else{    
                Notifier.success('\n ' + (parametros.accion=="A"? 'Alta': 'Modificacion') + ' de la obra efectuada con exitoso ');
           } 
              finalizar_cambios();	
                                 
      },
      error: function(response){
            Notifier.error(response.statusText);	
      }
    });
}
