<%@page import="org.isft.logic.collection.EjemploConexion, org.isft.domain.Usuario, org.isft.logic.validator.ValidarUsuario, java.util.Vector,java.util.HashMap, java.util.ResourceBundle"%>
<%

String txt_usuario  = request.getParameter("txt_usuario");
String txt_password = request.getParameter("txt_password");

String txt_mensaje = "";

if( txt_usuario==null && txt_password==null ||  txt_usuario.equals("") && txt_password.equals("") ){
    txt_mensaje = "todo_incompleto";
}else if(txt_usuario.equals(null) || txt_usuario.trim().equals("")){
    txt_mensaje = "usuario_incompleto";
}else if(txt_password.equals(null) || txt_password.trim().equals("")){
    txt_mensaje = "password_incompleto";
}else{
    Usuario usr = new Usuario();
    usr.setUsr(txt_usuario);
    usr.setPwd(txt_password);

    ValidarUsuario validarUsuario = new ValidarUsuario();
    
    if(validarUsuario.isUsuarioValido(usr, request)){
        txt_mensaje = "ok";
        %>
        <script>window.location.href = 'modulo.go?codPage=6000';</script>
        <%
        
    }else{
        txt_mensaje = "datos_invalidos";%>
        <script>
                    var url = "/ENERGTEL/index.jsp?result_login=<%= txt_mensaje %>";
                    window.location.href =url;
        </script>
    <%
    }
}
%>
