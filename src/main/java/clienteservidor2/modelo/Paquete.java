/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable{

    private static final long serialVersionUID = 1L;

//properties--------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaquete")
    private Integer idPaquete;
    
    @Column(name = "fecha_F")
    @Temporal(TemporalType.DATE)
    private Date fechaF;
    
    @Column(name = "fecha_I")
    @Temporal(TemporalType.DATE)
    private Date fechaI;
    
    @Max(value=2)
    @Column(name = "costo_tot")
    private Double costoTot;
    
    @Size(max = 45)
    @Column(name = "forma_pago")
    private String formaPago;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    
    @Column(name = "permitido")
    private Boolean permitido;
    
    @Column(name = "can_personas")
    private Integer canPersonas;
    
    @JoinTable(name = "tiene", joinColumns = {
        @JoinColumn(name = "Paquete_idPaquete", referencedColumnName = "idPaquete")}, inverseJoinColumns = {
        @JoinColumn(name = "componentes_codComponente", referencedColumnName = "codComponente")})
    @ManyToMany
    private List<Componentes> componentesList;
    
    @JoinColumn(name = "Usuarios_dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuarios usuariosdni;

    //getters/setters---------------------------------
    
    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Double getCostoTot() {
        return costoTot;
    }

    public void setCostoTot(Double costoTot) {
        this.costoTot = costoTot;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Boolean getPermitido() {
        return permitido;
    }

    public void setPermitido(Boolean permitido) {
        this.permitido = permitido;
    }

    public Integer getCanPersonas() {
        return canPersonas;
    }

    public void setCanPersonas(Integer canPersonas) {
        this.canPersonas = canPersonas;
    }

    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }

    public Usuarios getUsuariosdni() {
        return usuariosdni;
    }

    public void setUsuariosdni(Usuarios usuariosdni) {
        this.usuariosdni = usuariosdni;
    }
    
}
