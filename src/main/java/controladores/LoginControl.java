/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clienteservidor2.implementacion.UsuariosImplementacion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author usuario
 */
@ManagedBean(name="usuarios")
@SessionScoped
public class LoginControl {
    private String usu;
    private String psw;
    
    public String loginControl(){
        UsuariosImplementacion u = new UsuariosImplementacion();
        if (u.loginControl(usu, psw)){
            return "principal";
        }
        return "welcomePrimefaces";
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
    
    
}
