
<div class="well">
		<table width="100%">
			<tr>
				<td><div id="div_logo" style="display:none"><a href="javascript:goPage(6019)"><img src="static/images/logo_energtel.gif" width="300px"/></a> </div>
				</td>
				<% if(request.getSession(false).getAttribute("usr")!=null){ %>
            	<td>
					<div class="navbar">
						<div class="navbar-inner">
							<div class="container">
								<ul class="nav">
									<li class="dropdown">
					
											<li><a href="javascript:goPage(1001)">Empleados</a></li>
										 										
											<li><a href="javascript:goPage(4001)">Obras</a></li>
										  
											<ul class="nav pull-right">
												<li class="dropdown">
											   <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administrar<b class="caret"></b></a>
													<ul class="dropdown-menu">
														<li><a href="javascript:goPage(2001)">Herramientas</a></li>
														<li><a href="javascript:goPage(2002)">Materiales</a></li>
														<li><a href="javascript:goPage(2003)">Categor&iacute;as</a></li>
														<li><a href="javascript:goPage(2004)">Tipo Obra</a></li>
														<li><a href="javascript:goPage(2005)">Especificaciones</a></li>
														<li><a href="javascript:goPage(2006)">Formas de obra</a></li>
														<li><a href="javascript:goPage(2007)">Tareas</a></li>
													</ul>
												</li>
											</ul>
									
								</ul>					
							</div>
						</div>
					</div>
				</td>
				<%}%>
				<td>
					<%@include file="../sicnod/display/login.jsp" %>
				</td>
			</tr> 
			
		</table>
</div>
<script>
	$( document ).ready(function() {
		$("#div_logo").show("slow");
	}); 
</script>
