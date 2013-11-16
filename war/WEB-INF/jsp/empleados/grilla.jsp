<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
<%String incluir_lista_espera=request.getParameter("incluir_lista_espera");
if(incluir_lista_espera==null){
	incluir_lista_espera="N";
}
String fecha_desde_alta=request.getParameter("fecha_desde_alta");
if(fecha_desde_alta==null){
    fecha_desde_alta="";
}
String fecha_desde_baja=request.getParameter("fecha_desde_baja");
if(fecha_desde_baja==null){
    fecha_desde_baja="";
}
String fecha_hasta_alta=request.getParameter("fecha_hasta_alta");
if(fecha_hasta_alta==null){
    fecha_hasta_alta="";
}
String fecha_hasta_baja=request.getParameter("fecha_hasta_baja");
if(fecha_hasta_baja==null){
    fecha_hasta_baja="";
}
String legajo=request.getParameter("legajo");
if(legajo==null){
    legajo="";
}
String apellido=request.getParameter("apellido");
if(apellido==null){
    apellido="";
}
String nombre=request.getParameter("nombre");
if(nombre==null){
    nombre="";
}
String dni=request.getParameter("dni");
if(dni==null){
    dni="";
}
%>
<tag:GrillaEmpleados incluir_lista_espera="<%=incluir_lista_espera%>" fecha_hasta_baja="<%=fecha_hasta_baja%>" fecha_desde_baja="<%=fecha_desde_baja%>" fecha_desde_alta="<%=fecha_desde_alta%>" fecha_hasta_alta="<%=fecha_hasta_alta%>" nombre="<%=nombre%>" apellido="<%=apellido%>" dni="<%=dni%>" legajo="<%=legajo%>"/>