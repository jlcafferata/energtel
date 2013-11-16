
package org.isft.domain;

public class Usuario {
    private String usr;
    private String pwd;
    private String nombre;
    private String apellido;
    private int rol;
    public Usuario(){}

    public String getUsr() {
        return usr;
    }
    public void setUsr(String usr) {
        this.usr = usr;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getRol() {
        return rol;
    }
    public void setRol(int rol) {
        this.rol = rol;
    }
}
