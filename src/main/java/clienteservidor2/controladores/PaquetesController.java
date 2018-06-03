/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.controladores;

import clienteservidor2.dao.PaqueteDAO;
import clienteservidor2.modelo.Paquete;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "PaqController")
@SessionScoped
public class PaquetesController implements Serializable {
    
    @EJB
    private PaqueteDAO ejbPaquete;
    private List<Paquete> paquete;
    
    @PostConstruct
    public void init(){
        paquete = ejbPaquete.findAll();
    }
    
    public List<Paquete> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<Paquete> paquete) {
        this.paquete = paquete;
    }
    

}
