<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<script type="text/javascript" src="/ENERGTEL/static/js/tipo_obra/tipo_obra.js"></script>

<title>Documento sin t&iacute;tulo</title>
</head>

<body>
<fieldset style="left:20px">
<legend>Administraci&oacute;n de Tipo de obras</legend>
<div id="div_cabecera">
	<div class="row">
		<div class="span2" style="text-align:right">Codigo obra</div>
		<div class="span2"><input type="text" name="txt_obra" id="txt_obra"  style="width:80px" maxlength="9"/></div>
		<div class="span2" style="text-align:right">Descripci&oacute;n</div>
		<div class="span3"><input name="txt_descripcion" id="txt_descripcion" type="text" /></div>
		<div class="span3"><input class="btn  btn-primary"   type="button" name="btn_filtrar" value="Filtrar" />&nbsp; <input class="btn  btn-primary"   type="button" name="btn_nuevo" value="Nuevo"  onclick="javascript:alta()"/></div></div></div>                       
	</div>
<div class="row">
	    <div class="span12">
			<table class="table table-hover table-bordered table-condensed">
                        <thead>
                            <tr>
                                <th >Codigo</th>
                                <th >Descripci&oacute;n</th>
                                <th ></th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr class="success">
                                <td>1</td>
                                <td>Energia</td>
                                <td>
                                    <a href="javascript:verPeticion()">Editar</a>
                                    <a href="javascript:" onclick="eliminarMensaje(210, this);">Eliminar</a>
                                </td>
                            </tr>
							<tr class="error">
                                <td>2</td>
                                <td>Gas</td>
                                <td>
                                    <a href="javascript:verPeticion()">Editar</a>
                                    <a href="javascript:" onclick="eliminarMensaje(210, this);">Eliminar</a>
                                </td>
                            </tr>
							<tr class="success">
                                <td>3</td>
                                <td>Cloaca</td>
                                <td>
                                    <a href="javascript:verPeticion()">Editar</a>
                                    <a href="javascript:" onclick="eliminarMensaje(210, this);">Eliminar</a>
                                </td>
                            </tr>
                            <tr class="error">
                                <td>4</td>
                                <td>Semaforo</td>
                                <td>
                                    <a href="javascript:verPeticion()">Editar</a>
                                    <a href="javascript:" onclick="eliminarMensaje(210, this);">Eliminar</a>
                                </td>
                            
                        </tbody>
                    </table>
	</div>
</div>
</fieldset>
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
	</div>
	<div class="modal-body">
	</div>
</div>

</body>
</html>


