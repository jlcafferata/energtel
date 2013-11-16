<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<%@ page import="org.isft.logic.collection.CollectionDetalleObra, java.util.HashMap, java.util.Vector, org.isft.domain.DetalleObra, org.isft.domain.helper.FechaHora"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<title>Documento sin t&iacute;tulo</title>
</head>
<%String accion=request.getParameter("accion");
if(accion==null){
	accion="";
}
String modalidad=request.getParameter("modalidad");
if(modalidad==null){
	modalidad="";
}
String poa=request.getParameter("poa");

if(poa==null){
	poa="";
}

HashMap param=new HashMap();
param.put("poa", poa);
DetalleObra detalleObra=new DetalleObra();

if(!accion.equals("")){
	CollectionDetalleObra detallesObra=new CollectionDetalleObra();
	Vector<DetalleObra> vec=detallesObra.select(param);
	if(vec.size()>0){
		detalleObra=vec.get(0);
	}
}
%>
<body>
<input type="hidden" id="accion" value="<%=accion%>"/>
<input type="hidden" id="modalidad" value="<%=modalidad%>"/>
<div id="div_cabecera" style="margin:10px">
	<div class="row">
		<div class="span2" style="text-align:right">POA/OT</div>
		<div class="span3"><input type="text" name="txt_poa_alta" id="txt_poa_alta"  value="<%=poa%>" style="width:80px" maxlength="9" <%if(modalidad.equals("M")){%> disabled <%}%>/></div>
		<div class="span2" style="text-align:right">C.U.I.T cliente</div>
		<div class="span3"><input name="txt_cuil" id="txt_cuil" type="text" value="<%=detalleObra.getCuit_cliente()%>" maxlength="13" style="width:120px"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Fecha inicio obra</div>
		<div class="span3"><input name="txt_fecha_alta_alta" id="txt_fecha_alta_presupuestada" type="text" value="<%=FechaHora.getFechaView(detalleObra.getFecha_inicio())%>"/></div>
		<div class="span2" style="text-align:right">Fecha cierre obra</div>
		<div class="span3"><input name="txt_fecha_cierre" id="txt_fecha_cierre_presupuestada" type="text" value="<%=FechaHora.getFechaView(detalleObra.getFecha_cierre())%>"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Fecha certificaci&oacute;n</div>
		<div class="span3"><input name="txt_fecha_certificacion" id="txt_fecha_certificacion_presupuestada" type="text" value="<%=FechaHora.getFechaView(detalleObra.getFecha_certificacion())%>"/></div>
		<div class="span2" style="text-align:right">Zona</div>
		<div class="span3"><tag:ComboZona nombreCombo="cbo_zona_obra_alta" selecto="<%=detalleObra.getCod_zona()%>"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Tipo de obra</div>
		<div class="span3"><tag:ComboTipoObra nombreCombo="cbo_tipo_obra_alta" selecto="<%=detalleObra.getCod_tipo_obra()%>"/></div>
		<div class="span2" style="text-align:right">Medici&oacute;n estimada</div>
		<div class="span3"><input name="txt_medicion_estimada" id="txt_medicion_estimada_presupuestada" type="text" style="width:80px" value="<%=detalleObra.getMedicion_estimada()%>"/> metros lineales</div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Especificaci&oacute;n</div>
		<div class="span3"><tag:ComboEspecificacionObra nombreCombo="cbo_especificacion_obra" selecto="<%=detalleObra.getCod_especificacion()%>"/></div>
        <div class="span2" style="text-align:right">Forma de obra</div>
		<div class="span1"><tag:ComboFormaObra nombreCombo="cbo_forma_obra" selecto="<%=detalleObra.getCod_forma_obra()%>"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Fecha de pago</div>
		<div class="span3"><input name="txt_fecha_pago" id="txt_fecha_pago" type="text" value="<%=FechaHora.getFechaView(detalleObra.getFecha_facturacion())%>"/></div>
        <div class="span2" style="text-align:right">Nro. Recibo</div>
		<div class="span1"><input name="txt_nro_recibo" id="txt_nro_recibo_presupuestada" type="text" value="<%=detalleObra.getNro_recibo()%>"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Nro. orden compra</div>
		<div class="span3"><input name="txt_nro_orden_compra" id="txt_nro_orden_compra_presupuestada" type="text" value="<%=detalleObra.getOrden_compra()%>"/></div>
        <div class="span2" style="text-align:right">Valor orden compra $</div>
		<div class="span1"><input name="txt_orden_compra" id="txt_valor_orden_compra_presupuestada" type="text" value="<%=detalleObra.getValor_orden_compra()%>"/></div>
	</div>
	<div class="row">
		<div class="span2" style="text-align:right">Observaciones</div>
		<div class="span3"><textarea name="txt_observacion" id="txt_observacion_presupuestadas" style="width: 515px; height: 69px"></textarea></div>	
	</div>
	<div class="row">
	    <div class="span3" style="text-align:right"><input type="button" class="btn btn-primary" value="Guardar" onclick="javascript:guardar(document.getElementById('accion').value, document.getElementById('modalidad').value)"></div>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="/ENERGTEL/static/js/obras/seguimiento.js"></script>
<script>
	$(document).ready(function(){
		onload();		
	});
</script>
