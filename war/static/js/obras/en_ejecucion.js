function onload(){
	ng.ready( function() {
	  var cal_fecha_desde = new ng.Calendar({
   	 	input: 'txt_fecha_desde', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	  var cal_fecha_hasta = new ng.Calendar({
   	 	input: 'txt_fecha_hasta', // the input field id
		start_date: 'last year', // the start date (default is today)
		end_date: 'year +1', // the end date (related to start_date, 4 years from today)
		display_date: new Date() // the display date (default is start_date)
		});
	});	
}

function filtrar(){
	var tipo_obra=$("#cbo_tipo_obra").val();
	var poa=$("#txt_poa").val();
	var txt_fecha_desde=$("#txt_fecha_desde").val();
	var txt_fecha_hasta=$("#txt_fecha_hasta").val();
	var path='4002';
	if(tipo_obra && tipo_obra!=''){
		path+='&cbo_tipo_obra='+tipo_obra;
	}
	if(poa && poa!=''){
		path+='&txt_poa='+poa;
	}
	if(txt_fecha_desde && txt_fecha_desde!=''){
		path+='&txt_fecha_desde='+fecha_to_db(txt_fecha_desde);
	}
	if(txt_fecha_hasta && txt_fecha_hasta!=''){
		path+='&txt_fecha_hasta='+fecha_to_db(txt_fecha_hasta);
	}
	goPage(path);
}

