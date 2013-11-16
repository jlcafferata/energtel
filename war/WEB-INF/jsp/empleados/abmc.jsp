<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script type="text/javascript" src="/ENERGTEL/static/js/empleados/empleados.js"></script>

<title>ABMC empleados</title>
</head>

<body>
<fieldset>
<legend>Administrar empleados</legend>
<div id="div_cabecera">
	<div class="row">
		<div class="span2" style="text-align:right">N&deg; de legajo</div>
		<div class="span1"><input type="text" name="txt_legajo" id="txt_legajo"  style="width:80px" maxlength="9"/></div>
		<div class="span1" style="text-align:right">Apellido</div>
		<div class="span2"><input name="txt_apellido" id="txt_apellido" type="text" /></div>
		<div class="span2" style="text-align:right">Nombre</div>
		<div class="span2"><input name="txt_nombre" id="txt_nombre" type="text" /></div>
		<div class="span1" style="text-align:right">D.N.I</div>
		<div class="span1"><input name="txt_dni" id="txt_dni" style="width:100px" type="text" maxlength="8"/></div>
	</div>
	<div class="row">
		<table align="center" width="99%">
			<tr>
				<td style="background-color:#DFF0D8">
					<div class="span5">
						<fieldset>
							<legend style="font-size:14px"> Fecha Alta</legend>
								<div style="text-align:left; font-size:12px">
								Entre 
								<input name="txt_fecha_alta_desde" id="txt_fecha_alta_desde" type="text" style="width:80px" />
								&nbsp; y &nbsp; <input name="txt_fecha_alta_hasta" id="txt_fecha_alta_hasta" type="text" style="width:80px" /></div>
						</fieldset>
					</div>				</td>
				<td style="background-color:#F2DEDE">
					<div class="span5" >
						<fieldset>
							<legend style="font-size:14px"> Fecha Baja</legend>
								<div style="text-align:left; font-size:12px">
								Entre
								<input name="txt_fecha_baja_desde" id="txt_fecha_baja_desde" type="text" style="width:80px" />
								&nbsp; y &nbsp; <input name="txt_fecha_baja_hasta" id="txt_fecha_baja_hasta" type="text" style="width:80px" /></div>
						</fieldset>
					</div>				</td>
				<td style="background-color:#FCF8E3">
					<div align="center" class="span2">
					  <input name="checkbox" type="checkbox" id="chk_empleados_standby" onclick="filtrar()"/>
					  <font size="2">Incluir lista espera</font><br/>
					  <input type="button" value="Filtrar" name="btn_filtrar" class="btn  btn-primary" onclick="javascript:filtrar()">
					  &nbsp;
					  <input type="button" onclick="javascript:alta()" value="Nuevo" name="btn_nuevo" class="btn  btn-primary">
				  </div></td>
			</tr>
		</table>
	</div>
</div><br />
<div class="row">
	<div class="span12" id="div_grilla_empleado">
	</div>
</div>
</fieldset>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:100%; left:0px; margin-left:0px; height:580px; top:10px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
	</div>
	<div class="modal-body" style="max-height: 580px">
	</div>
</div>

</body>
</html>
<script>
	$(document).ready(function(){
		onload();
	});
</script>
