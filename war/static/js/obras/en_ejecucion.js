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
