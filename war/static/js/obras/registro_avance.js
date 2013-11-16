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
        var empleado_seleccionado=$('#cbo_empleado :selected').text().split(',');
        var nombre=empleado_seleccionado[1];
        var apellido=empleado_seleccionado[0];
        var legajo='leg_'+cbo_empleado;
            
        if(txt_poa==''){
            mensaje+='* Debe ingresar POA \n';
        }
        
        if(cbo_empleado==''){
            mensaje+='* Debe seleccionar un empleado \n';
        }
        
        if(estaEmpleadoAgregado(apellido)){
            // ESTE NO FUNCIONA
            mensaje+='* El empleado ya esta en la lista \n';
        }
        
        if(mensaje!=''){
            alert(mensaje);
            return false;
        } else{
            $('#tabla_empleado > tbody:last').append("<tr id='"+legajo+"'><td>"+apellido+"</td><td>"+nombre+"</td><td><a href=\"javascript:\" onclick=\"quitarEmpleado("+legajo+");\">Quitar</a></td></tr>");
        }
        
        $("#div_button_add_empleado").show();
	$("#div_empleados").hide("slow");
}

function estaEmpleadoAgregado(apellido){
     var esta_agregado=false;
     $("#tabla_empleado tbody tr").each(function () {
                     if(apellido == $(this).children("td").eq(0).text()){
                         esta_agregado=true;
                     }  
     })
     return esta_agregado;
}


function quitarEmpleado(leg){
    $(leg).remove();
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
        var mensaje='';
        var cbo_materiales=$("#cbo_materiales").val();
        var value_cbo_materiales=$('#cbo_materiales').val().split('-');
        var stock=value_cbo_materiales[1];
        var cod_material='mat_cod_'+value_cbo_materiales[0];
        var mat_nombre=$('#cbo_materiales :selected').text();
            
        if(cbo_materiales==''){
            mensaje+='* Debe seleccionar un material \n';
        }
        
        if(estaMaterialAgregado(mat_nombre)){
            // ESTE NO FUNCIONA
            mensaje+='* El material ya esta en la lista \n';
        }
        
        if(mensaje!=''){
            alert(mensaje);
            return false;
        } else{
            $('#tabla_material > tbody:last').append("<tr id='"+cod_material+"'><td>"+mat_nombre+"</td><td><input name='txt_"+mat_nombre+"' id='txt_"+mat_nombre+"' style='width:70px' type='text'></td><td>"+stock+"</td><td><a href=\"javascript:\" onclick=\"quitarMaterial("+cod_material+");\">Quitar</a></td></tr>");
        }
	$("#div_button_add_material").show();
	$("#div_materiales").hide("slow");
}

function estaMaterialAgregado(mat_nombre){
     var esta_agregado=false;
     $("#tabla_material tbody tr").each(function () {
                     //alert(mat_nombre+"=="+$(this).children("td").eq(0).text());
                     if(mat_nombre == $(this).children("td").eq(0).text()){
                         esta_agregado=true;
                     }  
     })
     return esta_agregado;
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

/*function agregarEmpleadoObra(poa,legajo_empleado){
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
    
}*/