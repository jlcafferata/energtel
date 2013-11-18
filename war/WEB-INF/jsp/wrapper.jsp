
<html>
    <head>
        <%@include file="includes/metas_inc.jsp" %>
        <title>Wrapper</title>
    </head>
    <body>
        
            <%@include file="includes/encabezado_inc.jsp" %>
            <div  id="div_screen">
            </div>
           
		<div id="div_pie" style="position:fixed; bottom:0; width:100%">
		    <%@include file="includes/pie_inc.jsp" %> 
		</div>            
        
		<div id="myMessage" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 30%; left: 70%; top:50%; margin-left: 0px; height: 300px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					</div>
					<div class="modal-body-message"></div>
		</div>		
			
    </body>

<% if(request.getSession(false).getAttribute("usr")!=null){ %>
    <script>
	$(document).ready(function(){
		/*$('.modal-body-message').load("jsp/display/ayuda_memoria.jsp");
		$('#myMessage').modal('show');
		*/});
</script>
<%}%>
</html>
