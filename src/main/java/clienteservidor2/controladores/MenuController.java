/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.controladores;

import clienteservidor2.modelo.Usuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Controla el login del usuario y el cerrar sesion 
 * @author Nico
 */

@ManagedBean(name = "menuController")
@SessionScoped
public class MenuController implements Serializable{

    public String seleccionarMenu(){
        FacesContext context = FacesContext.getCurrentInstance();
        Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
        if (us != null) {
            return "./menuRegistrado.xhtml";
        }
        return "./menuNoRegistrado.xhtml";
    }
    
    public String getNombre(){
        FacesContext context = FacesContext.getCurrentInstance();
        Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
        return us.getNombre()+" "+us.getApellido();
    }
    
}