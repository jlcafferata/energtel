function onload_alta(){
	ng.ready( function() {
	    var cal_fecha_alta_alta = new ng.Calendar({
   	 	input: 'txt_fecha_alta_alta', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_baja_alta = new ng.Calendar({
   	 	input: 'txt_fecha_baja_alta', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_nac_baja = new ng.Calendar({
   	 	input: 'txt_fecha_nac_alta', // the input field id
		start_date: 'year -45', // the start date (default is today)
		end_date: 'year +45', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});
	
	$("#txt_apellido_alta").focus();
}
function grabar(parametros){
    console.log(parametros);
    $.ajax({
      type: 'POST',
      url: 'manager.empleado',
      data: parametros,
      success: function(response){
           Notifier.success('\n ' + (parametros.accion=="A"? 'Alta': 'Modificacion') + ' de empleado efectuada con exitoso ');
   				 finalizar_cambios();	
      },
      error: function(response){
            Notifier.error(response.statusText);	
      }
    });
}

function confirmar_accion(accion){
	if(accion=='A'){
		confirmar_alta();
	} else if(accion=='M'){
		confirmar_modificacion();
	}	
}

function confirmar_modificacion(){
    var txt_dni=$("#txt_dni_alta").val(),
				txt_cuil=$("#txt_cuil_alta").val(),
				txt_fecha_nac_alta=$("#txt_fecha_nac_alta").val();
    
    if(!validar_datos()){
        return false;
    }    
    if($("#txt_fecha_alta_alta").val()===''){
        if(!confirm('No ingresó fecha de alta. Será grabado como empleado en stand by. Desea continuar?')){
            return false;
        }
    }
    if(typeof(txt_cuil)=='' || txt_cuil==null){
    	txt_cuil='';
    }
    if(typeof(txt_dni)==''){
    	txt_dni='';
    }
    
    var parametros={
        accion: "M",        
        txt_legajo_alta:      $("#txt_legajo_alta").val(),       
        txt_apellido_alta:    $("#txt_apellido_alta").val(),     
        txt_nombre_alta:      $("#txt_nombre_alta").val(),       
        cbo_estudio:          $("#cbo_estudio").val(),           
        txt_fecha_alta_alta:  $("#txt_fecha_alta_alta").val(),   
        txt_fecha_baja_alta:  $("#txt_fecha_baja_alta").val(),   
        cbo_tipo_documento:   $("#cbo_tipo_documento").val(),          
        txt_dni_alta:         txt_dni,          
        txt_cuil_alta:        txt_cuil,         
        txt_nacionalidad_alta:$("#txt_nacionalidad_alta").val(), 
        txt_fecha_nac_alta:   txt_fecha_nac_alta,    
        cbo_estado_civil:     $("#cbo_estado_civil").val(),      
        txt_hijos_alta:       $("#txt_hijos_alta").val(),        
        txt_email_alta:       $("#txt_email_alta").val(),        
        txt_telefono_alta:    $("#txt_telefono_alta").val(),        
        txt_celular_alta:     $("#txt_celular_alta").val(),        
        cbo_categoria:        $("#cbo_categoria").val(),    
        cbo_situacion_empleado:$("#cbo_situacion_empleado").val(),
        txt_calle_legal_alta: $("#txt_calle_legal_alta").val(),  
        txt_nro_legal_alta:   $("#txt_nro_legal_alta").val(),    
        cbo_provincia_legal:  $("#cbo_provincia_legal").val(),   
        cbo_partido_legal:    $("#cbo_partido_legal").val(),     
        cbo_localidad_legal:  $("#cbo_localidad_legal").val(),   
        txt_cp_legal_alta:    $("#txt_cp_legal_alta").val(),     
        txt_calle_real_alta:  $("#txt_calle_real_alta").val(),   
        txt_nro_real_alta:    $("#txt_nro_real_alta").val(),     
        cbo_provincia_real:   $("#cbo_provincia_real").val(),    
        cbo_partido_real:     $("#cbo_partido_real").val(),      
        cbo_localidad_real:   $("#cbo_localidad_real").val(),    
        txt_cp_real_alta:     $("#txt_cp_real_alta").val(),      
        txt_pantalon_alta:    $("#txt_pantalon_alta").val(),     
        txt_camisa_alta:      $("#txt_camisa_alta").val(),       
        txt_calzado_alta:     $("#txt_calzado_alta").val(),      
        txt_libreta_alta:     $("#txt_libreta_alta").val(),      
        txt_cta_cese_alta:    $("#txt_cta_cese_alta").val()
    };
    console.log(parametros);
    grabar(parametros);
}


function validar_datos(){
    var mensaje='';
    var txt_dni_alta=         $("#txt_dni_alta").val(),          
        txt_cuil_alta=        $("#txt_cuil_alta").val(),
        txt_legajo_alta=      $("#txt_legajo_alta").val(),       
        txt_apellido_alta=    $("#txt_apellido_alta").val(),     
        txt_nombre_alta=      $("#txt_nombre_alta").val(),       
        txt_hijos_alta=       $("#txt_hijos_alta").val(),        
        txt_telefono_alta=    $("#txt_telefono_alta").val(),        
        txt_celular_alta=     $("#txt_celular_alta").val(),
        txt_fecha_alta_alta=  $("#txt_fecha_alta_alta").val(),   
        txt_fecha_baja_alta=  $("#txt_fecha_baja_alta").val(),
        txt_fecha_nac_alta= 	$("#txt_fecha_nac_alta").val();
    
    if(typeof(txt_fecha_alta_alta)=='undefined'){
    	txt_fecha_alta_alta='';
    }
    if(typeof(txt_fecha_baja_alta)=='undefined'){
    	txt_fecha_baja_alta='';
    }
    
    if(typeof(txt_dni_alta)=='undefined'){
    		txt_dni_alta='';
    }
    if(typeof(txt_cuil_alta)=='undefined'){
    		txt_cuil_alta='';
    }
    if(typeof(txt_fecha_nac_alta)=='undefined'){
    		txt_fecha_nac_alta='';
    }
    
    
    txt_fecha_alta_alta=fecha_formateada(txt_fecha_alta_alta);
    txt_fecha_baja_alta=fecha_formateada(txt_fecha_baja_alta);
    
    if(txt_fecha_baja_alta!='' && txt_fecha_alta_alta!='' && (txt_fecha_baja_alta-txt_fecha_alta_alta)<0){
    	mensaje+='* La fecha de baja no puede ser menor a la fecha de alta \n';	
    }
    
    
    if(txt_legajo_alta===''){
        mensaje+='* Debe ingresar Legajo \n';
    }     
    if(txt_apellido_alta===''){
        mensaje+='* Debe ingresar Apellido \n';
    }
    if(txt_nombre_alta===''){
        mensaje+='* Debe ingresar Nombre \n';
    }
    if(txt_cuil_alta=='' || (txt_cuil_alta!=='' && txt_cuil_alta.length<13)){
        mensaje+='* Debe ingresar un cuil valido \n';
    }
    if(txt_dni_alta=='' || (txt_dni_alta!=='' && txt_dni_alta.length<8)){
        mensaje+='* Debe ingresar un dni valido \n';
    }
    if(txt_cuil_alta.substring(3,11)!=txt_dni_alta){
        mensaje+='* El dni debe formar parte del cuil ingresado \n';
    }
    if(txt_hijos_alta!='' && txt_hijos_alta<'0'){
        mensaje+='* La cantidad de hijos es erronea \n';
    }
    if(txt_fecha_nac_alta==''){
        mensaje+='* Debe ingresar fecha de nacimiento \n';
    }
    
    if(txt_telefono_alta!=='' && txt_telefono_alta.length<7){
        mensaje+='* El telefono debe tener, al menos, 7 digitos \n';
    }        
    if(txt_celular_alta!=='' && txt_celular_alta.length<8){
        mensaje+='* El telefono celular debe tener, al menos, 8 digitos \n';
    }    
    if(mensaje!==''){
        alert(mensaje);
        return false;
    } else{
        return true;
    }
}

function confirmar_alta(){
		var txt_dni=$("#txt_dni_alta").val(),
				txt_cuil=$("#txt_cuil_alta").val(),
				txt_fecha_nac_alta=$("#txt_fecha_nac_alta").val();
    if(!validar_datos()){
        return false;
    }    
    if($("#txt_fecha_alta_alta").val()===''){
        if(!confirm('No ingresó fecha de alta. Será grabado como empleado en stand by. Desea continuar?')){
            return false;
        }
    }
    
    var parametros={
        accion: 'A',
        txt_legajo_alta:      $("#txt_legajo_alta").val(),       
        txt_apellido_alta:    $("#txt_apellido_alta").val(),     
        txt_nombre_alta:      $("#txt_nombre_alta").val(),       
        cbo_estudio:          $("#cbo_estudio").val(),           
        txt_fecha_alta_alta:  $("#txt_fecha_alta_alta").val(),   
        txt_fecha_baja_alta:  $("#txt_fecha_baja_alta").val(),   
        cbo_tipo_documento:   $("#cbo_tipo_documento").val(),          
        txt_dni_alta:         txt_dni,          
        txt_cuil_alta:        txt_cuil,         
        txt_nacionalidad_alta:$("#txt_nacionalidad_alta").val(), 
        txt_fecha_nac_alta:   txt_fecha_nac_alta,    
        cbo_estado_civil:     $("#cbo_estado_civil").val(),      
        txt_hijos_alta:       $("#txt_hijos_alta").val(),        
        txt_email_alta:       $("#txt_email_alta").val(),        
        txt_telefono_alta:    $("#txt_telefono_alta").val(),        
        txt_celular_alta:     $("#txt_celular_alta").val(),        
        cbo_categoria:        $("#cbo_categoria").val(),    
        cbo_situacion_empleado:$("#cbo_situacion_empleado").val(),
        txt_calle_legal_alta: $("#txt_calle_legal_alta").val(),  
        txt_nro_legal_alta:   $("#txt_nro_legal_alta").val(),    
        cbo_provincia_legal:  $("#cbo_provincia_legal").val(),   
        cbo_partido_legal:    $("#cbo_partido_legal").val(),     
        cbo_localidad_legal:  $("#cbo_localidad_legal").val(),   
        txt_cp_legal_alta:    $("#txt_cp_legal_alta").val(),     
        txt_calle_real_alta:  $("#txt_calle_real_alta").val(),   
        txt_nro_real_alta:    $("#txt_nro_real_alta").val(),     
        cbo_provincia_real:   $("#cbo_provincia_real").val(),    
        cbo_partido_real:     $("#cbo_partido_real").val(),      
        cbo_localidad_real:   $("#cbo_localidad_real").val(),    
        txt_cp_real_alta:     $("#txt_cp_real_alta").val(),      
        txt_pantalon_alta:    $("#txt_pantalon_alta").val(),     
        txt_camisa_alta:      $("#txt_camisa_alta").val(),       
        txt_calzado_alta:     $("#txt_calzado_alta").val(),      
        txt_libreta_alta:     $("#txt_libreta_alta").val(),      
        txt_cta_cese_alta:    $("#txt_cta_cese_alta").val()
    };
    console.log(parametros);
    grabar(parametros);    		
}

