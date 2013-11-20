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
%>

<div id="buscar_avance" class="span11">
    <input type="hidden" id="accion" value=""/>
    <fieldset>
        <legend>Filtros</legend>
        <div>
            <div class="span2" style="text-align:right" >POA</div>
            <div class="span2"><input type="text" id="txt_poa_avances_previos"  style="width:80px" maxlength="9" value="<%=poa%>" disabled/></div>
            <div class="span2" style="text-align:right">Fecha</div>
            <div class="span2"><input type="text" id="txt_fecha_avances_previos" style="width:120px"/></div>
            <div class="span3"><input class="btn  btn-primary" type="button" name="btn_filtrar" value="Filtrar" onclick="javascript:filtrar()"></div>
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