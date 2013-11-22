<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>

<%
String cbo_zona_obra=request.getParameter("cbo_zona_obra");
if(cbo_zona_obra==null){
	cbo_zona_obra="";
}
String cbo_tipo_obra=request.getParameter("cbo_tipo_obra");
if(cbo_tipo_obra==null){
	cbo_tipo_obra="";
}
String txt_poa=request.getParameter("txt_poa");
if(txt_poa==null){
	txt_poa="";
}
%>

<script type="text/javascript" src="/ENERGTEL/static/js/obras/certificada.js"></script>

<div class="row-fluid">
	<div class="span12"> 
		<ul class="nav nav-tabs">
			<li><a href="javascript:goPage(4001)">Presupuestadas</a></li>
            <li><a href="javascript:goPage(4002)">En ejecuci&oacute;n</a></li>
            <li class="active"><a href="javascript:goPage(4003)">Certificadas</a></li>
            <li><a href="javascript:goPage(4004)">Facturadas</a></li>
			<li><a href="javascript:goPage(4005)">Cobradas</a></li>        </ul>
        </ul>
    </div>
</div>

<div id="w" class="container center">
	<div class="row-fluid">
		<div class="span12">
			<div id="div_cabecera">
				<div class="row">
					<div class="span1" style="text-align:right">POA</div>
					<div class="span2"><input type="text" name="txt_poa" id="txt_poa"  style="width:80px" maxlength="9" value="<%=txt_poa%>"/></div>
					<div class="span1" style="text-align:right">Tipo obra</div>
					<div class="span2"><tag:ComboTipoObra nombreCombo="cbo_tipo_obra" selecto="<%=cbo_tipo_obra%>"/></div>
					<div class="span1" style="text-align:right">Zona</div>
					<div class="span3"><tag:ComboZona nombreCombo="cbo_zona_obra" selecto="<%=cbo_zona_obra%>"/></div>
					<div class="span2"><input class="btn  btn-primary"   type="button" name="btn_filtrar" value="Filtrar" onclick="filtrar()"/></div>                       
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<tag:GrillaDetalleObra pagina="CER"  zona="<%=cbo_zona_obra%>" poa="<%=txt_poa%>" tipo_obra="<%=cbo_tipo_obra%>"/>
				</div>
			</div>
						
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:80%; left:10%; margin-left:0px; height:510px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					</div>
					<div class="modal-body"></div>
			</div>			
		</div>
	</div>
</div>