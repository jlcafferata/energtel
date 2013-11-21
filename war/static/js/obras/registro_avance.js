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
        
        $("#buscar_avance").hide();
        if($("#accion").val()=='M'){
            $("#boton_avaces_previos").hide();
        }else{
            $("#boton_avaces_previos").show();
        }
        if($("#accion").val()=='MAO'){
            var fc=$("#fecha_certificada").val();
            var hc=$("#hora_cargada").val();
            var poa=$("#txt_poa_ejecucion").val();
            llenarTablas(fc,hc,poa);
            $("#boton_guardar").hide();
            $("#div_button_add_tarea").hide();
            $("#div_button_add_material").hide();
            $("#div_button_add_empleado").hide();
        }

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
        
        if(estaEmpleadoAgregado(legajo)){
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

function estaEmpleadoAgregado(legajo){
     var esta_agregado=false;
     $("#tabla_empleado tbody tr").each(function () {   
                     if(legajo == $(this).attr('id')){
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

function cancel_add_tarea(){
	$("#div_button_add_tarea").show();
	$("#div_tarea").hide("slow");      
}

function ver_tarea(){
	$("#div_button_add_tarea").hide("slow");
	$("#div_tarea").show();
}

function ok_add_tarea(){
    var mensaje='';
        var cod_tarea=$("#cbo_tarea").val();
        var tarea_nombre=$('#cbo_tarea :selected').text();
        var tarea_descripcion=$('#cbo_tarea :selected').attr('name');
        
        if(tarea_nombre==''){
            mensaje+='* Debe seleccionar una tarea \n';
        }
        
        if(estaTareaAgregada(tarea_nombre)){
            mensaje+='* El material ya esta en la lista \n';
        }
        
        if(mensaje!=''){
            alert(mensaje);
            return false;
        } else{
            $('#tabla_tareas > tbody:last').append("<tr id='tarea_"+cod_tarea+"'><td>"+tarea_nombre+"</td><td><input name='txt_"+tarea_nombre+"' id='txt_"+tarea_nombre+"' style='width:70px' type='text'></td><td><a href=\"javascript:\" onclick=\"quitarTarea(tarea_"+cod_tarea+");\">Quitar</a></td></tr>");
        }
	$("#div_button_add_tarea").show();
	$("#div_tarea").hide("slow");
}

function quitarTarea(cod_tarea){
    $(cod_tarea).remove();
}

function estaTareaAgregada(tarea){
    var esta_agregado=false;
     $("#tabla_tareas tbody tr").each(function () {
                     if(tarea == $(this).children("td").eq(0).text()){
                         esta_agregado=true;
                     }  
     });
     return esta_agregado;
}

function ok_add_material(){
        var mensaje='';
        var cbo_materiales=$("#cbo_materiales").val();
        var value_cbo_materiales=$('#cbo_materiales').val().split('-');
        var stock_propio=value_cbo_materiales[1];
        var stock_provisto=value_cbo_materiales[2];
        var cod_material='mat_cod_'+value_cbo_materiales[0];
        var mat_nombre=$('#cbo_materiales :selected').text();
            
        if(cbo_materiales==''){
            mensaje+='* Debe seleccionar un material \n';
        }
        
        if(estaMaterialAgregado(mat_nombre)){
            mensaje+='* El material ya esta en la lista \n';
        }
        
        if(mensaje!=''){
            alert(mensaje);
            return false;
        } else{
            $('#tabla_material > tbody:last').append("<tr id='"+cod_material+"'><td>"+mat_nombre+"</td><td><input name='txt1_"+cod_material+"' id='txtpropio_"+cod_material+"' style='width:70px' type='text'><td>"+stock_propio+"</td></td><td><input name='txtprovisto_"+cod_material+"' id='txtprovisto_"+cod_material+"' style='width:70px' type='text'><td>"+stock_provisto+"</td></td><td><a href=\"javascript:\" onclick=\"quitarMaterial("+cod_material+");\">Quitar</a></td></tr>");
        }
	$("#div_button_add_material").show();
	$("#div_materiales").hide("slow");
}

function estaMaterialAgregado(mat_nombre){
     var esta_agregado=false;
     $("#tabla_material tbody tr").each(function () {
                     if(mat_nombre == $(this).children("td").eq(0).text()){
                         esta_agregado=true;
                     }  
     });
     return esta_agregado;
}

function quitarMaterial(leg){
    $(leg).remove();
}

function cancel_add_material(){
	$("#div_button_add_material").show();
	$("#div_materiales").hide("slow");
}

function guardar_registro_avance(accion){
        
        if(validar_datos()){
            var empleados ='';
            var materiales='';
            var tareas='';
            $("#tabla_empleado tbody tr").each(function () {
                         if(empleados!=''){
                             empleados+='@';
                         }
                         var legajo=$(this).attr('id').split('_');
                         empleados+=legajo[1];
            });
            $("#tabla_material tbody tr").each(function () {
                         if(materiales!=''){
                             materiales+='@';
                         }
                         // TOMA LOS VALORES DE STOCK PROPIO
                         var aux_stock_propio="txtpropio_"+$(this).attr('id');
                         var cant_stock_propio_usado=$("#"+aux_stock_propio).val();
                         var stock_propio=$(this).children("td").eq(2).text();
                         if(stock_propio=='' || stock_propio=='undefined'){stock_propio="0";}
                         if(cant_stock_propio_usado=='' || cant_stock_propio_usado=='undefined'){cant_stock_propio_usado="0";}
                         // TOMA LOS VALORES DE STOCK PROVISTO
                         var aux_stock_provisto="txtprovisto_"+$(this).attr('id');
                         var cant_stock_provisto_usado=$("#"+aux_stock_provisto).val();
                         var stock_provisto=$(this).children("td").eq(4).text();
                         if(stock_provisto=='' || stock_provisto=='undefined'){stock_provisto="0";}
                         if(cant_stock_provisto_usado=='' || cant_stock_provisto_usado=='undefined'){cant_stock_provisto_usado="0";}
                         //CAPTURA LA ID DEL MATERIAL
                         var id=$(this).attr('id').split('_');
                         // GENERA EL STRING DE UN MATERIAL
                         materiales+=id[2]+"-"+cant_stock_propio_usado+"-"+stock_propio+"-"+cant_stock_provisto_usado+"-"+stock_provisto;
            });      
            $("#tabla_tareas tbody tr").each(function () {
                         if(tareas!=''){
                             tareas+='@';
                         }
                         // TOMA LOS VALORES DE STOCK PROPIO
                         var aux_tarea="txt_"+$(this).children("td").eq(0).text();
                         var cant_tarea_realizada=$("#"+aux_tarea).val();
                         if(cant_tarea_realizada=='' || cant_tarea_realizada=='undefined'){cant_tarea_realizada="0";}
                         var id_tarea=$(this).attr('id').split('_');
                         tareas+=id_tarea[1]+"-"+cant_tarea_realizada;
            }); 
            
            var parametros={
                accion: 'IE',
                poa_alta:                       $("#txt_poa_ejecucion").val(),   
                tipo_obra_alta:                 $("#cbo_tipo_obra_aejecucion").val(), 
                zona_obra_alta:                 $("#cbo_zona_obra_aejecucion").val(), 
                fecha_certificacion_avance:     $("#txt_fecha_certificacion").val(), 
                empleados:                      empleados,
                materiales:                     materiales,
                tareas:                         tareas,
                txt_pendiente:                  $("#txt_pendiente").val(),
                txt_observacion:                $("#txt_observacion").val(),
                estado:				"eje",
            };
            console.log(parametros);
            pasarEjecucion(parametros);            
            $('#myModal').modal('hide');
                
        }
}

function validar_datos(){
    var mensaje='';
    var txt_poa_ejecucion=$("#txt_poa_ejecucion").val(),          
        cbo_tipo_obra_aejecucion=$("#cbo_tipo_obra_aejecucion").val(),
        cbo_zona_obra_aejecucion=$("#cbo_zona_obra_aejecucion").val(),
        txt_fecha_inicio=$("#txt_fecha_inicio").val(),
        txt_fecha_certificacion=$("#txt_fecha_certificacion").val(),
        txt_pendiente=$("#txt_pendiente").val();
        var empleados = new Array();
        var materiales= new Array();
        var tareas= new Array();
        $("#tabla_empleado tbody tr").each(function () {
                     empleados.push($(this).attr('id'));
        });
        $("#tabla_material tbody tr").each(function () {
                     materiales.push($(this).attr('id'));
        });
        $("#tabla_tareas tbody tr").each(function () {
                     tareas.push($(this).attr('id'));
        });
        
        if(typeof(txt_fecha_inicio)=='undefined'){txt_fecha_inicio='';}
        if(typeof(txt_fecha_certificacion)=='undefined'){txt_fecha_certificacion='';}
        
        // RELACION ENRE TAREAS PENDIENTE Y CERTIFICACION
        if(txt_pendiente!='' && txt_fecha_certificacion==''){
            mensaje+='* Debe elejir una fecha de certificacion \n';
        }
        
        // RELACION ENTRE EMPLEADOS Y TAREAS CON CERTIFICACION
        if(empleados !=''){
            if(txt_fecha_certificacion==''){mensaje+='* Debe elejir una fecha de certificacion \n';}    
        }
        if(tareas!=''){
            if(empleados == ''){mensaje+='* Debe elejir por lo menos un empleado \n';}
            if(txt_fecha_certificacion==''){mensaje+='* Debe elejir una fecha de certificacion \n';}
        }
        if(materiales!=''){
            if(tareas==''){mensaje+='* Debe elejir por lo menos una tarea \n';}
            if(txt_fecha_certificacion==''){mensaje+='* Debe elejir una fecha de certificacion \n';}
            if(empleados== ''){mensaje+='* Debe elejir por lo menos un empleado \n';}
        }
        
        //RELACION ENTRE CERTIFICACION Y PENDIENTE O TAREA
        if(txt_fecha_certificacion!=''){
            if(txt_pendiente=='' && (tareas==''&&materiales==''&& empleados=='')){mensaje+="* Debe elejir algo que certificar \n";}
        }
     
        // ENVIO DE ERRORES      
        if(mensaje!=''){
            alert(mensaje);
            return false;
        }else{
            return true;
        }
}


function pasarEjecucion(parametros){
    console.log(parametros);
    $.ajax({
      type: 'POST',
      url: 'manager.obra',
      data: parametros,
      success: function(response){
           Notifier.success('Informacion guardada con exito');
           goPage(4002);
      },
      error: function(response){
            Notifier.error(response.statusText);	
      } 
    });
}

function irAvancesPrevios(poa){
        $('.modal-body').load("jsp/obras/avances_previos.jsp?poa="+poa);
}

function llenarTablas(fecha_certificada,hora_cargada,poa){
    $("#div_txt_fecha_certificacion").show();
    $("#div_combo_fecha_certificacion").hide();
    $("#txt_fecha_certificacion").val('valor');
}