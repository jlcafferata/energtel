function filtrar(){
	var zona=$("#cbo_zona_obra").val();
	var tipo_obra=$("#cbo_tipo_obra").val();
	var poa=$("#txt_poa").val();
	var path='4001';
	if(zona && zona!=''){
		path+='&cbo_zona_obra='+zona;
	}
	if(tipo_obra && tipo_obra!=''){
		path+='&cbo_tipo_obra='+tipo_obra;
	}
	if(poa && poa!=''){
		path+='&txt_poa='+poa;
	}
	goPage(path);
}
function alta(){
	$('.modal-body').load("jsp/obras/seguimiento.jsp?accion=alta&modalidad=A");
	$('#myModal').modal('show');
}

function certificar(poa){
	$('.modal-body').load("jsp/obras/seguimiento.jsp?accion=certificar&poa="+poa+"&modalidad=A");
	$('#myModal').modal('show');
}

function finalizar_cambios(){
	$('#myModal').modal('hide');
	filtrar();
}

function facturar(poa){
	$('.modal-body').load("jsp/obras/seguimiento.jsp?accion=facturar&modalidad=A");
	$('#myModal').modal('show');
}

function cobrar(poa){
	$('.modal-body').load("jsp/obras/seguimiento.jsp?accion=cobrar&modalidad=A");
	$('#myModal').modal('show');
}



function pasar_a_en_ejecucion(poa){
	if(confirm('Desea pasar a EN EJECUCION la POA ' + poa + '?')){
		guardar('iniciar');
	}
}

function pasar_a_certificada(poa){
	if(confirm('Desea pasar a CERTIFICADA la POA ' + poa + '?')){
		guardar('certificar');
	}
}

function pasar_a_facturada(poa){
	if(confirm('Desea pasar a FACTURADA la POA ' + poa + '?')){
		guardar('volver_a_facturada');
	}
}

function registro_avance(poa){
	$('.modal-body').load("jsp/obras/registro_avance.jsp?poa="+poa);
	$('#myModal').modal('show');
}

function guardar(accion){
	$('#myModal').modal('hide');
	if(accion=='iniciar'){
		goPage(4002);
	} else if(accion=='certificar'){
		goPage(4003);
	} else if(accion=='facturar' || accion=='cobrar'){
		goPage(4005);
	} else if(accion=='volver_a_facturada'){
		goPage(4004);
	} else{
		goPage(4001);
	}
}

function iniciar_ejecucion(poa){
	$('.modal-body').load("jsp/obras/registro_avance.jsp?poa="+poa+"&accion=M");
	$('#myModal').modal('show');
}

function modi(poa){
	$('.modal-body').load("jsp/obras/seguimiento.jsp?accion=alta&poa="+poa+"&modalidad=M");
	$('#myModal').modal('show');
}

function anticipo_obra(poa){
	alert('Anticipo de obra poa:' + poa);
}