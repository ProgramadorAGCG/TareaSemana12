package com.ucs.sistemas.appsesion11.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    //atributos
    int id;
    String usuario;
    String password;
    //métodos de acceso get/set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
