<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script type="text/javascript" src="/ENERGTEL/static/js/obras/registro_avance.js"></script>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<title>Avance de obra</title>
</head>
<%String poa=request.getParameter("poa");
if(poa==null){
	poa="";
}
String accion=request.getParameter("accion");
if(accion==null){
	accion="";
}%>
<body>
<input type="hidden" id="accion" value="<%=accion%>"/>
<fieldset style="margin:5px">
<legend>Avance de obra</legend>
<div id="div_cabecera">
	<div class="row">
		<div class="span3" style="text-align:right">POA/OT</div>
		<div class="span3"><input name="txt_poa" id="txt_poa_ejecucion" style="width:80px" type="text" value="<%=poa%>" disabled/></div>
		<div class="span3" style="text-align:right">Tipo obra</div>
		<div class="span3"><input name="txt_tipo_obra" id="txt_tipo_obra" style="width:150px" type="text" /></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Zona</div>
		<div class="span2"><input name="txt_zona" id="txt_zona" type="text" /></div>
		<div class="span2" style="text-align:right">Fecha inicio</div>
		<div class="span2"><input type="text" id="txt_fecha_inicio" style="width:120px"/></div>
		<div class="span2" style="text-align:right">Fecha certificacion</div>
		<div class="span2"><input type="text" id="txt_fecha_certificacion" style="width:120px"/></div>
	</div>
	<table width="100%">
		<tr>
			<td width="50%">
					<fieldset>
						<legend>Grupo de trabajo</legend>
                                                     <div style="height: 200px; overflow: auto;">
                                                        <table class="table table-hover table-bordered table-condensed" width="100%" id="tabla_empleado">
                                                            <thead>
                                                                <tr>
                                                                    <th>Apellido</th>
                                                                    <th>Nombre</th>
                                                                    <th>
                                                                        <div id="div_button_add_empleado"><input class="btn  btn-primary" type="button" name="btn_agregar_empleado" value="+" style="height:20px" onclick="javascript:ver_empleados()"></div>
                                                                        <div id="div_empleados" style="display: none;"><tag:ComboEmpleado nombreCombo="cbo_empleado"/><input class="btn  btn-primary" type="button" name="btn_ok_add_empleado" value="si" onclick="javascript:ok_add_empleado()"><input class="btn  btn-primary" type="button" name="btn_close_add_empleado" value="no" onclick="javascript:cancel_add_empleado()"></div></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                              
                                                            </tbody>                               
                                                        </table>
                                                  </div>                
					</fieldset>
				</td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td width="50%">
					<fieldset>
						<legend>Materiales</legend>
                                                 <div style="height: 200px; overflow: auto;">
							<table class="table table-hover table-bordered table-condensed" width="100%" id="tabla_material">
								<thead>
									<tr>
										<th >Material</th>
                                                                                <th> Cantidad</th>
										<th > Stock</th>
										<th> 
                                                                                    <div id="div_button_add_material">
                                                                                        <input class="btn  btn-primary"   type="button" name="btn_agregar_material" value="+" style="height:20px" onclick="javascript:ver_materiales()"/>
                                                                                    </div>
                                                                                    <div id="div_materiales" style="display:none">
                                                                                        <tag:ComboMaterial nombreCombo="cbo_materiales"/>
                                                                                        <input class="btn  btn-primary"   type="button" name="btn_ok_add_material" value="si" onclick="javascript:ok_add_material()"/>
                                                                                        <input class="btn  btn-primary"   type="button" name="btn_close_add_material" value="no" onclick="javascript:cancel_add_material()"/>
                                                                                    </div>    
                                                                                </th> 
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
                                                 </div>                                        
					</fieldset>
			</td>
		</tr>
	</table>
	<div class="row">
		<div class="span2" style="text-align:right">Pendiente</div>
		<div class="span3"><textarea name="txt_pendiente" id="txt_pendiente" style="width: 700px; height: 30px"></textarea></div>	
	</div>
	<fieldset>
		<legend>Desgloce de trabajo</legend>
		<table width="100%">
			<tr>
				<td>Zanjeo</td>
				<td>Rotura</td>
				<td>Cruce</td>
				<td>Pozo Maq</td>	
				<td>Pozo Rec</td>
				<td>Pozo Emp</td>
				<td>Pozo Rulo</td>
				<td>Jornal</td>	
			</tr>
				<td><input name="txt_zanjeo" id="txt_zanjeo" style="width:70px" type="text" /></td>
				<td><input name="txt_rotura" id="txt_rotura" style="width:70px" type="text" /></td>
				<td><input name="txt_cruce" id="txt_cruce" style="width:70px" type="text" /></td>
				<td><input name="txt_pozo_maq" id="txt_pozo_maq" style="width:70px" type="text" /></td>
				<td><input name="txt_pozo_rec" id="txt_pozo_rec" style="width:70px" type="text" /></td>
				<td><input name="txt_pozo_emp" id="txt_pozo_emp" style="width:70px" type="text" /></td>
				<td><input name="txt_pozo_rulo" id="txt_pozo_rulo" style="width:70px" type="text" /></td>
				<td><input name="txt_jornal" id="txt_jornal" style="width:70px" type="text" /></td>
			</tr>
		</table>
		<table width="100%">
			<tr>
				<td width="90%">&nbsp;</td>
				<td>Total</td>
				<td>$1000</td>
			</tr>
		</table>
	</fieldset>
	<div class="row">
		<div class="span2" style="text-align:right">Observaciones</div>
		<div class="span3"><textarea name="txt_observacion" id="txt_observacion" style="width: 700px; height: 30px"></textarea></div>	
	</div>	
	<div class="row">
	    <div class="span3" style="text-align:right"><input type="button" class="btn btn-primary" value="Guardar" onclick="javascript:guardar_registro_avance(document.getElementById('accion').value)"></div>
	</div>
</fieldset>

</body>
<script>
	$(document).ready(function(){
		onload();
	});
</script>
</html>
