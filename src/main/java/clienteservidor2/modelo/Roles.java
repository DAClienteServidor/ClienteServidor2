/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    //Properties----------------------------------
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clave")
    private Integer clave;
    
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @JoinTable(name = "cumple", joinColumns = {
        @JoinColumn(name = "Roles_clave", referencedColumnName = "clave")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuarios_dni", referencedColumnName = "dni")})
    @ManyToMany
    private List<Usuarios> usuariosList;

// getters/setters-------------------------------

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setRolesList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }


    
}
