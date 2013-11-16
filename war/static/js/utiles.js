function caracter_cuil(){
    var cuil=$("#txt_cuil_alta").val();
    if(cuil.length===2 || cuil.length===11){
        document.getElementById('txt_cuil_alta').value=cuil+'-';
    }
}


function fecha_formateada(fecha){
      var dia_alta='', mes_alta='', anio_alta=fecha.substring(0,4);
      if(fecha.length==8){
          mes_alta='0'+fecha.substring(5,6);
          dia_alta='0'+fecha.substring(7,8);
      } else if(fecha.length==9){
          guion_mes_corto_alta=fecha.substring(6,7);
          if(guion_mes_corto_alta=='-'){
              mes_alta='0'+fecha.substring(5,6);
              dia_alta=fecha.substring(7,9);
          } else{
              mes_alta=fecha.substring(5,7);
              dia_alta='0'+fecha.substring(8,9);
          }   
      } else{
          mes_alta=fecha.substring(5,7);
          dia_alta=fecha.substring(8,10);
      }
      fecha=anio_alta+mes_alta+dia_alta;
			return fecha;
}
