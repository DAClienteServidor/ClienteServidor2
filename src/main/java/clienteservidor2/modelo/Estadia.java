/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "estadia")
public class Estadia implements Serializable {

    private static final long serialVersionUID = 1L;

   //Properties------------------------------------------ 
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "estrellas")
    private Integer estrellas;
    
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    
    @JoinColumn(name = "cod", referencedColumnName = "codComponente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Componentes componentes;

   //getters/setters-----------------------------
    
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
    }

    
}
