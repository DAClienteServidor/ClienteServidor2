/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "entretenimiento")
public class Entretenimiento implements Serializable {

    private static final long serialVersionUID = 1L;

//properties-----------------------------
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "cod", referencedColumnName = "codComponente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Componentes componentes;

    //getters/setters--------------------------------
    
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
    }

    
}
