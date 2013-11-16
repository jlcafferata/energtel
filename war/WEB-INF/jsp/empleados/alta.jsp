<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<%@page import="org.isft.logic.collection.CollectionEmpleado, org.isft.domain.Empleado, org.isft.domain.helper.FechaHora"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script type="text/javascript" src="/ENERGTEL/static/js/jquery.ui.datepicker-es.js"></script>
<script type="text/javascript" src="/ENERGTEL/static/js/empleados/alta.js"></script>

<% 
String accion=request.getParameter("accion");
String legajo=request.getParameter("legajo");
if(accion==null){
	accion="";
}
if(legajo==null){
	legajo="";
}
int ultimoLegajo=1;
CollectionEmpleado collection = new CollectionEmpleado();
Empleado empleado=new Empleado();
boolean deshabilitado=false;
if(accion.equals("A")){
    ultimoLegajo=collection.getUltimoLegajo();
} else if(accion.equals("M")){
	deshabilitado=true;
	empleado=collection.getEmpleado(legajo); 	
	ultimoLegajo=Integer.parseInt(empleado.getLegajo());
} 
%>

<title>Abm empleado</title>
</head>

<body>
<input type="hidden" id="accion" name="accion" value="<%=accion%>"/>
<div class="row">
	<div class="span12">
		<fieldset>
		<legend>Datos personales</legend>
		<div class="row">
			<div class="span2" style="text-align:right">Nro de legajo</div>
			<div class="span2"><%if(deshabilitado){%> <%=ultimoLegajo%> <input type="hidden" name="txt_legajo_alta" id="txt_legajo_alta" value="<%=ultimoLegajo%>"/><%} else {%><input style="width:50px"  name="txt_legajo_alta" id="txt_legajo_alta" type="text" value="<%=ultimoLegajo%>" /><%}%></div>
			<div class="span2" style="text-align:right">Apellido</div>
			<div class="span2"><input style="width:180px"   name="txt_apellido_alta" id="txt_apellido_alta" type="text" value="<%=empleado.getApellido()%>"/></div>
			<div class="span2" style="text-align:right">Nombre</div>
			<div class="span2"><input style="width:180px" name="txt_nombre_alta" id="txt_nombre_alta" type="text" value="<%=empleado.getNombre()%>"/></div>
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Estudios</div>
			<div class="span2"><tag:ComboEstudio nombreCombo="cbo_estudio" selecto="<%=empleado.getCod_estudio()%>" obligatorio="S"/></div>
			<div class="span2" style="text-align:right">Fecha alta</div>
			<div class="span2"><input style="width:80px"  name="txt_fecha_alta_alta" id="txt_fecha_alta_alta" type="text" value="<%=FechaHora.getFechaView(empleado.getFecha_alta())%>"/></div>
			<div class="span2" style="text-align:right">Fecha baja</div>
			<div class="span2"><input style="width:80px" name="txt_fecha_baja_alta" id="txt_fecha_baja_alta" type="text" value="<%=FechaHora.getFechaView(empleado.getFecha_baja())%>"/></div>
		
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Documento</div>
			<div class="span2"><select id="cbo_tipo_documento" style="width:60px"><option <%if(empleado.getTipo_documento().equals("DNI")){%>selected<%}%> value="DNI">DNI</option><option <%if(empleado.getTipo_documento().equals("LC")){%>selected<%}%> value="LC">LC</option><option <%if(empleado.getTipo_documento().equals("LE")){%>selected<%}%> value="LE">LE</option><option <%if(empleado.getTipo_documento().equals("CI")){%>selected<%}%> value="CI">CI</option></select>&nbsp;<input style="width:100px" name="txt_dni_alta" id="txt_dni_alta" type="text" value="<%=empleado.getNumero_documento()%>" maxlength="8"/></div>
			<div class="span2" style="text-align:right">Cuil</div>
                        <div class="span2"><input style="width:150px" name="txt_cuil_alta" id="txt_cuil_alta" type="text" value="<%=empleado.getCuil()%>" maxlength="13" onkeyup="caracter_cuil()"/></div>
			<div class="span2" style="text-align:right">Nacionalidad</div>
			<div class="span2"><input style="width:150px" name="txt_nacionalidad_alta" id="txt_nacionalidad_alta" type="text" value="<%=empleado.getNacionalidad()%>"/></div>
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Fecha Nacimiento</div>
			<div class="span2"><input style="width:80px" name="txt_fecha_nac_alta" id="txt_fecha_nac_alta" type="text" value="<%=FechaHora.getFechaView(empleado.getFecha_nacimiento())%>"/></div>
			<div class="span2" style="text-align:right">Estado Civil</div>
			<div class="span2"><tag:ComboEstadoCivil nombreCombo="cbo_estado_civil" obligatorio="S" selecto="<%=empleado.getCod_estado_civil()%>"/></div>
			<div class="span2" style="text-align:right">Hijos</div>
			<div class="span2"><input style="width:50px" name="txt_hijos_alta" id="txt_hijos_alta" type="text" value="<%=empleado.getCantidad_hijos()%>"/></div>
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Categor&iacute;a</div>
			<div class="span2"><tag:ComboCategoria nombreCombo="cbo_categoria" obligatorio="S" selecto="<%=empleado.getCod_categoria()%>"/></div>
			<div class="span2" style="text-align:right">Situaci&oacute;n</div>
			<div class="span2"><tag:ComboSituacionEmpleado nombreCombo="cbo_situacion_empleado" obligatorio="S" selecto="<%=empleado.getCod_situacion()%>"/></div>
			<div class="span2" style="text-align:right">Telefono</div>
			<div class="span2"><input style="width:150px" name="txt_telefono_alta" id="txt_telefono_alta" type="text" value="<%=empleado.getTelefono()%>"/></div>
			
		</div>
		<div class="row">
			<div class="span2" style="text-align:right">Celular</div>
			<div class="span2"><input style="width:150px" name="txt_celular_alta" id="txt_celular_alta" type="text" value="<%=empleado.getCelular()%>"/></div>
			<div class="span2" style="text-align:right">E-mail</div>
			<div class="span2"><input style="width:200px" name="txt_email_alta" id="txt_email_alta" type="text" value="<%=empleado.getE_mail()%>"/></div>
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
				<div class="span2"><input name="txt_calle_legal_alta" id="txt_calle_legal_alta" type="text" value="<%=empleado.getDomicilio_legal()%>"/></div>
				<div class="span1" style="text-align:right">Nro</div>
				<div class="span2"><input style="width:50px" name="txt_nro_legal_alta" id="txt_nro_legal_alta" type="text" value="<%=empleado.getNro_legal()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Provincia</div>
				<div class="span2"><tag:ComboProvincia nombreCombo="cbo_provincia_legal" obligatorio="S" selecto="<%=empleado.getProvincia_legal()%>"/></div>
				<div class="span1" style="text-align:right">Partido</div>
				<div class="span2"><tag:ComboPartido nombreCombo="cbo_partido_legal" obligatorio="S" selecto="<%=empleado.getPartido_legal()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Localidad</div>
				<div class="span2"><tag:ComboLocalidad nombreCombo="cbo_localidad_legal" obligatorio="S" selecto="<%=empleado.getLocalidad_legal()%>" codigo_partido="<%=empleado.getPartido_legal()%>"/></div>
				<div class="span1" style="text-align:right">Codigo Postal</div>
				<div class="span2"><input style="width:50px" name="txt_cp_legal_alta" id="txt_cp_legal_alta" type="text" value="<%=empleado.getCp_legal()%>"/></div>
			</div>
		</fieldset>
	</div>
	<div class="span6">
		<fieldset>
			<legend>Domicilio real</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Calle</div>
				<div class="span2"><input name="txt_calle_real_alta" id="txt_calle_real_alta" type="text" value="<%=empleado.getDomicilio_real()%>"/></div>
				<div class="span1" style="text-align:right">Nro</div>
				<div class="span2"><input style="width:50px" name="txt_nro_real_alta" id="txt_nro_real_alta" type="text" value="<%=empleado.getNro_real()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Provincia</div>
				<div class="span2"><tag:ComboProvincia nombreCombo="cbo_provincia_real" obligatorio="S" selecto="<%=empleado.getProvincia_real()%>"/></div>
				<div class="span1" style="text-align:right">Partido</div>
				<div class="span2"><tag:ComboPartido nombreCombo="cbo_partido_real" obligatorio="S" selecto="<%=empleado.getPartido_real()%>"/></div>
			</div>
			<div class="row">
				<div class="span1" style="text-align:right">Localidad</div>
				<div class="span2"><tag:ComboLocalidad nombreCombo="cbo_localidad_real" obligatorio="S" selecto="<%=empleado.getLocalidad_real()%>" codigo_partido="<%=empleado.getPartido_real()%>"/></div>
				<div class="span1" style="text-align:right">Codigo Postal</div>
				<div class="span2"><input style="width:50px" name="txt_cp_real_alta" id="txt_cp_real_alta" type="text" value="<%=empleado.getCp_real()%>"/></div>
			</div>
		</fieldset>
	</div>
</div>
<div class="span6">
	<fieldset>
			<legend>Talles</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Pantal&oacute;n</div>
				<div class="span1"><input style="width:50px" name="txt_pantalon_alta" id="txt_pantalon_alta" type="text" value="<%=empleado.getTalle_pantalon()%>"/></div>
				<div class="span1" style="text-align:right">Camisa</div>
				<div class="span1"><input style="width:50px" name="txt_camisa_alta" id="txt_camisa_alta" type="text" value="<%=empleado.getTalle_camisa()%>"/></div>
				<div class="span1" style="text-align:right">Calzado</div>
				<div class="span1"><input style="width:50px" name="txt_calzado_alta" id="txt_calzado_alta" type="text" value="<%=empleado.getCalzado()%>"/></div>
			</div>
		</fieldset>
</div>
<div class="span5">
	<fieldset>
			<legend>Cese laboral</legend>
			<div class="row">
				<div class="span1" style="text-align:right">Nro libreta</div>
				<div class="span1"><input style="width:100px" name="txt_libreta_alta" id="txt_libreta_alta" type="text" value="<%=empleado.getNro_libreta_cese()%>"/></div>
				<div class="span1" style="text-align:right">Nro Cta</div>
				<div class="span2"><input style="width:150px" name="txt_cta_cese_alta" id="txt_cta_cese_alta" type="text" value="<%=empleado.getNro_cta_cese_laboral()%>"/></div>
			</div>
		</fieldset>
</div>
<div class="row" align="center">
	<div class="span12">
		<p><input type="button" class="btn btn-primary" id="btn_aceptar_alta" value="Aceptar" onclick="javascript:confirmar_accion(document.getElementById('accion').value)"></p>
	</div>
</div>
</body>
</html>
<script>
	$(document).ready(function(){
		onload_alta();
	});
</script>
