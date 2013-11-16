<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>

<script type="text/javascript" src="/ENERGTEL/static/js/obras/en_ejecucion.js"></script>

<div class="row-fluid">
	<div class="span12"> 
		<ul class="nav nav-tabs">
			<li><a href="javascript:goPage(4001)">Presupuestadas</a></li>
            <li class="active"><a href="javascript:goPage(4002)">En ejecuci&oacute;n</a></li>
            <li><a href="javascript:goPage(4003)">Certificadas</a></li>
            <li><a href="javascript:goPage(4004)">Facturadas</a></li>
			<li><a href="javascript:goPage(4005)">Cobradas</a></li>        </ul>
    </div>
</div>

<div id="w" class="container center">
	<div class="row-fluid">
		<div class="span12">
			<div id="div_cabecera">
				<div class="row">
					<div class="span1" style="text-align:right">POA</div>
					<div class="span1"><input type="text" name="txt_poa" id="txt_poa"  style="width:80px" maxlength="9"/></div>
					<div class="span1" style="text-align:right">Tipo obra</div>
					<div class="span2"><tag:ComboTipoObra nombreCombo="cbo_tipo_obra"/></div>
					<div class="span1" style="text-align:right">Desde</div>
					<div class="span2"><input type="text" id="txt_fecha_desde" style="width:120px"/></div>
					<div class="span1" style="text-align:right">Hasta</div>
					<div class="span2"><input type="text" id="txt_fecha_hasta" style="width:120px"/></div>
					<div class="span1"><input class="btn  btn-primary"   type="button" name="btn_filtrar" value="Filtrar" /></div>                       
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<tag:GrillaDetalleObra pagina="EN_EJECUCION"/>
				</div>
			</div>
						
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:80%; left:10%; margin-left:0px; height:550px; max-height:550px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					</div>
					<div class="modal-body" style="max-height: 550px;"></div>
			</div>			
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		onload();
	});
</script>
