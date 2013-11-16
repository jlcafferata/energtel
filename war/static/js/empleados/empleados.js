function onload(){
	ng.ready( function() {
	    var cal_fecha_desde_alta = new ng.Calendar({
   	 	input: 'txt_fecha_alta_desde', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_hasta_alta = new ng.Calendar({
   	 	input: 'txt_fecha_alta_hasta', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_desde_baja = new ng.Calendar({
   	 	input: 'txt_fecha_baja_desde', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
		var cal_fecha_hasta_baja = new ng.Calendar({
   	 	input: 'txt_fecha_baja_hasta', // the input field id
		start_date: 'year -20', // the start date (default is today)
		end_date: 'year +20', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});
	$("#div_grilla_empleado").load("modulo.go?codPage=1003");
}
function alta(){
	$('.modal-body').load("jsp/empleados/alta.jsp?accion=A");
	$('#myModal').modal('show');
}

function modi(legajo){
	$('.modal-body').load("jsp/empleados/alta.jsp?accion=M&legajo="+legajo);
	$('#myModal').modal('show');
}

function finalizar_cambios(){
	$('#myModal').modal('hide');
	filtrar();
}

function baja(legajo){
	if(confirm('Realmente desea dar de baja al empleado con legajo : ' + legajo + '?')){
		var parametros={
       accion: "B",        
			 txt_legajo_alta: legajo
		}
		$.ajax({
      type: 'POST',
      url: 'manager.empleado',
      data: parametros,
      success: function(response){
           Notifier.success('\n Baja de empleado efectuada con exitoso ');
      		 filtrar();
      },
      error: function(response){
           Notifier.error(response.statusText);	
      }
    });
	}
}

function filtrar(){
	var incluir_lista_espera=$("#chk_empleados_standby").prop("checked");
	var fecha_desde_alta=  $("#txt_fecha_alta_desde").val(),   
        fecha_hasta_alta=  $("#txt_fecha_alta_hasta").val(),
        fecha_desde_baja=$("#txt_fecha_baja_desde").val(),
        fecha_hasta_baja=$("#txt_fecha_baja_hasta").val(),
        legajo=$("#txt_legajo").val(),
        apellido=$("#txt_apellido").val(),
        nombre=$("#txt_nombre").val(),
        dni=$("#txt_dni").val();

        if(typeof(legajo)=='undefined'){
		legajo="";
	}
        if(typeof(apellido)=='undefined'){
		apellido="";
	}
        if(typeof(nombre)=='undefined'){
		nombre="";
	}
        if(typeof(dni)=='undefined'){
		dni="";
	}
	if(typeof(fecha_desde_alta)=='undefined'){
		fecha_desde_alta="";
	}
	if(typeof(fecha_hasta_alta)=='undefined'){
		fecha_hasta_alta="";
	}
        if(typeof(fecha_desde_baja)=='undefined'){
		fecha_desde_baja="";
	}
        if(typeof(fecha_hasta_baja)=='undefined'){
		fecha_hasta_baja="";
	}
	$("#div_grilla_empleado").load("modulo.go?codPage=1003&incluir_lista_espera="+(incluir_lista_espera?"S":"N")+"&fecha_desde_alta="+fecha_desde_alta+"&fecha_hasta_alta="+fecha_hasta_alta+"&fecha_desde_baja="+fecha_desde_baja+"&fecha_hasta_baja="+fecha_hasta_baja+"&legajo="+legajo+"&apellido="+apellido+"&nombre="+nombre+"&dni="+dni);
}