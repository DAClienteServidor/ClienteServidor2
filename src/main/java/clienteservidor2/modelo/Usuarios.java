/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    
    	private static final long serialVersionUID = 1L;
   
   // Properties------------------------
    @Id
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
   
    @NotNull
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    
    @NotNull
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    
    @NotNull
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    
    @NotNull
    @Size(max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    
    @NotNull
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    
    @Size(max = 45)
    @Column(name = "Usuarioscol")
    private String usuarioscol;
    
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosdni")
    private List<Paquete> paqueteList;

   // getters/setters --------------------------

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuarioscol() {
        return usuarioscol;
    }

    public void setUsuarioscol(String usuarioscol) {
        this.usuarioscol = usuarioscol;
    }


}
