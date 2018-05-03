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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "componentes")
public class Componentes implements Serializable {

    private static final long serialVersionUID = 1L;

 // Poropoeties------------------------
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codComponente")
    private Integer codComponente;
    
    @Column(name = "costo")
    private Double costo;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToMany(mappedBy = "componentesList")
    private List<Paquete> paqueteList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "componentes")
    private Estadia estadia;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "componentes")
    private Entretenimiento entretenimiento;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "componentes")
    private Pasajes pasajes;

    // getters/setters--------------------------
    public Integer getCodComponente() {
        return codComponente;
    }

    public void setCodComponente(Integer codComponente) {
        this.codComponente = codComponente;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Entretenimiento getEntretenimiento() {
        return entretenimiento;
    }

    public void setEntretenimiento(Entretenimiento entretenimiento) {
        this.entretenimiento = entretenimiento;
    }

    public Pasajes getPasajes() {
        return pasajes;
    }

    public void setPasajes(Pasajes pasajes) {
        this.pasajes = pasajes;
    }

}
