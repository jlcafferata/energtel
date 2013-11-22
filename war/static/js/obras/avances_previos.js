function onload(){
	ng.ready( function() {
	    var cal_fecha_avances_previos = new ng.Calendar({
   	 	input: 'txt_fecha_avances_previos', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});
	
}

function filtrar(){
    var fecha=$("#txt_fecha_avances_previos").val();
    var poa=$("#txt_poa_avances_previos").val();
    if(typeof(fecha)=='undefined'){txt_fecha_inicio='';}
    //if(fecha!=''){
        $('.modal-body').load("jsp/obras/avances_previos.jsp?poa="+poa+"&fecha="+fecha_to_db(fecha));
    /*}else{
        alert('No hay ningun criterio seleccionado para filtrar');
    }*/
}

function modificarAvancePrevio(fecha_certificada,hora_cargada,tareas_pendientes){
    var poa=$("#txt_poa_avances_previos").val();
    var cod_tipo_obra=$("#cbo_tipo_obra_previo").val();
    var cod_zona=$("#cbo_zona_obra_previo").val();
    var fecha=fecha_to_db(fecha_certificada);
    if(tareas_pendientes=='null'){
        tareas_pendientes="";
    }
        
    $('.modal-body').load("jsp/obras/registro_avance.jsp?poa="+poa+"&fecha_certificada="+fecha+"&hora_cargada="+hora_cargada+"&accion=MAO"+"&cod_tipo_obra="+cod_tipo_obra+"&cod_zona="+cod_zona+"&tareas_pendientes="+tareas_pendientes);
}