<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<script type="text/javascript" src="/ENERGTEL/static/js/obras/avances_previos.js"></script>
<%
String poa=request.getParameter("poa");
if(poa==null){
	poa="";
}
String fecha=request.getParameter("fecha");
if(fecha==null){
	fecha="";
}
String cod_zona=request.getParameter("cod_zona");
if(cod_zona==null){
	cod_zona="";
}
String cod_tipo_obra=request.getParameter("cod_tipo_obra");
if(cod_tipo_obra==null){
	cod_tipo_obra="";
}


%>

<div id="buscar_avance" class="span11">
    <input type="hidden" id="accion" value=""/>
    <fieldset>
        <legend>Filtros</legend>
        <div>
            <div class="span1" style="text-align:right" >POA</div>
            <div class="span1"><input type="text" id="txt_poa_avances_previos"  style="width:80px" maxlength="9" value="<%=poa%>" disabled/></div>
            <div class="span1" style="text-align:right">Fecha</div>
            <div class="span2"><input type="text" id="txt_fecha_avances_previos" style="width:120px" value="<%=fecha%>"/></div>
            <div class="span3"><tag:ComboTipoObra nombreCombo="cbo_tipo_obra_previo" selecto="<%=cod_tipo_obra%>" disabled="TRUE"/></div>
            <div class="span3"><tag:ComboZona nombreCombo="cbo_zona_obra_previo" selecto="<%=cod_zona%>" disabled="TRUE"/></div>
            <div class="span1"><input class="btn  btn-primary" type="button" name="btn_filtrar" value="Filtrar" onclick="javascript:filtrar()"></div>
        </div>
    </fieldset>
    
    <fieldset>
        <legend>Avances Previos</legend>
        <div class="span11">
            <tag:GrillaAvancesPrevios poa="<%=poa%>" fecha="<%=fecha%>"/>
        </div>
    </fieldset>
</div>
    









<script>
	$(document).ready(function(){
		onload();
	});
</script>