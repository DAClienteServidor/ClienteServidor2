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
 * Para que nadie que no se haya logueado pueda acceder
 * @author Nico
 */
@ManagedBean(name = "plantillaController")
@SessionScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if (us==null) {
                context.getExternalContext().redirect("index.xhtml");
            }
            
        } catch (Exception e) {
        }
    }
}
