function onload(){
	ng.ready( function() {
	    var cal_fecha_inicio = new ng.Calendar({
   	 	input: 'txt_fecha_inicio', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	    var cal_fecha_certificacion = new ng.Calendar({
   	 	input: 'txt_fecha_certificacion', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});
	
}
function ver_empleados(){
	$("#div_button_add_empleado").hide("slow");
	$("#div_empleados").show();
}

function ok_add_empleado(){
	
        var mensaje='';
        var txt_poa=$("#txt_poa_ejecucion").val();
        var cbo_empleado=$("#cbo_empleado").val();
        if(txt_poa==''){
            mensaje+='* Debe ingresar POA \n';
        }
        
        if(cbo_empleado==''){
            mensaje+='* Debe seleccionar un empleado \n';
        }
        
        if(mensaje!=''){
            alert(mensaje);
            return false;
        } else{
            agregarEmpleadoObra(txt_poa,cbo_empleado);
        }
        
        $("#div_button_add_empleado").show();
	$("#div_empleados").hide("slow");
}

function cancel_add_empleado(){
	$("#div_button_add_empleado").show();
	$("#div_empleados").hide("slow");      
}

function ver_materiales(){
	$("#div_button_add_material").hide("slow");
	$("#div_materiales").show();
}

function ok_add_material(){
	$("#div_button_add_material").show();
	$("#div_materiales").hide("slow");
}

function cancel_add_material(){
	$("#div_button_add_material").show();
	$("#div_materiales").hide("slow");
}

function guardar_registro_avance(accion){
	$('#myModal').modal('hide');
	if(accion==''){
		goPage(4002); //en ejecucion	
	}
}

function agregarEmpleadoObra(poa,legajo_empleado){
    var parametros={ 
        accion: 'AE',
        poa_alta:poa, 
        legajo_empleado:legajo_empleado,   
    };
    $.ajax({
      type: 'POST',
      url: 'manager.obra',
      data: parametros,
      success: function(response){
           Notifier.success('\n ' + (parametros.accion=="A"? 'Alta': 'Modificacion') + ' de la obra efectuada con exitoso ');
   				 finalizar_cambios();	
      },
      error: function(response){
            Notifier.error(response.statusText);	
      }
    });
    
}