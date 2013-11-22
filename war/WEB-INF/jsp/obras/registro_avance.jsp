<%@page import="org.isft.logic.collection.CollectionDetalleObra, java.util.HashMap, java.util.Vector, org.isft.domain.DetalleObra"%>
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
}
String fecha_certificada=request.getParameter("fecha_certificada");
if(fecha_certificada==null){
	fecha_certificada="";
}
String hora_cargada=request.getParameter("hora_cargada");
if(hora_cargada==null){
	hora_cargada="";
}
String cod_zona=request.getParameter("cod_zona");
if(cod_zona==null){
	cod_zona="";
}
String cod_tipo_obra=request.getParameter("cod_tipo_obra");
if(cod_tipo_obra==null){
	cod_tipo_obra="";
}

String tareas_pendientes=request.getParameter("tareas_pendientes");
if(tareas_pendientes==null){
	tareas_pendientes="";
}

String fecha_completa_certificada="";
if(fecha_certificada!=""&&hora_cargada!=""){
    String fecha_alreves=fecha_certificada.substring(3,5)+"/"+fecha_certificada.substring(0,2)+"/"+fecha_certificada.substring(6,10);
    fecha_completa_certificada=fecha_alreves+" "+hora_cargada;
}
DetalleObra obra=new DetalleObra();
if(!poa.equals("")){
HashMap param=new HashMap();
param.put("poa", poa);
CollectionDetalleObra collection=new CollectionDetalleObra();
Vector<DetalleObra> vecObra=collection.select(param);
obra=vecObra.get(0);
}
%>
<body>   
<input type="hidden" id="accion" value="<%=accion%>"/>
<fieldset style="margin:5px">
<legend>Avance de obra</legend>
<div id="div_cabecera">
	<div class="row">
		<div class="span3" style="text-align:right">POA/OT</div>
		<div class="span3"><input name="txt_poa" id="txt_poa_ejecucion" style="width:80px" type="text" value="<%=poa%>" disabled/></div>
		<div class="span3" style="text-align:right">Tipo obra</div>

		<div class="span3"><tag:ComboTipoObra nombreCombo="cbo_tipo_obra_aejecucion" selecto="<%=obra.getCod_tipo_obra()%>"/></div>
	</div>
	<div class="row">
		<div class="span3" style="text-align:right">Zona</div>
		<div class="span3"><tag:ComboZona nombreCombo="cbo_zona_obra_aejecucion" selecto="<%=obra.getCod_zona()%>"/></div>
		<div class="span1" style="display: none;">Fecha inicio</div>
		<div class="span2" style="display: none;"><input type="text" id="txt_fecha_inicio" style="width:120px" value="<%=obra.getFecha_inicio()%>"/></div>
		<div class="span3" style="text-align:right">Fecha certificacion</div>
		<div class="span3" id="div_combo_fecha_certificacion"><input type="text" id="txt_fecha_certificacion" style="width:120px"/></div>
                <div class="span3" id="div_txt_fecha_certificacion" style="display:none"><input type="text" id="txt_fecha_certificacion" style="width:160px" value="<%=fecha_completa_certificada%>" disabled/></div>
	</div>
	<table width="100%">
		<tr>
			<td width="50%">
					<fieldset>
						<legend>Grupo de trabajo</legend>
                                                     <div style="height: 150px; overflow: auto;">
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
                                                            
                                                            <tbody id="empleados_tbody">
                                                                <tag:GrillaEmpleadosAvancesPrevios poa="<%=poa%>" fecha_certificada="<%=fecha_certificada%>" hora_cargada="<%=hora_cargada%>" />
                                                            </tbody>     
                                                            
                                                        </table>
                                                  </div>                
					</fieldset>
				</td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td width="50%">
					<fieldset>
						<legend>Materiales</legend>
                                                 <div style="height: 150px; overflow: auto;">
							<table class="table table-hover table-bordered table-condensed" width="100%" id="tabla_material">
								<thead>
									<tr>
										<th> Material</th>
                                                                                <th> Cantidad propio</th>
										<th> Stock propio </th>
                                                                                <th> Cantidad provisto</th>
                                                                                <th> Stock Provisto</th>
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
                                                                    <tag:GrillaMaterialesAvancesPrevios poa="<%=poa%>" fecha_certificada="<%=fecha_certificada%>" hora_cargada="<%=hora_cargada%>" />
								</tbody>
							</table>
                                                 </div>                                        
					</fieldset>
			</td>
		</tr>
	</table>
	<div class="row">
		<div class="span2" style="text-align:right">Pendiente</div>
		<div class="span3"><textarea name="txt_pendiente" id="txt_pendiente" style="width: 700px; height: 30px" value="<%=tareas_pendientes%>"><%=tareas_pendientes%></textarea></div>	
	</div>
	<fieldset>
		<legend>Desgloce de trabajo</legend>
		<div style="height: 150px; overflow: auto;">
                        <table class="table table-hover table-bordered table-condensed" width="100%" id="tabla_tareas">
                                <thead>
                                        <tr>
                                                <th > Tarea </th>
                                                <th> Cantidad</th>
                                                <th> 
                                                    <div id="div_button_add_tarea">
                                                        <input class="btn  btn-primary"   type="button" name="btn_agregar_tarea" value="+" style="height:20px" onclick="javascript:ver_tarea()"/>
                                                    </div>
                                                    <div id="div_tarea" style="display:none">
                                                        <tag:ComboTarea nombreCombo="cbo_tarea"/>
                                                        <input class="btn  btn-primary"   type="button" name="btn_ok_add_tarea" value="si" onclick="javascript:ok_add_tarea()"/>
                                                        <input class="btn  btn-primary"   type="button" name="btn_close_add_tarea" value="no" onclick="javascript:cancel_add_tarea()"/>
                                                    </div>    
                                                </th> 
                                        </tr>
                                </thead>
                                <tbody>
                                    <tag:GrillaTareasAvancesPrevios poa="<%=poa%>" fecha_certificada="<%=fecha_certificada%>" hora_cargada="<%=hora_cargada%>" />
                                </tbody>
                        </table>
                 </div>
	</fieldset>
	<div class="row">
            <div id="div_observaciones">
		<div class="span2" style="text-align:right">Observaciones</div>
		<div class="span6"><textarea name="txt_observacion" id="txt_observacion" style="width: 500px; height: 30px"></textarea></div>
                Total $<div class="span4" id="div_total"></div>
	</div>	
	<div class="row">
	    <div class="span3" style="text-align:right" id="boton_guardar"><input type="button" class="btn btn-primary" value="Guardar" onclick="javascript:guardar_registro_avance(document.getElementById('accion').value)"></div>
            <div class="span3" style="text-align:right" id="boton_avaces_previos"><a class="btn btn-default my-link" href="javascript: irAvancesPrevios(<%=poa%>,<%=cod_tipo_obra%>,<%=cod_zona%>)">Avances Previos</a></div>
	</div>
</fieldset>

</body>
<script>
	$(document).ready(function(){
		onload();
	});
</script>
</html>
