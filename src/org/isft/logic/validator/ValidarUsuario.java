
package org.isft.logic.validator;
import org.isft.domain.Usuario;
import java.util.Vector;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

//import org.isft.domain.Rol;
public class ValidarUsuario {
    public ValidarUsuario(){};
    
    public boolean isUsuarioValido(Usuario usuario, HttpServletRequest request){
        boolean returnValue = false;
        try{
            ChequearLogin chequear=new ChequearLogin();
            Usuario usr=chequear.usuarioValido(usuario);
					  request.getSession(false).setAttribute("usr", usr);
					  returnValue=(usr!=null);					  
            System.out.println("USUARIO VALIDO: "+returnValue);
        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
        return returnValue;
    }
   
}
