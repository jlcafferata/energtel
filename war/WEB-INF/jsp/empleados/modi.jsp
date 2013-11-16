<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<%@page import="org.isft.logic.collection.CollectionEmpleado, org.isft.domain.Empleado"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script type="text/javascript" src="/ENERGTEL/static/js/jquery.ui.datepicker-es.js"></script>

<% 
String accion=request.getParameter("accion");
String legajo=request.getParameter("legajo");
if(accion==null){
	accion="";
}
if(legajo==null){
	legajo="";
}
System.out.println("legajo:"+ legajo);
int ultimoLegajo=1;
CollectionEmpleado collection = new CollectionEmpleado();
Empleado empleado=new Empleado();
if(accion.equals("A")){
    ultimoLegajo=collection.getUltimoLegajo();
} else if(accion.equals("M")){
	empleado=collection.getEmpleado(legajo);
	ultimoLegajo=Integer.parseInt(empleado.getLegajo()); 	
} 
%>

<title>Abm empleado</title>
</head>

<body>
<div class="row">
	<div class="span12">
		<fieldset>
		<legend>Datos personales</legend>
		<div class="row">
			<div class="span2" style="text-align:right">Nro de legajo</div>
			<div class="span2"><input style="width:50px"  name="txt_legajo_modi" id="txt_legajo_modi" type="text" value="<%=ultimoLegajo%>"/></div>
			<div class="span2" style="text-align:right">Apellido</div>
			<div class="span2"><input style="width:180px"   name="txt_apellido_modi" id="txt_apellido_modi" type="text" value="<%=empleado.getApellido()%>"/></div>
			<div class="span2" style="text-align:right">Nombre</div>
			<div class="span2"><input style="width:180px" name="txt_nombre_modi" id="txt_nombre_modi" type="text" value="<%=empleado.getNombre()%>"/></div>
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Estudios</div>
			<div class="span2"><tag:ComboEstudio nombreCombo="cbo_estudio" codigo="<%=empleado.getCod_estudio()%>"/></div>
			<div class="span2" style="text-align:right">Fecha alta</div>
			<div class="span2"><input style="width:100px" name="txt_fecha_alta_modi" id="txt_fecha_alta_modi" type="text" value="<%=empleado.getFecha_alta()%>"/></div>
			<div class="span2" style="text-align:right">Fecha baja</div>
			<div class="span2"><input style="width:100px" name="txt_fecha_baja_modi" id="txt_fecha_baja_modi" type="text" value="<%=empleado.getFecha_baja()%>"/></div>
		
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Dni</div>
			<div class="span2"><input style="width:100px" name="txt_dni_modi" id="txt_dni_modi" type="text" value="<%=empleado.getNumero_documento()%>"/></div>
			<div class="span2" style="text-align:right">Cuil</div>
			<div class="span2"><input style="width:150px" name="txt_cuil_modi" id="txt_cuil" type="text" value="<%=empleado.getCuil()%>"/></div>
			<div class="span2" style="text-align:right">Nacionalidad</div>
			<div class="span2"><input style="width:150px" name="txt_nacionalidad_modi" id="txt_nacionalidad_modi" type="text" value="<%=empleado.getNacionalidad()%>"/></div>
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Fecha Nacimiento</div>
			<div class="span2"><input style="width:100px" name="txt_fecha_nac_modi" id="txt_fecha_nac_modi" type="text" value="<%=empleado.getFecha_nacimiento()%>"/></div>
			<div class="span2" style="text-align:right">Estado Civil</div>
			<div class="span2"><tag:ComboEstadoCivil nombreCombo="cbo_estado_civil" codigo="<%=empleado.getCod_estado_civil()%>"/></div>
			<div class="span2" style="text-align:right">Hijos</div>
			<div class="span2"><input style="width:50px" name="txt_hijos_modi" id="txt_hijos_modi" type="text" value="<%=empleado.getCantidad_hijos()%>"/></div>
		</div>
		</fieldset>
	</div>
</div>
<div class="row">
	<div class="span6">
		<fieldset>
			<legend>Domicilio legal</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Calle</div>
				<div class="span2"><input name="txt_calle_legal_modi" id="txt_calle_legal_modi" type="text" value="<%=empleado.getDomicilio_legal()%>"/></div>
				<div class="span1" style="text-align:right">Nro</div>
				<div class="span2"><input style="width:50px" name="txt_nro_legal_modi" id="txt_nro_legal_modi" type="text" value="<%=empleado.getNro_legal()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Provincia</div>
				<div class="span2"><select style="width:150px" id="cmb_provincia_legal"><option value="01">Buenos Aires</option><option value="02">Tucuman</option></select></div>
				<div class="span1" style="text-align:right">Partido</div>
				<div class="span2"><select style="width:150px" id="cmb_partido_legal"><option value="01">Moreno</option><option value="02">Merlo</option></select></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Localidad</div>
				<div class="span2"><select id="cmb_localidad_legal"><option value="01">Paso del rey</option><option value="02">Rodriguez</option></select></div>
				<div class="span1" style="text-align:right">Codigo Postal</div>
				<div class="span2"><input style="width:50px" name="txt_cp_legal_modi" id="txt_cp_legal_modi" type="text" value="<%=empleado.getCp_legal()%>"/></div>
			</div>
		</fieldset>
	</div>
	<div class="span6">
		<fieldset>
			<legend>Domicilio real</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Calle</div>
				<div class="span2"><input name="txt_calle_real_modi" id="txt_calle_real_modi" type="text" value="<%=empleado.getDomicilio_real()%>"/></div>
				<div class="span1" style="text-align:right">Nro</div>
				<div class="span2"><input style="width:50px" name="txt_nro_real_modi" id="txt_nro_real_modi" type="text" value="<%=empleado.getNro_real()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Provincia</div>
				<div class="span2"><select style="width:150px" id="cmb_provincia_real"><option value="01">Buenos Aires</option><option value="02">Tucuman</option></select></div>
				<div class="span1" style="text-align:right">Partido</div>
				<div class="span2"><select style="width:150px" id="cmb_partido_real"><option value="01">Moreno</option><option value="02">Merlo</option></select></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Localidad</div>
				<div class="span2"><select id="cmb_localidad_real"><option value="01">Paso del rey</option><option value="02">Rodriguez</option></select></div>
				<div class="span1" style="text-align:right">Codigo Postal</div>
				<div class="span2"><input style="width:50px" name="txt_cp_real_modi" id="txt_cp_real_modi" type="text" value="<%=empleado.getCp_real()%>"/></div>
			</div>
		</fieldset>
	</div>
</div>
<div class="span6">
	<fieldset>
			<legend>Talles</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Pantal&oacute;n</div>
				<div class="span1"><input style="width:50px" name="txt_pantalon_modi" id="txt_pantalon_modi" type="text" value="<%=empleado.getTalle_pantalon()%>"/></div>
				<div class="span1" style="text-align:right">Camisa</div>
				<div class="span1"><input style="width:50px" name="txt_camisa_modi" id="txt_camisa_modi" type="text" value="<%=empleado.getTalle_camisa()%>"/></div>
				<div class="span1" style="text-align:right">Calzado</div>
				<div class="span1"><input style="width:50px" name="txt_calzado_modi" id="txt_calzado_modi" type="text" value="<%=empleado.getCalzado()%>"/></div>
			</div>
		</fieldset>
</div>
<div class="span5">
	<fieldset>
			<legend>Cese laboral</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Nro libreta</div>
				<div class="span1"><input style="width:100px" name="txt_libreta_modi" id="txt_libreta_modi" type="text" value="<%=empleado.getNro_libreta_cese()%>"/></div>
				<div class="span1" style="text-align:right">Nro Cta</div>
				<div class="span2"><input style="width:150px" name="txt_cta_cese_modi" id="txt_cta_cese_modi" type="text" value="<%=empleado.getNro_cta_cese_laboral()%>"/></div>
			</div>
		</fieldset>
</div>
<div class="row" align="center">
	<div class="span12">
		<p><input type="button" class="btn btn-primary" id="btn_aceptar_modi" value="Aceptar"></p>
	</div>
</div>
</body>
</html>
