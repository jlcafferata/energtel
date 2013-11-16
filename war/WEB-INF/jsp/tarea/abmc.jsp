<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script type="text/javascript" src="/ENERGTEL/static/js/tarea/tarea.js"></script>

<title>Documento sin t&iacute;tulo</title>
</head>

<body>
<fieldset style="left:20px">
<legend>Administraci&oacute;n de Tareas</legend>
<div id="div_cabecera">
	<div class="row">
		<div class="span2" style="text-align:right">Codigo tarea</div>
		<div class="span1"><input type="text" name="txt_tarea" id="txt_tarea"  style="width:80px" maxlength="9"/></div>
		<div class="span2" style="text-align:right">Descripci&oacute;n</div>
		<div class="span3"><input name="txt_descripcion" id="txt_descripcion" type="text" /></div>
		<div class="span2"><input class="btn  btn-primary"   type="button" name="btn_filtrar" value="Filtrar" />&nbsp; <input class="btn  btn-primary"   type="button" name="btn_nuevo" value="Nueva"  onclick="javascript:alta()"/></div></div></div>                       
	</div>
<div class="row">
	    <div class="span12">
			<table class="table table-hover table-bordered table-condensed" width="99%">
                        <thead>
                            <tr>
                                <th >Codigo</th>
                                <th >Descripci&oacute;n</th>
                                <th >Precio</th>
								<th ></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="success">
                                <td>1</td>
                                <td>Zanjeo</td>
								<td>$50</td>
                                <td>
                                    <a href="javascript:verTarea(1)">Editar</a>&nbsp;&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
							<tr class="error">
                                <td>2</td>
                                <td>Rotura</td>
								<td>$50</td>
                                <td>
                                    <a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
							<tr class="success">
                                <td>3</td>
                                <td>Cruce</td>
                                <td>$50</td>
								<td>
                                    <a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
                            <tr class="error">
                                <td>4</td>
                                <td>Pozo maq</td>
								<td>$50</td>
                                <td>
                                    <a href="javascript:verPeticion()">Editar</a>&nbsp;
                                    <a href="javascript:" onclick="eliminarMensaje(210, this);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
							<tr class="success">
                                <td>5</td>
                                <td>Pozo rec</td>
								<td>$50</td>
                                <td>
									<a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;                                
								</td>
                            </tr>
                            </tr>
							<tr class="error">
                                <td>6</td>
                                <td>Pozo emp</td>
								<td>$50</td>
                                <td>
 	                               <a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
							<tr class="success">
                                <td>7</td>
                                <td>Pozo rulo</td>
								<td>$50</td>
                                <td>
								    <a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;                            
								</td>
                            </tr>
							<tr class="error">
                                <td>8</td>
                                <td>Jornal</td>
								<td>$50</td>
                                <td>
                                    <a href="javascript:verTarea(1)">Editar</a>&nbsp;
									<a href="javascript:verHistorial(1)">Ver historial</a>&nbsp;
                                    <a href="javascript:" onclick="bajaTarea(1);">Eliminar</a>&nbsp;
                                </td>
                            </tr>
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

