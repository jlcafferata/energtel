<html>
    <head>
        <%@include file="jsp/includes/metas_inc.jsp" %>
       
        <title>ENERGTEL S.A.</title>
    </head>
    <body>
            <div class="row-fluid">
                <div class="span12">
                    <div class="well">
                            <table>
                                <tr>
                                    <td style=" width: 600px;"><a href="javascript:goPage(6019)">
										<img src="static/images/logo_energtel.gif" width="500px"/></a>
                                         
                                    </td>
                                    <td>
                                    	<%@include file="jsp/sicnod/display/login.jsp" %>
                                    </td>
                                </tr> 
                            </table>
                            <div style="background-image:url(static/images/fondo.png); height: 100px;"></div>
                    </div>
                </div>
                <a name="miancla"></a>
            </div>
       <div class="row" >
                <div class="span2">
                    <div class="well">
                     <ul class="nav nav-list"> 
                         <li class="nav-header">Nosotros</li> 
                         <li class="divider"></li>
                         <li><a class="goTop" href="javascript:goPage(6001)">Quienes somos? </a></li>
                         <li><a class="goTop" href="javascript:goPage(6002)">Nuestros logros </a></li>
                     </ul>
                    </div>
     			</div>
                <div class="span10" id="div_screen">
                    <%@include file="jsp/display/informativo/portada.jsp" %>
				</div>
         </div> 
		<div id="div_pie" style="position:fixed; bottom:0; width:100%">
		    <%@include file="jsp/includes/pie_inc.jsp" %> 
		</div>
               
    </body>
</html>
